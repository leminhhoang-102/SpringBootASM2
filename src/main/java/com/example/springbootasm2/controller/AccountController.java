package com.example.springbootasm2.controller;

import com.example.springbootasm2.entity.Account;
import com.example.springbootasm2.entity.Product;
import com.example.springbootasm2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(@RequestParam String username, @RequestParam String password,@RequestParam int role){
        accountService.register(username,password,role);
        return "index";
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Account login(@RequestParam String username, @RequestParam String password){
        Account account= accountService.login(username,password);
        return account;
    }

    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    public List<Account> generateAccount(){

        List<Account> list = new ArrayList<Account>();
        Account account1 = new Account(1,"hoangonono","le minh hoang","123456",1,1);
        list.add(account1);
        Account account2 = new Account(2,"minhhoang","le hoang","123456",2,0);
        list.add(account2);

        return list;
    }
}
