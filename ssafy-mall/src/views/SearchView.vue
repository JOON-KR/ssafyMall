<template>
    <ItemSearchList :keyword="keyword"/>
</template>

<script setup>
import ItemSearchList from '@/components/items/ItemSearchList.vue'
import { useRoute } from 'vue-router';
import { computed, ref } from 'vue'
const route = useRoute()
const keyword = computed(() => route.params.keyword)
</script>