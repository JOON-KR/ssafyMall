<template>
  <div>
    <div v-if="item != null && score != 0 && positiveWords != null && negativeWords != null">
      <SellingItem :item="item" :score="score" />
      <SellingItemInfo :item="item" :positive-words="positiveWords" :negative-words="negativeWords" :score="score"
        :reviews="reviews" />

      <ItemCosineList :item="item" />

    </div>
    <div class="preloader-wrapper" v-else>
      <div class="preloader">
      </div>
    </div>
  </div>
</template>

<script setup>
import SellingItem from '@/components/items/SellingItem.vue'
import SellingItemInfo from '@/components/items/SellingItemInfo.vue';
import ItemCosineList from '@/components/items/ItemCosineList.vue';
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRoute } from 'vue-router';

const URL = 'http://localhost:80'

const positiveWords = ref([])
const negativeWords = ref([])
const reviews = ref([])
const score = ref(0)

const route = useRoute()
const item = ref()

const fetchData = async () => {
  try {
    const itemResponse = await axios(`${URL}${route.path}`)
    item.value = itemResponse.data

    const positiveResponse = await axios(`${URL}/positive/${item.value.itemNm}`)
    positiveWords.value = positiveResponse.data
    console.log(positiveWords)
    const negativeResponse = await axios(`${URL}/negative/${item.value.itemNm}`)
    negativeWords.value = negativeResponse.data

    const reviewResponse = await axios(`${URL}/review/${item.value.itemNm}`)
    reviews.value = reviewResponse.data

    const scoreResponse = await axios(`${URL}/score/${item.value.itemNm}`)
    score.value = scoreResponse.data
  } catch (err) {
    console.log(err)
  }
}

onMounted(() => {
  fetchData()
})
</script>

<style></style>
