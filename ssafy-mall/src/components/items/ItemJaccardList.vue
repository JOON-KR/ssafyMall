<template>
  <section class="py-5 overflow-hidden" v-if="memberStore.isLogin">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <div class="section-header d-flex flex-wrap justify-content-between mb-5">
            <h3 class="section-title">{{ name }}님에게 추천드리는 상품✨</h3>
            <div class="d-flex align-items-center">
              <div class="swiper-buttons">
                <button class="swiper-prev item-jaccard-carousel-prev btn btn-yellow">❮</button>
                <button class="swiper-next item-jaccard-carousel-next btn btn-yellow">❯</button>
              </div>  
            </div>
          </div>          
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <swiper class="item-jaccard-carousel swiper" v-bind="itemSwiperOption">
            <swiper-slide v-for="item in items" :key="item.itemNm"><ItemDetail :item="item"/></swiper-slide>
          </swiper>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import ItemDetail from './ItemDetail.vue';
import 'swiper/swiper-bundle.css';
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import axios from 'axios';
import { ref, onMounted, onUpdated, watch } from 'vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import { Navigation, Pagination } from 'swiper/modules';
import { useMemberStore } from '@/stores/member'

const memberStore = useMemberStore()

const itemSwiperOption = {
  modules: [Navigation, Pagination],
  slidesPerView: 5,
  spaceBetween: 30,
  loop: true,

  navigation: {
    nextEl: '.item-jaccard-carousel-next', // 아이템 리스트 스와이퍼의 다음 버튼 클래스 지정
    prevEl: '.item-jaccard-carousel-prev'  // 아이템 리스트 스와이퍼의 이전 버튼 클래스 지정
  }
};

const items = ref([])
onMounted(() => {
  fetchData()
})

const name = ref('익명')
watch(memberStore.isLogin, () => {fetchData()})
const fetchData = () => {
  if(memberStore.isLogin) {
    name.value = sessionStorage.getItem('name')
    console.log('name = ', sessionStorage.getItem('name'))
    axios.get(`http://localhost:80/jaccard/${sessionStorage.getItem('name')}`)
    .then((res) => {
      items.value = res.data
    }).catch((err) => console.log(err))
  }
}

</script>

<style scoped>
 section {
  padding: 0px 100px 0px 100px;
 }
</style>
