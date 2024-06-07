<template>
  <section class="product-info-tabs py-5">
    <div class="container-fluid">
      <div class="row">
        <div class="d-flex flex-column flex-md-row align-items-start gap-5">
          <!-- nav bar-->
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

            <!--상세 설명-->
            <div class="tab-pane fade show active" id="v-pills-description" role="tabpanel"
              aria-labelledby="v-pills-description-tab" tabindex="0">
              <h5>{{ item.itemNm }}</h5>
              <p>{{ item.itemDetail }}</p>
            </div>

            <!-- 워드 클라우드 -->
            <div class="tab-pane fade" id="v-pills-additional" role="tabpanel" aria-labelledby="v-pills-additional-tab"
              tabindex="0">
              <WordCloud :words="positiveWords" />
              <!-- <WordCloud :words="negativeWords" /> -->
            </div>

            <!-- 리뷰 -->
            <div class="tab-pane fade mb-3" id="v-pills-reviews" role="tabpanel" aria-labelledby="v-pills-reviews-tab"
              tabindex="0">

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
                  <div class="col-lg-6 d-flex flex-wrap gap-3" v-for="review in reviews" :key="review.id">
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
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import { computed } from 'vue'
import WordCloud from '../commons/WordCloud.vue';

export default {
  name: 'App',
  components: {
    WordCloud
  },
  props: {
    item: Object,
    score: Number,
    reviews: Array,
    positiveWords: Array,
    negativeWords: Array,
  },
  setup(props) {
    const imageUrl = computed(() => {
      return new URL(`../../assets/images/${props.item.imgUrl}`, import.meta.url).href;
    });

    return {
      imageUrl
    };
  }
};
</script>

<style scoped>
section {
  padding: 0px 100px 0px 100px;
}

.tab-content {
  border-radius: 30px;
  background-color: rgb(249, 249, 249);
  width: 100%;
  padding: 20px;
}
</style>
