<template>
  <section id="selling-product" class="single-product mt-0 md-5">
    <div class="container-fluid">
      <div class="row g-5">
        <div class="col-lg-7">
          <div class="row flex-column-reverse flex-lg-row">
            <div class="col-md-12 col-lg-2">
            </div>
            <div class="col-md-12 col-lg-10">
              <!-- product-large-slider -->
              <Swiper :modules="[Navigation, Pagination, Scrollbar, A11y]" class="product-large-slider"
                slidesPerView="1" pagination :navigation="true">
                <SwiperSlide>
                  <div class="image-zoom" data-scale="2.5" data-image="@/assets/images/product-large-1.jpg">
                    <img :src="imageUrl" alt="product-large" class="img-fluid" style="object-fit: cover;">
                  </div>
                </SwiperSlide>
              </Swiper>
            </div>
          </div>
        </div>
        <div class="col-lg-5">
          <div class="product-info">
            <div class="element-header">
              <h2 itemprop="name" class="display-6">{{ item.itemNm }}</h2>
              <div class="rating-container d-flex gap-0 align-items-center">
                <!-- 꽉 찬 별 -->
                <div class="rating" data-rating="1" v-for="index in Math.floor(score / 2)" :key="'full-' + index">
                  <svg width="32" height="32" class="text-primary">
                    <use xlink:href="#star-solid"></use>
                  </svg>
                </div>
                <!-- 절반 채운 별 -->
                <div v-if="score % 2 !== 0" class="rating" data-rating="0.5">
                  <svg width="28" height="28" class="text-primary">
                    <use xlink:href="#star-half"></use>
                  </svg>
                </div>
                <!-- 빈 별 -->
                <div class="rating" data-rating="1" v-for="index in 5 - Math.ceil(score / 2)" :key="'empty-' + index">
                  <svg width="32" height="32" class="text-secondary">
                    <use xlink:href="#star-solid"></use>
                  </svg>
                </div>
                <span class="rating-count" v-if="score != null">{{ score / 2 }}</span>
              </div>
            </div>
            <div class="product-price pt-3 pb-3">
              <strong class="text-primary display-6 fw-bold">₩ {{ item.price }}</strong>
            </div>
            <p>{{ item.itemDetail }}</p>
            <div class="cart-wrap pb-5">
              <div class="product-quantity pt-3">
                <div class="stock-button-wrap">
                  <div class="input-group product-qty" style="max-width: 150px;">
                    <span class="input-group-btn">
                      <button type="button" class="quantity-left-minus btn btn-light btn-number" data-type="minus"
                        data-field="" @click="count--" :disabled="count <= 1">
                        <svg width="16" height="16">
                          <use xlink:href="#minus"></use>
                        </svg>
                      </button>
                    </span>
                    <input type="text" id="quantity" name="quantity" class="form-control input-number text-center"
                      :value="count" min="1" max="100">
                    <span class="input-group-btn">
                      <button type="button" class="quantity-right-plus btn btn-light btn-number" data-type="plus"
                        data-field="" @click="count++" :disabled="count >= 20">
                        <svg width="16" height="16">
                          <use xlink:href="#plus"></use>
                        </svg>
                      </button>
                    </span>
                  </div>
                  <div class="qty-button d-flex flex-wrap pt-3">
                    <button type="submit" class="btn btn-primary py-3 px-4 text-uppercase me-3 mt-3">구매하기</button>
                    <button type="submit" name="add-to-cart" value="1269"
                      class="btn btn-dark py-3 px-4 text-uppercase mt-3" @click="addCart">장바구니</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { Swiper, SwiperSlide } from 'swiper/vue';
import { Navigation, Pagination, Scrollbar, A11y } from 'swiper/modules';
import 'swiper/swiper-bundle.css';
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/autoplay';
import { computed, ref } from 'vue'
import axios from 'axios';
import { useMemberStore } from '@/stores/member';

const memberStore = useMemberStore()

const props = defineProps({
  item: Object,
  score: Number
})

const imageUrl = computed(() => {
  return new URL(`../../assets/images/${props.item.imgUrl}`, import.meta.url).href;
});



const count = ref(1)

const addCart = () => {
  if (!memberStore.isLogin) {
    alert('로그인을 해주세요🥹');
    memberStore.showLoginModal = true;
    return;
  }
  const cartItemDto = {
    itemId: props.item.id,
    count: count.value
  };
  const name = sessionStorage.getItem('name');

  axios({
    url: `http://localhost:80/cart/add?name=${encodeURIComponent(name)}`,
    method: 'POST',
    data: cartItemDto,
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then((res) => {
      if (res.status == 200) {
        alert('장바구니에 상품을 담았습니다! 🎁')
        memberStore.fetchCart()
      }
    })
    .catch(err => console.error(err));


};
</script>

<style scoped>
.product-thumbnail-slider .swiper-slide {
  height: 100px;
  /* 썸네일 슬라이드의 높이를 줄임 */
}

.thumb-image {
  max-height: 100px;
  object-fit: cover;
  /* 이미지가 슬라이드 높이에 맞게 조정되도록 설정 */
}
</style>
