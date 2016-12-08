package com.gyamin.stocktrace.dao;

import com.gyamin.stocktrace.AppConfig;
import com.gyamin.stocktrace.entity.Issues;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface IssuesDao {

    /**
     * @param section
     * @param issueCode
     * @return the Issues entity
     */
    @Select
    Issues selectById(String section, Integer issueCode);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Issues entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Issues entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Issues entity);
}