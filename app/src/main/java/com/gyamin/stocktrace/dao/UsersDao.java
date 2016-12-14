package com.gyamin.stocktrace.dao;

import com.gyamin.stocktrace.AppConfig;
import com.gyamin.stocktrace.entity.Users;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface UsersDao {

    /**
     *
     * @param loginId
     * @param password
     * @return
     */
    @Select
    Users selectByLoginIdPassword(String loginId, String password);

    /**
     * @param id
     * @return the Users entity
     */
    @Select
    Users selectById(Integer id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Users entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Users entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Users entity);
}