<template>
  <button @click="increase">증가</button>
  <button @click="emit('click-decrease')">감소</button>
</template>
<script setup>
//TODO: v-model로 만들어보기
//[x]: child에서 increase함수 만들고, emit()하기
const props = defineProps(['initCount']);
import { ref } from 'vue';
const emit = defineEmits(['update-count', 'click-decrease']);

const count = ref(props.initCount);
const increase = () => {
  count.value++;
  emit('update-count', count.value);
};
</script>
