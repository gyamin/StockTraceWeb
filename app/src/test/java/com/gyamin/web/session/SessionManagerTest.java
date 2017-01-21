package com.gyamin.web.session;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import com.gyamin.stocktrace.controller.SampleController;

import javax.servlet.http.Cookie;

public class SessionManagerTest {

    private MockMvc mvc;
    private MockHttpSession mockHttpSession;
    private Cookie cookie;

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new SampleController()).build();

        // セッション作成処理
        MvcResult result =  mvc.perform(get("/start_session")).andReturn();
        Cookie cookie = result.getResponse().getCookie("session_id");
        this.cookie = cookie;
    }

    @Test
    public void test_startSession() throws Exception {
        MvcResult result =  mvc.perform(get("/start_session")).andReturn();
        Cookie cookie = result.getResponse().getCookie("session_id");
        System.out.print(cookie.getValue());
        assertThat(cookie.getValue().length(), is(not(0)));
    }

    @Test
    public void test_storeSessionAndgetSession() throws Exception {
        // セッションデータ作成
        MvcResult result =  mvc.perform(post("/store_session").cookie(this.cookie).param("param1", "12345")).andReturn();
        assertThat(result.getResponse().getStatus(), is(200));

        // セッションデータ取得
        result = mvc.perform(get("/get_session").cookie(this.cookie)).andReturn();
        assertThat(result.getResponse().getContentAsString(), is("{\"param1\":\"12345\"}"));
    }
}
