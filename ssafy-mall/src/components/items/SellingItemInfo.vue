<template>
  <section class="product-info-tabs py-5">
    <div class="container-fluid">
      <div class="row">
        <div class="d-flex flex-column align-items-start gap-2">

          <!-- 워드 클라우드 -->
          <div>
            <h5 class="mb-3"><strong>{{ item.itemNm }}</strong>는 이런 특징을 가지고 있어요💡</h5>
            <!--상세 설명-->
            <p class="mb-5">{{ item.itemDetail }}</p>

            <div class="d-flex flex-row">
              <div class="flex-fill">
                <h6>장점</h6>
                <WordCloud :words="positiveWords" />
              </div>
              <div class="flex-fill">
                <h6>단점</h6>
                <WordCloud :words="negativeWords" />
              </div>
            </div>
          </div>

          <!-- 리뷰 -->
          <div class="mb-3">
            <div class="add-review mb-10">
              <h3>리뷰 작성</h3>
              <form id="form" class="form-group">
                <div class="pb-3">
                  <label>리뷰를 작성해주세요 !</label>
                  <textarea class="form-control" placeholder="20자 이상 작성해주세요."></textarea>
                </div>
                <button type="submit" name="submit" class="btn btn-dark text-uppercase w-30">작성하기</button>
              </form>
            </div>

            <div class="mt-5 mb-10">
              <h3>리뷰 목록</h3>
              <div class="review-box d-flex flex-wrap">
                <div class="col-lg-6 d-flex flex-wrap gap-3" v-for="review in displayedReviews" :key="review.id">
                  <div class="col-md-8">
                    <div class="review-content">
                      <div class="review-header">
                        <b class="author-name">{{ review.title }}</b>
                        <span class="review-date">{{ review.regDate }}</span>
                      </div>
                      <p>{{ review.content }}</p>
                    </div>
                  </div>
                </div>
              </div>
              <div v-if="!showMore" class="text-center mt-3">
                <button class="btn btn-outline-secondary" @click="toggleShowMore">{{ reviews.length - 4}}개의 리뷰 더보기</button>
              </div>
              <div v-else class="text-center mt-3">
                <button class="btn btn-outline-secondary" @click="toggleShowMore">접기</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import { ref, computed } from 'vue'
import WordCloud from '@/components/commons/WordCloud.vue';

const props = defineProps({
  item: Object,
  score: Number,
  reviews: Array,
  positiveWords: Array,
  negativeWords: Array,
})

const showMore = ref(false);

const displayedReviews = computed(() => {
  return showMore.value ? props.reviews : props.reviews.slice(0, 4);
});

const toggleShowMore = () => {
  showMore.value = !showMore.value;
};

const imageUrl = computed(() => {
  return new URL(`../../assets/images/${props.item.imgUrl}`, import.meta.url).href;
});
</script>

<style scoped>
section {
  padding: 0px 200px 0px 200px;
}

.tab-content {
  border-radius: 30px;
  background-color: rgb(249, 249, 249);
  width: 100%;
  padding: 20px;
}

.container-fluid {
  margin: 0px auto;
}

</style>
