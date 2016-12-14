package com.gyamin.stocktrace.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.gyamin.stocktrace.service.LoginService;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import javax.validation.Valid;

import com.gyamin.stocktrace.entity.Users;
import com.gyamin.stocktrace.request.LoginRequest;
import com.gyamin.stocktrace.service.StockSearch;


@Controller
public class Login {

    @Autowired
    private StockSearch stockSearch;

    /**
     * ログイン画面表示
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = GET)
    public String loginIndex(Model model) {
        return "login/index";
    }


    @RequestMapping(value = "/login", method = POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public Object login(@RequestBody @Valid LoginRequest request, BindingResult result) {

        // リクエストバリデーション
        if(result.hasErrors()) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }

        // userId, passwordに該当するユーザが存在するか確認する
        LoginService service = new LoginService();
        Users loginUser = service.doLogin(request);

        return new ResponseEntity<Users>(loginUser, HttpStatus.OK);

    }

}