package com.gyamin.stock_trace.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.gyamin.stock_trace.searvice.StockSearch;

@Controller
public class Stock {
    @RequestMapping(value = "/stocks", method = GET)
    public String search(Model model) {
        StockSearch stockSearchService = new StockSearch();
        stockSearchService.test();
        return "stocks/index";
    }
}
