<template>
  <section class="py-5 overflow-hidden">
    <div class="container-fluid">
      <div class="row">
        <div class="col-md-12">
          <div class="section-header d-flex flex-wrap justify-content-between mb-5">
            <h2 class="section-title">추천 상품 리스트</h2>
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

const items = [
  { itemNm : 'item1',
    imageSrc: new URL('@/assets/images/thumb-junk.jpg', import.meta.url).href,
    price: 10000,
  },
  { itemNm : 'item2',
    imageSrc: new URL('@/assets/images/thumb-avocado.png', import.meta.url).href,
    price: 20000,
  },
  { itemNm : 'item3',
    imageSrc: new URL('@/assets/images/thumb-bananas.png', import.meta.url).href,
    price: 30000,
  },
  { itemNm : 'item4',
    imageSrc: new URL('@/assets/images/thumb-biscuits.png', import.meta.url).href,
    price: 40000,
  },
  { itemNm : 'item5',
    imageSrc: new URL('@/assets/images/thumb-herb.jpg', import.meta.url).href,
    price: 50000,
  },
  { itemNm : 'item6',
    imageSrc: new URL('@/assets/images/thumb-milk.png', import.meta.url).href,
    price: 60000,
  },
  { itemNm : 'item7',
    imageSrc: new URL('@/assets/images/thumb-honey.jpg', import.meta.url).href,
    price: 70000,
  }
]
</script>

<style scoped>
 section {
  padding: 0px 100px 0px 100px;
 }
</style>
