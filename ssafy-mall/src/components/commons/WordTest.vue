<template>
    <div id="app">
      <WordCloud :words="wordList" />
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import WordCloud from '@/components/commons/WordCloud.vue';
  
  const wordList = ref([
    ['안녕', 30],
    ['Vue', 25],
    ['Word', 40],
    ['Cloud', 12],
    ['Example', 50],
  ]);
  </script>
  
  <style scoped></style>
  