package com.atguigu.myssm.filters;

import com.atguigu.myssm.util.StringUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"*.do"}, initParams = {@WebInitParam(name = "encoding", value = "UTF-8")})
public class CharacterEncodingFilter implements Filter {

  private String encoding = "UTF-8";

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    String encodingStr = filterConfig.getInitParameter("encoding");
    if (StringUtil.isNotEmpty(encodingStr)) {
      encoding = encodingStr;
    }
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {
    ((HttpServletRequest) servletRequest).setCharacterEncoding(encoding);
    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {

  }
}
