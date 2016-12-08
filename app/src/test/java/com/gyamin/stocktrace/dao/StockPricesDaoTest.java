package com.gyamin.stocktrace.dao;

import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;

import com.gyamin.stocktrace.AppConfig;
import com.gyamin.stocktrace.entity.StockPrices;

import static org.junit.Assert.*;

public class StockPricesDaoTest {

    private final StockPricesDao dao = new StockPricesDaoImpl();
    private TransactionManager tm;

    @Before
    public void setUp() {
        tm = AppConfig.singleton().getTransactionManager();
    }

    @Test
    public void test_SelectById() {
        tm.required(() -> {
            StockPrices stockPrices = dao.selectById(LocalDate.of(2015, 11, 13), 1333);
            assertEquals(stockPrices.getNowPrice(), new BigDecimal("1970.00"));
        });
    }

}