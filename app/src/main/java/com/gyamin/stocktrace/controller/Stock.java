package com.gyamin.stocktrace.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.gyamin.stocktrace.bean.StockFluctuationInPeriodBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.gyamin.stocktrace.searvice.StockSearch;

import java.util.List;

@Controller
public class Stock {

    @Autowired
    private StockSearch stockSearch;

    @RequestMapping(value = "/stocks", method = GET)
    public String search(Model model) {
        List<StockFluctuationInPeriodBean> prices = stockSearch.selectAll();
        return "stocks/index";
    }
}
