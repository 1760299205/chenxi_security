package com.chenxi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
//public class PasswordConfig implements PasswordEncoder {
//
//    @Override
//    public String encode(CharSequence charSequence) {
//        //charSequence是用户输入的密码，password是存库的密码
//        return charSequence.toString();
//    }
//
//    @Override
//    public boolean matches(CharSequence charSequence, String password) {
//        return password.contentEquals(encode(charSequence));
//    }
//}
