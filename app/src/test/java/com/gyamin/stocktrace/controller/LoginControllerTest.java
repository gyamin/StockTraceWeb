package com.gyamin.stocktrace.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyamin.stocktrace.request.LoginRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.Cookie;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

public class LoginControllerTest {

    private MockMvc mvc;
    private MockHttpSession mockHttpSession;
    private Cookie cookie;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new SampleController()).build();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void loginIndex() throws Exception {

    }

    @Test
    public void login() throws Exception {
        LoginRequest request = new LoginRequest();
        request.setId("test1@local");
        request.setPassword("test1Pwd");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(request);
        MvcResult result =  mvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(
                jsonStr.getBytes())).andReturn();

        System.out.print(result.getResponse());
        assertThat(result.getResponse().getStatus(), is(200));
    }

    @Test
    public void applicatinError() throws Exception {

    }

    @Test
    public void validateError() throws Exception {

    }

}
