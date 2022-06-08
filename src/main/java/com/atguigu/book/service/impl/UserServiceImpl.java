package com.atguigu.book.service.impl;

import com.atguigu.book.bean.User;
import com.atguigu.book.dao.UserDAO;
import com.atguigu.book.service.UserService;
import com.atguigu.myssm.util.ConnUtil;
import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {

  private UserDAO userDAO;

  @Override
  public User login(String uname, String pwd) {
    try {
      Connection conn = ConnUtil.getConnection();
      return userDAO.getUser(conn, uname, pwd);
    } catch (SQLException e) {
      throw new RuntimeException("UserService Failure: login");
    }
  }
}
