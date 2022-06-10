package com.atguigu.book.bean;

import java.io.Serializable;
import java.util.Map;

public class Cart implements Serializable {

  //实现serializable接口。
  private static final long serialVersionUID = 73L;

  private Map<Integer, CartItem> cartItemMap; // 购物车中购物车项的集合，这个Map集合中的Key是Book的id

  public Cart() {
  }

  public Map<Integer, CartItem> getCartItemMap() {
    return cartItemMap;
  }

  public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
    this.cartItemMap = cartItemMap;
  }

  // 购物车的总金额
  public Double getTotalMoney() {
    Double totalMoney = 0.0;
    if (cartItemMap != null && cartItemMap.size() > 0) {
      for (Map.Entry<Integer, CartItem> entry : cartItemMap.entrySet()) {
        CartItem cartItem = entry.getValue();
        totalMoney += cartItem.getBook().getPrice() * cartItem.getBuyCount();
      }
    }
    return totalMoney;
  }

  // 购物车中购物项的数量
  public Integer getTotalCount() {
    if (cartItemMap != null) {
      return cartItemMap.size();
    }
    return 0;
  }

  // 购物车中书本的总数量，而不是购物车项的总数量
  public Integer getTotalBookCount() {
    if (cartItemMap != null) {
      Integer count = 0;
      for (Map.Entry<Integer, CartItem> entry : cartItemMap.entrySet()) {
        count += entry.getValue().getBuyCount();
      }
      return count;
    }
    return 0;
  }

}
