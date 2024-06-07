<template>
    <div id="app">
        <WordCloud :words="wordList" />
    </div>
</template>

<script>
import WordCloud from './WordCloud.vue';
export default {
    name: 'App',
    components: {
        WordCloud,
    },
    data() {
        return {
            wordList: [
                ['안녕', 30],
                ['Vue', 25],
                ['Word', 40],
                ['Cloud', 12],
                ['Example', 50],

            ],
        };
    },
};
</script>




<style scoped></style>