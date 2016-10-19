package com.gyamin.stocktrace.controller;

import com.gyamin.stocktrace.request.LoginRequest;
import com.gyamin.stocktrace.service.LoginService;
import com.gyamin.stocktrace.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Controller
public class Login {

    @Autowired
    private LoginService loginService;

//    @RequestMapping(value = "/loginByForm", method = POST, produces = "application/json")
//    @ResponseBody
//    public Object loginByForm(@RequestParam String id,
//                        @RequestParam String password, LoginRequest request) {
//        User loginUser = loginService.doLogin(request);
//
//        return new ResponseEntity<User>(loginUser, HttpStatus.OK);
//    }

    @RequestMapping(value = "/login", method = POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public Object loginByJson(@RequestBody LoginRequest request) {
        User loginUser = loginService.doLogin(request);

        return new ResponseEntity<User>(loginUser, HttpStatus.OK);
    }
}
