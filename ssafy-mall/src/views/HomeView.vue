<script setup>
import Mainbanner from '@/components/banners/Mainbanner.vue'
import ItemJaccardList from '@/components/items/ItemJaccardList.vue';
import ItemPopularList from '@/components/items/ItemPopularList.vue';
import ItemAllList from '@/components/items/ItemAllList.vue';
</script>

<template>
  <main>
    <Mainbanner />
    <ItemJaccardList />
    <ItemPopularList />
    <ItemAllList />
  </main>
</template>
