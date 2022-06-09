package com.atguigu.book.bean;

import java.io.Serializable;

public class User implements Serializable {

  //实现serializable接口。
  private static final long serialVersionUID = 73L;

  private Integer id;
  private String uname;
  private String pwd;
  private String email;
  private Integer role;

  private Cart cart;

  public User() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getRole() {
    return role;
  }

  public void setRole(Integer role) {
    this.role = role;
  }

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", uname='" + uname + '\'' +
        ", pwd='" + pwd + '\'' +
        ", email='" + email + '\'' +
        ", role=" + role +
        '}';
  }
}
