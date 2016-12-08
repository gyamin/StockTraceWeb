package com.gyamin.stocktrace.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class StockPricesListener implements EntityListener<StockPrices> {

    @Override
    public void preInsert(StockPrices entity, PreInsertContext<StockPrices> context) {
    }

    @Override
    public void preUpdate(StockPrices entity, PreUpdateContext<StockPrices> context) {
    }

    @Override
    public void preDelete(StockPrices entity, PreDeleteContext<StockPrices> context) {
    }

    @Override
    public void postInsert(StockPrices entity, PostInsertContext<StockPrices> context) {
    }

    @Override
    public void postUpdate(StockPrices entity, PostUpdateContext<StockPrices> context) {
    }

    @Override
    public void postDelete(StockPrices entity, PostDeleteContext<StockPrices> context) {
    }
}