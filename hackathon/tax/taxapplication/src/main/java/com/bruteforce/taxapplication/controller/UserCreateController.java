package com.bruteforce.taxapplication.controller;

import com.bruteforce.taxapplication.model.UserInfo;
import com.bruteforce.taxapplication.model.Users;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Controller
public class UserCreateController {

    private static final Logger logger = LoggerFactory.getLogger(UserCreateController.class);


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String helloWorld() {
        //Flux

//        String consentUrl = "http://localhost:8080/springrestexample/employees.xml";
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//
//        String result = restTemplate.getForObject(consentUrl, String.class);
//
//        System.out.println(result);
//        ConsumeAA consumeAA = new ConsumeAA();

        return "Hello World!!!";

    }
    @PostMapping(
            value = "/createUser/{name}", produces = "application/json")
    public Map<String,Double> createPerson(@RequestBody UserInfo userInfo,@PathVariable String name) {
        String[] schemeList = userInfo.schemes;
        /*
        db
         */
        String userName = name;
        if(schemeList!=null){
            ConsumeAA consumeAA = new ConsumeAA(name);
            consumeAA.consentReq();
            return consumeAA.getSchmeToAmountMap();
        }

        return null;
    }




}
