package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

public class LoginController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value="/doLogin",method=RequestMethod.POST)
    @ResponseBody
    String doLogin(String account, String password, HttpSession httpSession){
        User user=null;
        try{
            user=loginService.doLogin(account,password);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库！");
        }
        return "密码错误！";
    }

    @RequestMapping(value = "/")
    String index(){return "redirect:/login";}
    @RequestMapping(value = "/login")
    String login(){return "login";}

    @RequestMapping(value = "wrongpassword")
    String wrongpassword(Model model){
        return "密码错误";
    }
}
