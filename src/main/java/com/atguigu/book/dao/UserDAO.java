package com.atguigu.book.dao;

import com.atguigu.book.bean.User;
import java.sql.Connection;

public interface UserDAO {

  User getUser(Connection conn, String uname, String pwd);

  User getUser(Connection conn, String uname);

  boolean addUser(Connection conn, User user);
}
