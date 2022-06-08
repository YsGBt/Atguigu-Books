package com.atguigu.book.dao.impl;

import com.atguigu.book.bean.User;
import com.atguigu.book.dao.UserDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import java.sql.Connection;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

  @Override
  public User getUser(Connection conn, String uname, String pwd) {
    String sql = "select id, uname, pwd, email, role from t_user where uname like ? and pwd like ?";
    User user = getBean(conn, sql, uname, pwd);
    return user;
  }
}
