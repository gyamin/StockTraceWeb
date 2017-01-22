package com.gyamin.stocktrace.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Script;

import com.gyamin.stocktrace.AppConfig;

import java.util.function.Consumer;

@Dao(config = AppConfig.class)
public interface AppDao {

    @Script
    void create();

    @Script
    void insertSeeds();

//    @Script
//    void drop();
}
