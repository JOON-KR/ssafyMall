<template>
  <div ref="wordcloud" style="width: 400px; height: 400px;"></div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import WordCloud from 'wordcloud';

const props = defineProps({
  words: {
    type: Array,
    required: true,
  },
});

const wordcloud = ref(null);

const renderWordCloud = () => {
  console.log("props.words = ", props.words)
  WordCloud(wordcloud.value, {
    list: props.words,
  });
};

onMounted(() => {
  renderWordCloud();
});
</script>

<style scoped>
/* 스타일을 여기에 추가할 수 있습니다 */
</style>
