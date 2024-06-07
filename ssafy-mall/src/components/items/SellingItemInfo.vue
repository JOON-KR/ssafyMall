<template>
  <section class="product-info-tabs py-5">
    <div class="container-fluid">
      <div class="row">
        <div class="d-flex flex-column flex-md-row align-items-start gap-5">
          <div class="nav flex-row flex-wrap flex-md-column nav-pills me-3 col-lg-3" id="v-pills-tab" role="tablist"
            aria-orientation="vertical">
            <button class="nav-link text-start active" id="v-pills-description-tab" data-bs-toggle="pill"
              data-bs-target="#v-pills-description" type="button" role="tab" aria-controls="v-pills-description"
              aria-selected="true">상세 설명</button>
            <button class="nav-link text-start" id="v-pills-additional-tab" data-bs-toggle="pill"
              data-bs-target="#v-pills-additional" type="button" role="tab" aria-controls="v-pills-additional"
              aria-selected="false">키워드</button>
            <button class="nav-link text-start" id="v-pills-reviews-tab" data-bs-toggle="pill"
              data-bs-target="#v-pills-reviews" type="button" role="tab" aria-controls="v-pills-reviews"
              aria-selected="false">리뷰 보기</button>
          </div>
          <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-description" role="tabpanel"
              aria-labelledby="v-pills-description-tab" tabindex="0">
              <h5>{{  item.itemNm }}</h5>
              <p>{{ item.itemDetail }}</p>

              <!-- <ul style="list-style-type:disc;" class="list-unstyled ps-4">
                <li>Donec nec justo eget felis facilisis fermentum.</li>
                <li>Suspendisse urna viverra non, semper suscipit pede.</li>
                <li>Aliquam porttitor mauris sit amet orci.</li>
              </ul>
              <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros.
                Nullam malesuada erat ut turpis. Suspendisse urna viverra non, semper suscipit, posuere a, pede. Donec
                nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim
                pellentesque felis. Phasellus ultrices nulla quis nibh. Quisque a lectus. Donec consectetuer ligula
                vulputate sem tristique cursus. </p> -->
            </div>
            <div class="tab-pane fade" id="v-pills-additional" role="tabpanel"
              aria-labelledby="v-pills-additional-tab" tabindex="0">
              <WordCloud :words="positiveWords" />
              <!-- <WordCloud :words="negativeWords" /> -->
            </div>
            <div class="tab-pane fade mb-3" id="v-pills-reviews" role="tabpanel" aria-labelledby="v-pills-reviews-tab"
              tabindex="0">
              
              <div class="add-review mt-5">
                <h3>리뷰 작성</h3>
                <form id="form" class="form-group">

                  <div class="pb-3">
                    <label>리뷰를 작성해주세요 !</label>
                    <textarea class="form-control" placeholder="20자 이상 작성해주세요."></textarea>
                  </div>
                  <button type="submit" name="submit"
                    class="btn btn-dark text-uppercase w-30">작성하기</button>
                </form>
              </div>

              <div class="review-box d-flex flex-wrap">
                <div class="col-lg-6 d-flex flex-wrap gap-3" v-for="review in reviews" :key="review.id">
                  <div class="col-md-2">
                    <div class="image-holder">
                      <img src="@/assets/images/reviewer-2.jpg" alt="review" class="img-fluid rounded-circle">
                    </div>
                  </div>
                  <div class="col-md-8">
                    <div class="review-content">
                      <div class="rating-container d-flex align-items-center">
                        <div class="rating" data-rating="1">
                          <svg width="24" height="24" class="text-primary">
                            <use xlink:href="#star-solid"></use>
                          </svg>
                        </div>
                        <div class="rating" data-rating="2">
                          <svg width="24" height="24" class="text-primary">
                            <use xlink:href="#star-solid"></use>
                          </svg>
                        </div>
                        <div class="rating" data-rating="3">
                          <svg width="24" height="24" class="text-primary">
                            <use xlink:href="#star-solid"></use>
                          </svg>
                        </div>
                        <div class="rating" data-rating="4">
                          <svg width="24" height="24" class="text-secondary">
                            <use xlink:href="#star-solid"></use>
                          </svg>
                        </div>
                        <div class="rating" data-rating="5">
                          <svg width="24" height="24" class="text-secondary">
                            <use xlink:href="#star-solid"></use>
                          </svg>
                        </div>
                        <span class="rating-count">(3.5)</span>
                      </div>
                      <div class="review-header">
                        <span class="author-name">{{ review.title }}</span>
                        <span class="review-date">{{ review.regDate }}</span>
                      </div>
                      <p>{{ review.content }}</p>
                    </div>
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
import { computed } from 'vue'
import WordCloud from '../commons/WordCloud.vue';

const props = defineProps({
    item: Object,
    score: Number,
    reviews: Array,
    positiveWords: Array,
    negativeWords: Array,
})

const imageUrl = computed(() => {
  return new URL(`../../assets/images/${props.item.imgUrl}`, import.meta.url).href;
});

</script>