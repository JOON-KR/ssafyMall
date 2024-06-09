<template>
  <section class="py-5 overflow-hidden" v-if="items.length > 0">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <div class="section-header d-flex flex-wrap justify-content-between mb-5">
            <h2 class="section-title">이런 상품도 추천드려요🎉</h2>
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
import { ref, onMounted, defineProps } from 'vue';
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

const props = defineProps({item: Object})

const items = ref([])
onMounted(async () => {
  const response = await axios.get(`http://localhost:80/cosine/${props.item.itemNm}`)
  items.value  = response.data;
 
})

</script>

<style scoped>
 section {
  padding: 0px 100px 0px 100px;
 }
</style>
