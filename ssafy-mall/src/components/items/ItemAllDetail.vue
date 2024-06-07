<template>
    <div class="product-item" v-if="item != null">
        <a href="#" class="btn-wishlist"><svg width="24" height="24">
                <use xlink:href="#heart"></use>
            </svg></a>
        <figure>
            <a title="Product Title"  @click="goItemDetail(item)">
                <img :src="imageUrl" class="tab-image">
            </a>
        </figure>
        <h3 @click="goItemDetail(item)">{{ item.itemNm }}</h3>
        <span class="qty">1 Unit</span><span class="rating"><svg width="24" height="24" class="text-primary">
                <use xlink:href="#star-solid"></use>
            </svg> 4.5</span>
        <span class="price" @click="goItemDetail(item)">₩ {{ item.price }}</span>
        <div class="d-flex align-items-center justify-content-between">
            <div class="input-group product-qty">
                <span class="input-group-btn">
                    <button type="button" class="quantity-left-minus btn btn-danger btn-number" data-type="minus">
                        <svg width="16" height="16">
                            <use xlink:href="#minus"></use>
                        </svg>
                    </button>
                </span>
                <input type="text" id="quantity" name="quantity" class="form-control input-number" value="1">
                <span class="input-group-btn">
                    <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus">
                        <svg width="16" height="16">
                            <use xlink:href="#plus"></use>
                        </svg>
                    </button>
                </span>
            </div>
            <a href="#" class="nav-link">장바구니 <iconify-icon icon="uil:shopping-cart" /></a>
        </div>
    </div>
</template>

<script setup>
import { computed, defineProps } from 'vue'
import { useRouter } from 'vue-router';

const router = useRouter()
const props = defineProps({
    item: Object,
})

const imageUrl = computed(() => {
  return new URL(`../../assets/images/${props.item.imgUrl}`, import.meta.url).href;
});

const goItemDetail = (item) => {
  router.push(`/item/${item.itemNm}`)
}
</script>