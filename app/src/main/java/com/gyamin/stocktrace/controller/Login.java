package com.gyamin.stocktrace.controller;

import com.gyamin.stocktrace.common.ApplicationProperties;
import com.gyamin.stocktrace.request.PostLogin;
import com.gyamin.stocktrace.service.LoginService;
import com.gyamin.stocktrace.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Controller
public class Login {

    @Autowired
    private ApplicationProperties applicationProperties ;
    @Autowired
    private LoginService loginService;

//    @RequestMapping(value = "/loginByForm", method = POST, produces = "application/json")
//    @ResponseBody
//    public Object loginByForm(@RequestParam String id,
//                        @RequestParam String password, PostLogin request) {
//        User loginUser = loginService.doLogin(request);
//
//        return new ResponseEntity<User>(loginUser, HttpStatus.OK);
//    }

    @RequestMapping(value = "/login", method = POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public Object login(@RequestBody PostLogin request) {
        User loginUser = loginService.doLogin(request);
        System.out.print(applicationProperties.get("app.test"));

        return new ResponseEntity<User>(loginUser, HttpStatus.OK);
    }
}
