package com.gyamin.stocktrace.searvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import com.gyamin.stocktrace.bean.StockFluctuationInPeriodBean;
import com.gyamin.stocktrace.dao.StockPricesDao;

import java.util.List;

@Service
public class StockSearch {
    public List<StockFluctuationInPeriodBean> selectAll() {

        // データベース設定を取得
        ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-postgre.xml");
        // bean設定を取得しインスタンス作成
        StockPricesDao stockPricesDao = ctx.getBean(StockPricesDao.class);

        // stockPricesDaoを利用してDBアクセス、株価価格情報を取得
        List<StockFluctuationInPeriodBean> prices = stockPricesDao.selectAll();

        return prices;
    }
}