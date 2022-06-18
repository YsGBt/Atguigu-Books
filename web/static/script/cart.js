function editCart(cartItemId, buyCount) {
  if (buyCount >= 1) {
    window.location.href = 'cart.do?operate=editCart&cartItemId=' + cartItemId
        + '&buyCount=' + buyCount;
  }
}

window.onload = function () {
  let vue = new Vue({
    el: "#cart_div",
    data: {},
    methods: {
      getCart: function () {
        axios({
          method: "POST",
          url: "cart.do",
          params: {
            operate: "cartInfo"
          }
        })
        .then(function (value) {
          let data = value.data;
          console.log(data);
        })
        .catch(function (reason) {
        });
      }
    },
    beforeMount: function () {
      this.getCart()
    },

  });
}