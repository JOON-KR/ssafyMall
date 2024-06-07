<template>
    <div class="product-item" v-if="item != null">
        <a href="#" class="btn-wishlist"><svg width="24" height="24">
                <use xlink:href="#heart"></use>
            </svg></a>
        <figure>
            <a title="Product Title" @click="goItemDetail(item)">
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
                    <button type="button" class="quantity-left-minus btn btn-danger btn-number" data-type="minus"
                        @click="count--" :disabled="count == 1">
                        <svg width="16" height="16">
                            <use xlink:href="#minus"></use>
                        </svg>
                    </button>
                </span>
                <input type="text" id="quantity" name="quantity" class="form-control input-number" :value="count">
                <span class="input-group-btn">
                    <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus"
                        @click="count++" :disabled="count == 20">
                        <svg width="16" height="16">
                            <use xlink:href="#plus"></use>
                        </svg>
                    </button>
                </span>
            </div>
            <div class="nav-link cart" @click="addCart">장바구니 <iconify-icon icon="uil:shopping-cart" /></div>
        </div>
    </div>
</template>

<script setup>
import { ref, computed, defineProps, watch, onMounted } from 'vue'
import { useRouter } from 'vue-router';
import { useMemberStore } from '@/stores/member';
import axios from 'axios';

const memberStore = useMemberStore()
const router = useRouter()
const props = defineProps({
    item: Object,
})

const imageUrl = computed(() => {
    return new URL(`../../assets/images/${props.item.imgUrl}`, import.meta.url).href;
});

const count = ref(1)

const goItemDetail = (item) => {
    router.push(`/item/${item.itemNm}`)
}

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
            if(res.status == 200) {
              alert('장바구니에 상품을 담았습니다! 🎁')
              memberStore.fetchCart()
            }        })
        .catch(err => console.error(err));


};


</script>

<style scoped>
:disabled {
    background-color: rgb(235, 235, 235);
    border: none;
    cursor: not-allowed;
    opacity: 0.6;
}

:disabled svg {
    fill: rgba(0, 0, 0, 0.3);
}

.quantity-left-minus:disabled,
.quantity-right-plus:disabled {
    background-color: #e6e5e5;
    border-color: #e6e5e5;
    color: #777;
}

@keyframes changeColorAndSize {
    0% {
        color: inherit;
        transform: scale(1);
    }

    100% {
        color: orange;
        transform: scale(1.1);
    }
}

.cart {
    position: relative;
    display: inline-block;
    transition: color 0.5s, transform 0.5s;
}

.cart:hover {
    animation: changeColorAndSize 0.5s forwards;
}
</style>
