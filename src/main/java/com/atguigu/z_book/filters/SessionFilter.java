package com.atguigu.z_book.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"*.do", "*.html"},
    initParams = {
        @WebInitParam(name = "whiteList",
            value = "/Atguigu_Books_war_exploded/page.do?operate=page&page=user/login,/Atguigu_Books_war_exploded/user.do?null,/Atguigu_Books_war_exploded/page.do?operate=page&page=user/regist")
    })
public class SessionFilter implements Filter {

  private List<String> whiteList;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    String white = filterConfig.getInitParameter("whiteList");
    String[] whiteArr = white.split(",");
    whiteList = Arrays.asList(whiteArr);
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String uri = request.getRequestURI();
    String queryString = request.getQueryString();
    String str = uri + "?" + queryString;
    if (whiteList.contains(str) || uri.equals("/Atguigu_Books_war_exploded/user.do")) {
      filterChain.doFilter(request, response);
      return;
    }

    HttpSession session = request.getSession();
    Object currUserObj = session.getAttribute("currentUser");
    if (currUserObj == null) {
      response.sendRedirect("page.do?operate=page&page=user/login");
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }

  @Override
  public void destroy() {

  }
}
