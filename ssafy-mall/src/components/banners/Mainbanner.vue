<template>
  <swiper v-bind="swiperOption">
    <swiper-slide v-for="(slide, index) in slides" :key="index">
      <img :src="slide.image" :alt="slide.alt" class="banner-image" />
    </swiper-slide>
    <div class="swiper-pagination"></div>

  </swiper>
</template>

<script setup>
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/swiper-bundle.css';
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/autoplay';

import { Autoplay, Navigation, Pagination } from 'swiper/modules';


const slides = [
  { image: new URL('@/assets/images/slide-1.jpg', import.meta.url).href, alt: 'Slide 1' },
  { image: new URL('@/assets/images/slide-2.jpg', import.meta.url).href, alt: 'Slide 2' },
  { image: new URL('@/assets/images/slide-3.jpg', import.meta.url).href, alt: 'Slide 3' },
];

const swiperOption = {
  modules: [Navigation, Pagination, Autoplay],
  slidesPerView: 1,
  spaceBetween: 30,
  loop: true,
  pagination: {
    el: '.swiper-pagination',
    clickable: true
  },
  autoplay: {
    delay: 3000,
    disableOnInteraction: false,
  },
};
</script>

<style scoped>
.banner-image {
  width: 90%;
  height: 400px;
  object-fit: cover;
  display: block;
  margin: 0 auto;
}

</style>
