import axios from 'axios';
import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useMemberStore = defineStore('member', () => {
  const showLoginModal = ref(false);
  const isLogin = ref(sessionStorage.getItem('name') != null);

  const cart = ref([]);

  const login = (name) => {
    sessionStorage.setItem('name', name);
    fetchCart();
    isLogin.value = true;
  };

  const logout = () => {
    sessionStorage.removeItem('name');
    isLogin.value = false;
    cart.value = [];
  };

  const fetchCart = () => {
    if (isLogin.value) {
      axios({
        url: `http://localhost:80/cart?name=${sessionStorage.getItem('name')}`,
        method: 'POST'
      }).then((res) => {
        cart.value = res.data;
      })
      .catch(err => console.error(err));
    }
  };

  return { showLoginModal, isLogin, cart, login, logout, fetchCart };
});
