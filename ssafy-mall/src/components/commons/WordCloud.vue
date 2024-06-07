<template>
  <div ref="wordcloudContainer" style="width: 600px; height: 400px;"></div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import WordCloud from 'wordcloud';

const wordcloudContainer = ref(null);

const props = defineProps({
  words: {
    type: Array,
    required: true,
  },
});

const renderWordCloud = () => {
  if (wordcloudContainer.value) {
    WordCloud(wordcloudContainer.value, {
      list: props.words,
    });
  }
};

onMounted(() => {
  renderWordCloud();
});
</script>

<style scoped>
/* 스타일을 여기에 추가할 수 있습니다 */
</style>
