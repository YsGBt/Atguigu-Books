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

  @Override
  public void register(User user) {
    try {
      Connection conn = ConnUtil.getConnection();
      userDAO.addUser(conn, user);
    } catch (SQLException e) {
      throw new RuntimeException("UserService Failure: register");
    }
  }

  @Override
  public User getUer(String uname) {
    try {
      Connection conn = ConnUtil.getConnection();
      return userDAO.getUser(conn, uname);
    } catch (SQLException e) {
      throw new RuntimeException("UserService Failure: getUer");
    }
  }
}
