<template>
  <div v-for="(key, val) in subjects" :key="key">
    <label>{{ val.label }}: </label>
    <input type="number" v-model.number="scores[key]" />
  </div>

  <label>평균 : {{ avg_score }} </label>
</template>
<script setup>
import { reactive, computed } from 'vue';
const subjects = [
  { key: 'korea', label: '국어', score: 0 },
  { key: 'english', label: '영어', score: 0 },
  { key: 'math', label: '수학', score: 0 },
];
const scores = reactive({ korea: 0, english: 0, math: 0 });
const avg_score = computed(() => {
  // 객체의 value를 배열로
  // 배열 순회로 합 구하기
  let sum = 0;
  const values = Object.values(scores);
  values.forEach((score) => {
    sum += score;
  });
  return (sum / values.length).toFixed(2);
});
</script>
