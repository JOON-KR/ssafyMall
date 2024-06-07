<template>
  <div>
    <div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1" id="offcanvasCart"
      aria-labelledby="My Cart">
      <div class="offcanvas-header justify-content-center">
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <div class="offcanvas-body">
        <div class="order-md-last">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-primary">장바구니</span>
            <span class="badge bg-primary rounded-pill">{{ cartLength }}</span>
          </h4>
          <ul class="list-group mb-3">
            <li class="list-group-item d-flex justify-content-between lh-sm" v-for="(cartDetail,index) in memberStore.cart"
              :key="index">
              <div>
                <h6 class="my-0">{{ cartDetail.itemNm }}</h6>
              </div>
              <span class="text-body-secondary"><strong>{{ cartDetail.price }}</strong>원 X <strong>{{ cartDetail.count }}</strong>개</span>
            </li>
            <li class="list-group-item d-flex justify-content-between">
              <span>총 주문 금액</span>
              <strong>{{ totalPrice }} 원</strong>
            </li>
          </ul>

          <button class="w-100 btn btn-primary btn-lg" type="submit">결제하기</button>
        </div>
      </div>
    </div>

    <header>
      <div class="container-fluid">
        <div class="row py-3 border-bottom">

          <div class="col-sm-4 col-lg-3 text-center text-sm-start">
            <div class="main-logo">
              <RouterLink to="/">
                <img src="@/assets/images/logo.png" alt="logo" class="img-fluid" style="width: 120px;">
              </RouterLink>
            </div>
          </div>

          <div class="col-sm-6 offset-sm-2 offset-md-0 col-lg-5">
            <div class="search-bar row bg-light p-2 my-2 rounded-4">
              <div class="col-11">
                <form id="search-form" class="text-center" @submit.prevent="doSearch" method="post">
                  <input type="text" class="form-control border-0 bg-transparent" id="keyword-input"
                    placeholder="검색어를 입력해주세요 !" />
                </form>
              </div>
              <div class="col-1">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                  <path fill="currentColor"
                    d="M21.71 20.29L18 16.61A9 9 0 1 0 16.61 18l3.68 3.68a1 1 0 0 0 1.42 0a1 1 0 0 0 0-1.39ZM11 18a7 7 0 1 1 7-7a7 7 0 0 1-7 7Z" />
                </svg>
              </div>
            </div>
          </div>

          <!-- 로그인 모달 -->
          <LoginModal />

          <div
            class="col-sm-8 col-lg-4 d-flex justify-content-end gap-5 align-items-center mt-4 mt-sm-0 justify-content-center justify-content-sm-end">
            <ul class="d-flex justify-content-end list-unstyled m-0">
              <li v-if="!memberStore.isLogin" class="menu" @click="openLoginModal()">
                <a>로그인</a>
              </li>
              <li v-if="memberStore.isLogin" class="menu">
                <a>마이페이지</a>
              </li>
              <li v-if="memberStore.isLogin" class="menu">
                <a>즐겨찾기</a>
              </li>
              <li v-if="memberStore.isLogin" class="menu">
                <a data-bs-toggle="offcanvas" data-bs-target="#offcanvasCart" aria-controls="offcanvasCart">
                  장바구니
                </a>
              </li>
              <li v-if="memberStore.isLogin" class="menu">
                <a @click="logout">로그아웃</a>
              </li>
            </ul>

          </div>

        </div>
      </div>
      <div class="container-fluid">
        <div class="row py-3">
          <div class="d-flex  justify-content-center justify-content-sm-between align-items-center">
            <nav class="main-menu d-flex navbar navbar-expand-lg">

              <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
                aria-controls="offcanvasNavbar">
                <span class="navbar-toggler-icon"></span>
              </button>

              <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
                aria-labelledby="offcanvasNavbarLabel">

                <div class="offcanvas-header justify-content-center">
                  <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>

                <div class="offcanvas-body">

                  <select class="filter-categories border-0 mb-0 me-5">
                    <option>전체 카테고리</option>
                    <option>카테고리1</option>
                    <option>카테고리2</option>
                    <option>카테고리3</option>
                  </select>

                  <ul class="navbar-nav justify-content-end menu-list list-unstyled d-flex gap-md-3 mb-0">
                    <li class="nav-item">
                      <a class="nav-link menu">카테고리1</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link menu">카테고리2</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link menu">카테고리3</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link menu">Sale</a>
                    </li>
                  </ul>
                </div>
              </div>
            </nav>

          </div>
        </div>
      </div>
    </header>
  </div>

</template>

<script setup>
import { useMemberStore } from '@/stores/member'
import { RouterLink, useRouter } from 'vue-router';
import LoginModal from './LoginModal.vue'
import { computed, onMounted, ref } from 'vue';
import axios from 'axios';

const router = useRouter()
const memberStore = useMemberStore()

const openLoginModal = () => {
  memberStore.showLoginModal = true;
};

const doSearch = () => {
  const keyword = document.getElementById('keyword-input').value

  if (keyword) {
    router.push(`/search/${keyword}`)
  } else {
    alert('키워드를 입력해주세요.')
  }
}

const logout = () => {
  console.log("logout");
  memberStore.logout();
};


onMounted(() => {
  memberStore.fetchCart()
})

const totalPrice = computed(() => {
  return memberStore.cart.reduce((total, item) => total + (item.price * item.count), 0);
});

const cartLength = computed(() => {
  return memberStore.cart.reduce((total, item) => total +  item.count, 0);
});

</script>

<style scoped>
.menu {
  margin: 10px;
  position: relative;
  transition: color 0.5s;
}

.menu:hover {
  color: orange;
}

.menu:hover::before {
  content: "";
  position: absolute;
  bottom: -5px;
  left: 0;
  width: 0;
  height: 2px;
  background-color: orange;
  animation: borderExpand 0.5s forwards;
}

@keyframes borderExpand {
  to {
    width: 100%;
  }
}

header {
  padding: 0px 30px 0px 30px;
}
</style>