package com.example.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@WebMvcTest
class ApiControllersTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var limitOrderRepository: LimitOrderRepository

    @MockkBean
    lateinit var orderService: OrderService

    @MockkBean
    lateinit var tradeService: TradeService

    @Test
    fun `Get Order by uniqueId should return limit order with 200 status`() {
        val limitOrder1 = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1200", "10", "buy", "ashdj0021", "new")

        every { limitOrderRepository.findByUniqueId("1234-abcd-5678") } returns limitOrder1

        mockMvc.perform(get("/api/orders/1234-abcd-5678").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.uniqueId").value(limitOrder1.uniqueId))
    }

    @Test
    fun `For not present id Get Order by uniqueId should return no response with 200 status`() {
        val limitOrder1 = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1200", "10", "buy", "ashdj0021", "new")

        every { limitOrderRepository.findByUniqueId("1234-abcd-5678") } returns limitOrder1
        every { limitOrderRepository.findByUniqueId("9012-efgh-3456") } returns null

        mockMvc.perform(get("/api/orders/9012-efgh-3456").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$").doesNotExist())
    }

    @Test
    fun `Get Orderbook should return List of limit orders with 200 status`() {
        val limitOrder1 = LimitOrder("9012-efgh-3456", "3", "BTCZAR", "1000", "12", "sell", "abs991", "new")
        val limitOrder2 = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1200", "10", "sell", "03991kl", "new")
        val limitOrder3 = LimitOrder("7890-ijkl-1234", "3", "BTCZAR", "1050", "8", "buy", "abs992", "new")
        val limitOrder4 = LimitOrder("5678-mnop-9012", "2", "BTCZAR", "1100", "15", "buy", "03991aj", "new")

        every {orderService.getByPair("BTCZAR") } returns mutableMapOf("Asks" to listOf(limitOrder1, limitOrder2), "Bids" to listOf(limitOrder4, limitOrder3))

        mockMvc.perform(get("/api/orders/BTCZAR/orderbook").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.Asks").isArray)
            .andExpect(jsonPath("\$.Asks").isNotEmpty)
            .andExpect(jsonPath("\$.Bids").isArray)
            .andExpect(jsonPath("\$.Bids").isNotEmpty)
            .andExpect(jsonPath("\$.Asks[0].uniqueId").value(limitOrder1.uniqueId))
            .andExpect(jsonPath("\$.Asks[1].uniqueId").value(limitOrder2.uniqueId))
            .andExpect(jsonPath("\$.Bids[0].uniqueId").value(limitOrder4.uniqueId))
            .andExpect(jsonPath("\$.Bids[1].uniqueId").value(limitOrder3.uniqueId))
            .andExpect(jsonPath("\$.Asks[0].pair").value("BTCZAR"))
            .andExpect(jsonPath("\$.Asks[1].pair").value("BTCZAR"))
            .andExpect(jsonPath("\$.Bids[0].pair").value("BTCZAR"))
            .andExpect(jsonPath("\$.Bids[1].pair").value("BTCZAR"))
    }

    @Test
    fun `Get Orderbook for a not present pair should return Empty List with 200 status`() {
        every {orderService.getByPair("BTCUSDT") } returns mutableMapOf("Asks" to listOf<LimitOrder>(), "Bids" to listOf<LimitOrder>())

        mockMvc.perform(get("/api/orders/BTCUSDT/orderbook").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.Asks").isEmpty)
            .andExpect(jsonPath("\$.Bids").isEmpty)
    }

    @Test
    fun `Get TradeHistory should return List of trades with 200 status`() {
        val trade1 = Trade("1234-abcd-5678", "BTCZAR", "1000", "10", "sell")
        val trade2 = Trade("9012-efgh-3456", "BTCZAR", "1030", "8", "buy")
        val trade3 = Trade("7890-ijkl-1234", "BTCZAR", "1080", "15", "sell")

        every {tradeService.getByPair("BTCZAR") } returns mutableListOf(
            mutableMapOf("id" to trade1.uniqueId, "price" to trade1.price, "quantity" to trade1.quantity, "currencyPair" to trade1.currencyPair, "takerSide" to trade1.takerSide, "tradedAt" to trade1.tradedAt),
            mutableMapOf("id" to trade2.uniqueId, "price" to trade2.price, "quantity" to trade2.quantity, "currencyPair" to trade2.currencyPair, "takerSide" to trade2.takerSide, "tradedAt" to trade2.tradedAt),
            mutableMapOf("id" to trade3.uniqueId, "price" to trade3.price, "quantity" to trade3.quantity, "currencyPair" to trade3.currencyPair, "takerSide" to trade3.takerSide, "tradedAt" to trade3.tradedAt)
        )

        mockMvc.perform(get("/api/orders/BTCZAR/tradehistory").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$").isArray)
            .andExpect(jsonPath("\$").isNotEmpty)
            .andExpect(jsonPath("\$.[0].id").value(trade1.uniqueId))
            .andExpect(jsonPath("\$.[1].id").value(trade2.uniqueId))
            .andExpect(jsonPath("\$.[2].id").value(trade3.uniqueId))
            .andExpect(jsonPath("\$.[0].currencyPair").value("BTCZAR"))
            .andExpect(jsonPath("\$.[1].currencyPair").value("BTCZAR"))
            .andExpect(jsonPath("\$.[2].currencyPair").value("BTCZAR"))
    }

    @Test
    fun `Get TradeHistory for a non present pair should return Empty List with 200 status`() {
        every {tradeService.getByPair("BTCZAR") } returns mutableListOf()

        mockMvc.perform(get("/api/orders/BTCZAR/tradehistory").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$").isEmpty)
    }

    @Test
    fun `Create Order with correct params should return 201 status`() {
        val limitOrder1 = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1200", "10", "sell","0395")

        every {orderService.create(any()) } returns mutableMapOf("id" to "1234-abcd-5678")

        val requestMap: MutableMap<String, String?> = mutableMapOf()
        requestMap["userId"] = "2"
        requestMap["side"] = "sell"
        requestMap["quantity"] = "0.100000"
        requestMap["price"] = "9000"
        requestMap["pair"] = "BTCZAR"

        val mapper: ObjectMapper = JsonMapper.builder()
            .addModule(JavaTimeModule())
            .build()
        val jsonData = mapper.writeValueAsString(requestMap)

        mockMvc.perform(post("/api/orders")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonData)
        )
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$").isNotEmpty)
            .andExpect(jsonPath("\$.id").value(limitOrder1.uniqueId))
    }

    // here pair is not provided in the request body, so this request should fail with 400 status
    @Test
    fun `Create Order with missing params should return 400 status`() {
        every {orderService.create(any()) } returns mutableMapOf("id" to "1234-abcd-5678")

        val requestMap: MutableMap<String, String?> = mutableMapOf()
        requestMap["userId"] = "2"
        requestMap["side"] = "sell"
        requestMap["quantity"] = "0.100000"
        requestMap["price"] = "9000"

        val mapper: ObjectMapper = JsonMapper.builder()
            .addModule(JavaTimeModule())
            .build()
        val jsonData = mapper.writeValueAsString(requestMap)

        mockMvc.perform(post("/api/orders")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonData)
        )
            .andExpect(status().isBadRequest)
    }
}
