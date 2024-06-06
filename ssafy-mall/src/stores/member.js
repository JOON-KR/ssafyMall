import { ref, computed } from 'vue'
import { defineStore } from 'pinia'

export const useMemberStore = defineStore('member', () => {
  const member = ref(null)

  const showLoginModal = ref(false)

  const logout = function() {
    member.value = null
  }

  return { 
    member,
    showLoginModal,
    logout,
  }
})
