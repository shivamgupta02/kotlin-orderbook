package com.example.api

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val limitOrderRepository: LimitOrderRepository,
    val tradeRepository: TradeRepository
) {

    /*
        LimitOrderRepository unit tests
     */
    @Test
    fun `When order present for id then findByUniqueId should return LimitOrder`() {
        val limitOrder = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1000", "10", "sell", "1092", "new")
        entityManager.persist(limitOrder)
        entityManager.flush()

        val record = limitOrderRepository.findByUniqueId("1234-abcd-5678")
        assertThat(record).isEqualTo(limitOrder)
    }

    @Test
    fun `When no order present for id then findByUniqueId should return null`() {
        val limitOrder = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1000", "10", "sell", "1092", "new")
        entityManager.persist(limitOrder)
        entityManager.flush()

        val record = limitOrderRepository.findByUniqueId("9012-efgh-3456")
        assertThat(record).isEqualTo(null)
    }

    @Test
    fun `When blank id is passed then findByUniqueId should return null`() {
        val limitOrder = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1000", "10", "sell", "1092", "new")
        entityManager.persist(limitOrder)
        entityManager.flush()

        val record = limitOrderRepository.findByUniqueId("")
        assertThat(record).isEqualTo(null)
    }

    @Test
    fun `When orders present for side sell and pair then findByPairAndSideOrderByPriceAsc should return LimitOrders in ascending order`() {
        val limitOrder1 = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1200", "10", "sell", "0395", "new")
        entityManager.persist(limitOrder1)
        entityManager.flush()
        val limitOrder2 = LimitOrder("9012-efgh-3456", "3", "BTCZAR", "1000", "12", "sell", "abs991", "new")
        entityManager.persist(limitOrder2)
        entityManager.flush()

        val records = limitOrderRepository.findByPairAndSideOrderByPriceAsc("BTCZAR", "sell")
        val record1 = records[0]
        val record2 = records[1]
        assertThat(record1.price).isLessThan(record2.price)
    }

    @Test
    fun `When no orders present for side sell and pair then findByPairAndSideOrderByPriceAsc should return Empty List`() {
        val limitOrder1 = LimitOrder("1234-abcd-5678", "2", "BTCUSDT", "1200", "10", "sell", "0395", "new")
        entityManager.persist(limitOrder1)
        entityManager.flush()
        val limitOrder2 = LimitOrder("9012-efgh-3456", "3", "BTCZAR", "1000", "12", "buy", "abs991", "new")
        entityManager.persist(limitOrder2)
        entityManager.flush()

        val records = limitOrderRepository.findByPairAndSideOrderByPriceAsc("BTCZAR", "sell")
        assertThat(records.size).isEqualTo(0)
    }

    @Test
    fun `When orders present for side buy and pair then findByPairAndSideOrderByPriceDesc should return LimitOrders in descending order`() {
        val limitOrder1 = LimitOrder("1234-abcd-5678", "2", "BTCZAR", "1200", "10", "buy", "0395", "new")
        entityManager.persist(limitOrder1)
        entityManager.flush()
        val limitOrder2 = LimitOrder("9012-efgh-3456", "3", "BTCZAR", "1000", "12", "buy", "abs991", "new")
        entityManager.persist(limitOrder2)
        entityManager.flush()

        val records = limitOrderRepository.findByPairAndSideOrderByPriceDesc("BTCZAR", "buy")
        val record1 = records[0]
        val record2 = records[1]
        assertThat(record1.price).isGreaterThan(record2.price)
    }

    @Test
    fun `When no orders present for side buy and pair then findByPairAndSideOrderByPriceDesc should return Empty List`() {
        val limitOrder1 = LimitOrder("1234-abcd-5678", "2", "BTCUSDT", "1200", "10", "buy", "0395", "new")
        entityManager.persist(limitOrder1)
        entityManager.flush()
        val limitOrder2 = LimitOrder("9012-efgh-3456", "3", "BTCZAR", "1000", "12", "sell", "abs991", "new")
        entityManager.persist(limitOrder2)
        entityManager.flush()

        val records = limitOrderRepository.findByPairAndSideOrderByPriceDesc("BTCZAR", "buy")
        assertThat(records.size).isEqualTo(0)
    }
    /*
        More test cases for multiple combination of pair and side can be added for following functions:
        findByPairAndSideOrderByPriceAsc
        findByPairAndSideOrderByPriceDesc
     */

    /*
        TradeRepository unit tests
     */
    @Test
    fun `When trades present for pair then findByCurrencyPair should return Trades`() {
        val trade1 = Trade("1234-abcd-5678", "BTCZAR", "1000", "10", "sell")
        entityManager.persist(trade1)
        entityManager.flush()
        val trade2 = Trade("9012-efgh-3456", "BTCZAR", "1100", "15", "buy")
        entityManager.persist(trade2)
        entityManager.flush()
        val trade3 = Trade("9012-efgh-3456", "BTCUSDT", "1100", "15", "buy")
        entityManager.persist(trade3)
        entityManager.flush()

        val records = tradeRepository.findByCurrencyPair("BTCZAR")
        assertThat(records.size).isEqualTo(2)
        val record1 = records[0]
        val record2 = records[1]
        assertThat(record1.currencyPair).isEqualTo("BTCZAR")
        assertThat(record2.currencyPair).isEqualTo("BTCZAR")
    }

    @Test
    fun `When no trades present then findByCurrencyPair should return Empty List`() {
        val records = tradeRepository.findByCurrencyPair("BTCZAR")
        assertThat(records.size).isEqualTo(0)
    }

    @Test
    fun `When no trades for pair present then findByCurrencyPair should return Empty List`() {
        val trade1 = Trade("1234-abcd-5678", "BTCUSDT", "1000", "10", "sell")
        entityManager.persist(trade1)
        entityManager.flush()
        val trade2 = Trade("9012-efgh-3456", "BTCUSDT", "1100", "15", "buy")
        entityManager.persist(trade2)
        entityManager.flush()

        val records = tradeRepository.findByCurrencyPair("BTCZAR")
        assertThat(records.size).isEqualTo(0)
    }
}