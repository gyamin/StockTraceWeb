package com.gyamin.stocktrace.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Script;

import com.gyamin.stocktrace.AppConfig;

@Dao(config = AppConfig.class)
public interface AppDao {

    @Script
    void create();

//    @Script
//    void drop();
}
