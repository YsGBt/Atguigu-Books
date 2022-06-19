// function editCart(cartItemId, buyCount) {
//   if (buyCount >= 1) {
//     window.location.href = 'cart.do?operate=editCart&cartItemId=' + cartItemId
//         + '&buyCount=' + buyCount;
//   }
// }

window.onload = function () {
  let vue = new Vue({
    el: "#cart_div",
    data: {
      cart: {}
    },
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
          let cart = value.data;
          vue.cart = cart;
        })
        .catch(function (reason) {
        });
      },
      editCart: function (cartItemId, buyCount) {
        if (buyCount >= 1) {
          axios({
            method: "POST",
            url: "cart.do",
            params: {
              operate: "editCartInfo",
              cartItemId: cartItemId,
              buyCount: buyCount
            }
          })
          .then(function (value) {
            vue.getCart();
          })
          .catch(function (reason) {
          });
        }
      }
    },
    beforeMount: function () {
      this.getCart()
    },

  });
}