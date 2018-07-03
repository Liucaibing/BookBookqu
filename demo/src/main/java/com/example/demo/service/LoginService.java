package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginService {
    @Autowired
    UserDao userDao;

    public User doLogin(String account,String password){
        System.out.println("加密前："+account+" "+password);
        password=EncoderByMd5(password);
        User user=userDao.findByLogin(account,password);
        System.out.println("加密后："+account+" "+password);
        if(user!=null){
            return user;
        }

        return null;
    }

    /**
     * @brief 对字符串用MD5进行加密
     * @param str 待加密的字符串
     * @return 加密后的字符串
     */
    public String EncoderByMd5(String str) {
        try{
            //确定计算方法
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en=new BASE64Encoder();
            //加密后的字符串
            String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
            return newstr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
