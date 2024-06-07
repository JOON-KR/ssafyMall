<template>
  <section class="py-5 overflow-hidden">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <div class="section-header d-flex flex-wrap justify-content-between mb-5">
            <h2 class="section-title">연관 상품 리스트</h2>
            <div class="d-flex align-items-center">
              <div class="swiper-buttons">
                <button class="swiper-prev item-carousel-prev btn btn-yellow">❮</button>
                <button class="swiper-next item-carousel-next btn btn-yellow">❯</button>
              </div>  
            </div>
          </div>          
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <swiper class="item-carousel swiper" v-bind="itemSwiperOption">
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
import { ref, onMounted } from 'vue';
import { Swiper, SwiperSlide } from 'swiper/vue';
import { Navigation, Pagination } from 'swiper/modules';


const itemSwiperOption = {
  modules: [Navigation, Pagination],
  slidesPerView: 5,
  spaceBetween: 30,
  loop: true,

  navigation: {
    nextEl: '.item-carousel-next', // 아이템 리스트 스와이퍼의 다음 버튼 클래스 지정
    prevEl: '.item-carousel-prev'  // 아이템 리스트 스와이퍼의 이전 버튼 클래스 지정
  }
};

const items = ref([])
onMounted(() => {
  axios.get('http://localhost:80/cosine/item1')
  .then((res) => {
    items.value = res.data
    console.log("cosine =" , res.data)
  }).catch((err) => console.log(err))
})

</script>

<style scoped>
 section {
  padding: 0px 100px 0px 100px;
 }
</style>
