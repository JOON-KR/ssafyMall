<template>
  <section>
    <div class="container-fluid mb-6">
      <div class="row">
        <div class="col-md-12">
          <div class="bootstrap-tabs product-tabs">
            <div class="tabs-header d-flex justify-content-between border-bottom">
              <h3>'{{ keyword }}' 검색 결과</h3>
            </div>
            <div class="tab-content" id="nav-tabContent" v-if="items.length > 0">
              <div class="tab-pane fade show active" id="nav-all" role="tabpanel" aria-labelledby="nav-all-tab">
                <div class="product-grid row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 row-cols-xl-5">
                  <div class="col" v-for="item in items" :key="item.id">
                    <ItemAllDetail :item="item" />
                  </div>
                </div>
              </div>
            </div>

            <div class="preloader-wrapper" v-if="items.length == 0">
              <div class="preloader">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup>
import ItemAllDetail from './ItemAllDetail.vue';
import axios from 'axios';
import { ref, onMounted, defineProps } from 'vue'
import { fetchKeyword } from '@/assets/search'

const items = ref([])
const props = defineProps({
  keyword: String
})

onMounted(async () => {
  if (props.keyword) {
    try {
      const keywords = await fetchKeyword(props.keyword);
      await axios({
        url: 'http://localhost:80/search',
        method: 'POST',
        data: keywords,
        headers: {
          'Content-Type': 'application/json'
        }
      }).then((res) => {
        items.value = res.data
      }).catch(err => console.error(err))

    } catch (err) {
      console.error(err);
    }
  } else {
    alert("키워드를 입력하세요.");
  }
});
</script>

<style scoped>
section {
  padding: 0px 100px 0px 100px;
}
</style>