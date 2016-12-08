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
public class IssuesListener implements EntityListener<Issues> {

    @Override
    public void preInsert(Issues entity, PreInsertContext<Issues> context) {
    }

    @Override
    public void preUpdate(Issues entity, PreUpdateContext<Issues> context) {
    }

    @Override
    public void preDelete(Issues entity, PreDeleteContext<Issues> context) {
    }

    @Override
    public void postInsert(Issues entity, PostInsertContext<Issues> context) {
    }

    @Override
    public void postUpdate(Issues entity, PostUpdateContext<Issues> context) {
    }

    @Override
    public void postDelete(Issues entity, PostDeleteContext<Issues> context) {
    }
}