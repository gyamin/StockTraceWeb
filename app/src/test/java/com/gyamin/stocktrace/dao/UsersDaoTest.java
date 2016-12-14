package com.gyamin.stocktrace.dao;

import com.gyamin.stocktrace.AppConfig;
import com.gyamin.stocktrace.entity.Users;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.seasar.doma.jdbc.tx.TransactionManager;

public class UsersDaoTest {

    private final UsersDao dao = new UsersDaoImpl();
    private TransactionManager tm = AppConfig.singleton().getTransactionManager();
    private List<Integer> insertedIds = new ArrayList<Integer>();

    @Before
    public void setUp() {
        Users user = new Users();
        tm.required(() -> {
            user.setLoginId("kabuka_taro@stock.com");
            user.setUserName("株価 太郎");
            user.setPassword("12345");
            user.setRole("admin");
            dao.insert(user);

            // 挿入したidを配列に保持
            insertedIds.add(user.getId());
            assertNotNull(user.getId());
        });
    }

    @After
    public void tearDown() throws Exception {
        tm.required(() -> {
            // 挿入したレコードを削除
            for(Integer id : insertedIds) {
                Users user = dao.selectById(id);
                if(user != null) {
                    dao.delete(user);
                }
            }
        });
    }

    @Test
    public void selectByUserNamePassword() throws Exception {
        Users user = new Users();
        tm.required(() -> {
            Users users = dao.selectByLoginIdPassword("kabuka_taro@stock.com", "12345");
            assertThat(users.getLoginId(), is("kabuka_taro@stock.com"));
        });
    }

    @Test
    public void selectById() throws Exception {
        tm.required(() -> {
            Users user = dao.selectById(insertedIds.get(0));
            assertThat(user.getLoginId(), is("kabuka_taro@stock.com"));
        });
    }

    @Test
    public void insert() throws Exception {
        Users user = new Users();
        tm.required(() -> {
            user.setLoginId("kabuka_jiro@stock.com");
            user.setUserName("株価 次郎");
            user.setPassword("12345");
            user.setRole("admin");
            dao.insert(user);
            // 挿入したidを配列に保持
            insertedIds.add(user.getId());

            assertThat(dao.selectById(user.getId()).getUserName(), is("株価 次郎"));
        });
    }

    @Test
    public void update() throws Exception {
        tm.required(() -> {
            Users user = dao.selectById(insertedIds.get(0));
            user.setLoginId("_kabuka_taro@stock.com");
            user.setUserName("_株価 次郎");
            user.setPassword("_12345");
            user.setRole("_admin");
            Integer updatedId = dao.update(user);
            assertThat(dao.selectById(insertedIds.get(0)).getLoginId(), is("_kabuka_taro@stock.com"));
        });
    }

    @Test
    public void delete() throws Exception {
        tm.required(() -> {
            Users user = dao.selectById(insertedIds.get(0));
            dao.delete(user);
            assertThat(dao.selectById(insertedIds.get(0)), nullValue());
        });

    }

}