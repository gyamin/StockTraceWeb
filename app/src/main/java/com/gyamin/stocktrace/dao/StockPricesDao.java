package com.gyamin.stocktrace.dao;

import com.gyamin.stocktrace.bean.StockFluctuationInPeriodBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.sql.DataSource;
import java.lang.StringBuffer;

@Repository
public class StockPricesDao {

    private JdbcTemplate jdbcTemplate;

    /**
     * @param dataSource
     */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 株価データ全件取得
     * @return 株価データ検索結果配列
     */
    public List<StockFluctuationInPeriodBean> selectAll() {
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

            List<StockFluctuationInPeriodBean> stocks =
                this.jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<StockFluctuationInPeriodBean>(StockFluctuationInPeriodBean.class));
            return stocks;
        }catch(DataAccessException e) {
            throw e;
        }
    }
}
