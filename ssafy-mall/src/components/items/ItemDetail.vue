<template>
  <div class="card mb-3 p-3 rounded-4 shadow border-0" @click="goItemDetail">
    <div class="row g-0">
      <div class="col-md-4 img-div">
        <img :src="imageUrl" class="img-fluid rounded mb-3" alt="itemImg">
      </div>
      <div class="col-md-8">
        <div class="card-body py-0">
          <h5 class="card-title">{{ item.itemNm }}</h5>
          <p class="text-muted mb-0">₩ {{ item.price }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { defineProps, computed } from 'vue';
import { useRouter } from 'vue-router';

const props = defineProps({
  item: Object
});

const router = useRouter()
const goItemDetail = () => {
  router.push(`/item/${props.item.itemNm}`)
}

const imageUrl = computed(() => {
  return new URL(`../../assets/images/${props.item.imgUrl}`, import.meta.url).href;
});
</script>

<style scoped>
.img-div {
  width: 150px;
  height: 150px;
  display: block;
  margin: 0 auto;
}

img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>
