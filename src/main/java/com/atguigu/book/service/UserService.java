package com.atguigu.book.service;

import com.atguigu.book.bean.User;

public interface UserService {

  User login(String uname, String pwd);

  void register(User user);

  User getUer(String uname);
}
