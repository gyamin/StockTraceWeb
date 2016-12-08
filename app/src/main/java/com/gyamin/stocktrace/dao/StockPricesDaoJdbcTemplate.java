package com.gyamin.stocktrace.dao;

import com.gyamin.stocktrace.bean.StockPrices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static com.gyamin.stocktrace.bean.StockPrices.*;

@Repository
public class StockPricesDaoJdbcTemplate {

    private JdbcTemplate jdbcTemplate;

    /**
     * @param dataSource
     */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 株価データをプライマリーキーで検索する(issuesテーブルを結合)
     * @param tradeDate
     * @param issueCode
     * @return 株価データ検索結果配列
     */
    public List<StockPrices> selectByPrimaryKey(LocalDate tradeDate, Integer issueCode) {
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" issues.section, ");
            sql.append(" issues.issue_code, ");
            sql.append(" issues.issue_name, ");
            sql.append(" stock_prices.trade_date, ");
            sql.append(" stock_prices.now_price ");
            sql.append(" from issues ");
            sql.append(" INNER JOIN stock_prices ");
            sql.append(" ON issues.issue_code = stock_prices.issue_code ");
            sql.append(" WHERE stock_prices.trade_date = ? ");
            sql.append(" AND issues.issue_code = ? ");

            List<StockPrices> stocks =
                this.jdbcTemplate.query(sql.toString(),
                    new BeanPropertyRowMapper<StockPrices>(StockPrices.class), Date.valueOf(tradeDate), issueCode);
            return stocks;
        }catch(DataAccessException e) {
            throw e;
        }
    }
}
