<template>
    <div class="modal-wrapper" v-if="memberStore.showLoginModal">
      <div class="modal-overlay" @click="closeModal"></div>
      <div class="modal-content">
        <div class="modal-header" style="padding: 10px">
          <h3 style="margin: 0 auto; letter-spacing: 0.1rem;">로그인</h3>
        </div>
        <div class="modal-body">
          <form @submit.prevent="handleSubmit">
            <div class="form-group">
              <label for="email">이메일</label>
              <input type="email" id="email" v-model="email" required>
            </div>
            <div class="form-group">
              <label for="password">비밀번호</label>
              <input type="password" id="password" v-model="password" required>
            </div>
            <button type="submit" class="btn btn-primary">로그인</button>
            <button class="btn close-btn" @click="closeModal">닫기</button>
          </form>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import { useMemberStore } from '@/stores/member'

  const memberStore = useMemberStore()
  
  const email = ref('');
  const password = ref('');
  
  const handleSubmit = () => {
    memberStore.login('윤아름')
    closeModal();
  };
  
  const openModal = () => {
    memberStore.showLoginModal = true;
  };
  
  const closeModal = () => {
    email.value = ''
    password.value = ''
    memberStore.showLoginModal = false;
  };
  </script>
  
  <style scoped>
  .modal-wrapper {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    z-index: 100000;
  }
  
  .modal-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
  }
  
  .modal-content {
    background-color: #ffffff;
    border-radius: 30px;
    padding: 20px;
    width: 400px;
  }
  
  .modal-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }

  .modal-body {
    margin-top: 20px;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    font-weight: bold;
  }
  
  input[type="email"],
  input[type="password"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
  }
  
  .btn {
    padding: 10px 20px;
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 7px;
    cursor: pointer;
  }
  
  .btn-primary {
    background-color: #ffac37;
  }
  
  .btn-primary:hover {
    background-color: #fa9912;
  }

  .close-btn {
    background-color: #e4e4e4;
    color: rgb(106, 106, 106);
  }
  
  .close-btn:hover {
    background-color: #d0d0d0;
  }
  </style>
  