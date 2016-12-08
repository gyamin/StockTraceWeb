package com.gyamin.stocktrace.dao;

import java.math.BigDecimal;
import java.util.List;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.gyamin.stocktrace.bean.StockPrices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StockPricesDaoJdbcTemplateTest {

    @Test
    public void test_SelectByPrimaryKey() {
        // データベース設定を取得
        ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-postgre.xml");
        // bean設定を取得しインスタンス作成
        StockPricesDaoJdbcTemplate dao = ctx.getBean(StockPricesDaoJdbcTemplate.class);

        List<StockPrices> prices = dao.selectByPrimaryKey(LocalDate.of(2015, 11, 13), 1333);
        assertEquals(prices.get(0).getNowPrice(), new BigDecimal("1970.00"));
    }
}
