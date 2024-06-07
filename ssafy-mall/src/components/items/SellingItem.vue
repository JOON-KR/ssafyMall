<template>
  <section id="selling-product" class="single-product mt-0 md-5">
    <div class="container-fluid">
      <div class="row g-5">
        <div class="col-lg-7">
          <div class="row flex-column-reverse flex-lg-row">
            <div class="col-md-12 col-lg-2">
              <!-- product-thumbnail-slider -->
              <Swiper :modules="[Navigation, Pagination, Scrollbar, A11y]" 
              class="product-thumbnail-slider" 
              direction="vertical" 
              slidesPerView="auto" 
              spaceBetween="10" mousewheel>
                <SwiperSlide>
                  <img src="@/assets/images/product-thumbnail-1.jpg" alt="" class="thumb-image img-fluid">
                </SwiperSlide>
                <SwiperSlide>
                  <img src="@/assets/images/product-thumbnail-2.jpg" alt="" class="thumb-image img-fluid">
                </SwiperSlide>
                <SwiperSlide>
                  <img src="@/assets/images/product-thumbnail-3.jpg" alt="" class="thumb-image img-fluid">
                </SwiperSlide>
                <SwiperSlide>
                  <img src="@/assets/images/product-thumbnail-4.jpg" alt="" class="thumb-image img-fluid">
                </SwiperSlide>
                <SwiperSlide>
                  <img src="@/assets/images/product-thumbnail-5.jpg" alt="" class="thumb-image img-fluid">
                </SwiperSlide>
              </Swiper>
              <!-- / product-thumbnail-slider -->
            </div>
            <div class="col-md-12 col-lg-10">
              <!-- product-large-slider -->
              <Swiper :modules="[Navigation, Pagination, Scrollbar, A11y]" 
              class="product-large-slider" 
              slidesPerView="1" 
              pagination :navigation="true">
                <SwiperSlide>
                  <div class="image-zoom" data-scale="2.5" data-image="@/assets/images/product-large-1.jpg">
                    <img src="@/assets/images/product-large-1.jpg" alt="product-large" class="img-fluid">
                  </div>
                </SwiperSlide>
                <SwiperSlide>
                  <div class="image-zoom" data-scale="2.5" data-image="@/assets/images/product-large-2.jpg">
                    <img src="@/assets/images/product-large-2.jpg" alt="product-large" class="img-fluid">
                  </div>
                </SwiperSlide>
                <SwiperSlide>
                  <div class="image-zoom" data-scale="2.5" data-image="@/assets/images/product-large-3.jpg">
                    <img src="@/assets/images/product-large-3.jpg" alt="product-large" class="img-fluid">
                  </div>
                </SwiperSlide>
                <SwiperSlide>
                  <div class="image-zoom" data-scale="2.5" data-image="@/assets/images/product-large-4.jpg">
                    <img src="@/assets/images/product-large-4.jpg" alt="product-large" class="img-fluid">
                  </div>
                </SwiperSlide>
                <SwiperSlide>
                  <div class="image-zoom" data-scale="2.5" data-image="@/assets/images/product-large-5.jpg">
                    <img src="@/assets/images/product-large-5.jpg" alt="product-large" class="img-fluid">
                  </div>
                </SwiperSlide>
              </Swiper>
              <!-- / product-large-slider -->
            </div>
          </div>
        </div>
        <div class="col-lg-5">
          <div class="product-info">
            <div class="element-header">
              <h2 itemprop="name" class="display-6">Cashew Butter 500mg CBD</h2>
              <div class="rating-container d-flex gap-0 align-items-center">
                <div class="rating" data-rating="1">
                  <svg width="32" height="32" class="text-primary">
                    <use xlink:href="#star-solid"></use>
                  </svg>
                </div>
                <div class="rating" data-rating="2">
                  <svg width="32" height="32" class="text-primary">
                    <use xlink:href="#star-solid"></use>
                  </svg>
                </div>
                <div class="rating" data-rating="3">
                  <svg width="32" height="32" class="text-primary">
                    <use xlink:href="#star-solid"></use>
                  </svg>
                </div>
                <div class="rating" data-rating="4">
                  <svg width="32" height="32" class="text-secondary">
                    <use xlink:href="#star-solid"></use>
                  </svg>
                </div>
                <div class="rating" data-rating="5">
                  <svg width="32" height="32" class="text-secondary">
                    <use xlink:href="#star-solid"></use>
                  </svg>
                </div>
                <span class="rating-count">(3.5)</span>
              </div>
            </div>
            <div class="product-price pt-3 pb-3">
              <strong class="text-primary display-6 fw-bold">$870.00</strong><del class="ms-2">$940.00</del>
            </div>
            <p>Justo, cum feugiat imperdiet nulla molestie ac vulputate scelerisque amet. Bibendum adipiscing platea blandit sit sed quam semper rhoncus. Diam ultrices maecenas consequat eu tortor orci, cras lectus mauris, cras egestas quam venenatis neque.</p>
            <div class="cart-wrap py-5">
              <div class="color-options product-select">
                <div class="color-toggle" data-option-index="0">
                  <h6 class="item-title text-uppercase text-dark">Color:</h6>
                  <ul class="select-list list-unstyled d-flex">
                    <li class="select-item pe-3" data-val="Green" title="Green">
                      <a href="#" class="btn btn-light active">Green</a>
                    </li>
                    <li class="select-item pe-3" data-val="Orange" title="Orange">
                      <a href="#" class="btn btn-light">Orange</a>
                    </li>
                    <li class="select-item pe-3" data-val="Red" title="Red">
                      <a href="#" class="btn btn-light">Red</a>
                    </li>
                    <li class="select-item" data-val="Black" title="Black">
                      <a href="#" class="btn btn-light disabled">Black</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div class="swatch product-select" data-option-index="1">
                <h6 class="item-title text-uppercase text-dark">Size:</h6>
                <ul class="select-list list-unstyled d-flex">
                  <li data-value="S" class="select-item pe-3">
                    <a href="#" class="btn btn-light">XL</a>
                  </li>
                  <li data-value="M" class="select-item pe-3">
                    <a href="#" class="btn btn-light">L</a>
                  </li>
                  <li data-value="L" class="select-item pe-3">
                    <a href="#" class="btn btn-light">M</a>
                  </li>
                  <li data-value="L" class="select-item">
                    <a href="#" class="btn btn-light">S</a>
                  </li>
                </ul>
              </div>
              <div class="product-quantity pt-3">
                <div class="stock-number text-dark"><em>2 in stock</em></div>
                <div class="stock-button-wrap">
                  <div class="input-group product-qty" style="max-width: 150px;">
                    <span class="input-group-btn">
                      <button type="button" class="quantity-left-minus btn btn-light btn-number" data-type="minus" data-field="">
                        <svg width="16" height="16">
                          <use xlink:href="#minus"></use>
                        </svg>
                      </button>
                    </span>
                    <input type="text" id="quantity" name="quantity" class="form-control input-number text-center" value="1" min="1" max="100">
                    <span class="input-group-btn">
                      <button type="button" class="quantity-right-plus btn btn-light btn-number" data-type="plus" data-field="">
                        <svg width="16" height="16">
                          <use xlink:href="#plus"></use>
                        </svg>
                      </button>
                    </span>
                  </div>
                  <div class="qty-button d-flex flex-wrap pt-3">
                    <button type="submit" class="btn btn-primary py-3 px-4 text-uppercase me-3 mt-3">Buy now</button>
                    <button type="submit" name="add-to-cart" value="1269" class="btn btn-dark py-3 px-4 text-uppercase mt-3">Add to cart</button>
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
</script>

<style scoped>
.product-thumbnail-slider .swiper-slide {
  height: 100px; /* 썸네일 슬라이드의 높이를 줄임 */
}
.thumb-image {
  max-height: 100px;
  object-fit: cover; /* 이미지가 슬라이드 높이에 맞게 조정되도록 설정 */
}
</style>
