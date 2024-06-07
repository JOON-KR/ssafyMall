<template>
  <div ref="wordcloud" style="width: 600px; height: 400px;"></div>
</template>

<script>
import WordCloud from 'wordcloud';

export default {
  name: 'WordCloud',
  props: {
    words: {
      type: Array,
      required: true,
    },
  },
  mounted() {
    this.renderWordCloud();
  },
  methods: {
    renderWordCloud() {
      WordCloud(this.$refs.wordcloud, {
        list: this.words,
      });
    },
  },
};
</script>

<style scoped>
/* 스타일을 여기에 추가할 수 있습니다 */
</style>