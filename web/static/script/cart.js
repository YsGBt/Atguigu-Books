function editCart(cartItemId, buyCount) {
  if (buyCount >= 1) {
    window.location.href = 'cart.do?operate=editCart&cartItemId=' + cartItemId
        + '&buyCount=' + buyCount;
  }
}