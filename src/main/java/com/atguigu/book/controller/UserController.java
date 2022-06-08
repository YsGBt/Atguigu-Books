package com.atguigu.book.controller;

import com.atguigu.book.bean.User;
import com.atguigu.book.service.UserService;

public class UserController {

  private UserService userService;

  public String login(String uname, String pwd) {
    User user = userService.login(uname, pwd);
    System.out.println(user);
    return "index";
  }
}
