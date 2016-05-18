package com.gyamin.stock_trace.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.sql.DataSource;
import java.lang.StringBuffer;
import com.gyamin.stock_trace.bean.StockFluctuationInPeriodBean;

@Repository
class StockPticesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     *
     * @return
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
