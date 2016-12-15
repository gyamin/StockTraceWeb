package com.gyamin.stocktrace.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import com.gyamin.stocktrace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.http.MediaType;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gyamin.stocktrace.entity.Users;
import com.gyamin.stocktrace.request.LoginRequest;
import com.gyamin.stocktrace.service.StockSearch;
import com.gyamin.stocktrace.exception.ValidateException;

@Controller
public class Login {

    @Autowired
    private StockSearch stockSearch;
    private ObjectError error;
    private Login login;

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
    public Object login(@RequestBody @Valid LoginRequest request, BindingResult result) throws ValidateException {

        // リクエストバリデーション
        if(result.hasErrors()) {
            ValidateException validateException = new ValidateException();
            validateException.errors = result.getFieldErrors();
            throw validateException;
        }
        // userId, passwordに該当するユーザが存在するか確認する
        LoginService service = new LoginService();
        Users loginUser = service.doLogin(request);

        return new ResponseEntity<Users>(loginUser, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ ValidateException.class })
    @ResponseBody
    public List validateError(ValidateException exception) {
        List<Map<String,String>> errorList = new ArrayList();

        for(ObjectError error : exception.errors ) {
            Map<String, String> info = new HashMap<String, String>();
            info.put("field", ((FieldError) error).getField());
            info.put("message", ((FieldError) error).getDefaultMessage());
            errorList.add(info);
        }
        return errorList;
    }
}