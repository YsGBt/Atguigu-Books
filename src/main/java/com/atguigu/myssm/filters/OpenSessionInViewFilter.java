package com.atguigu.myssm.filters;

import com.atguigu.myssm.trans.TransactionManager;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*.do")
public class OpenSessionInViewFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    try {
      TransactionManager.beginTrans();
      //System.out.println("开启事务....");
      filterChain.doFilter(servletRequest, servletResponse);
      TransactionManager.commit();
      //System.out.println("提交事务...");
    } catch (Exception e) {
      e.printStackTrace();
      try {
        TransactionManager.rollback();
//        System.out.println("回滚事务....");
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
  }

  @Override
  public void destroy() {

  }
}
