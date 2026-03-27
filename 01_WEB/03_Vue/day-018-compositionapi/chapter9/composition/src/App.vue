<script setup>
import Child from './Child.vue';
import { ref } from 'vue';
const count = ref(5);
const increase = (event) => {
  count.value = event;
};
const decrease = () => {
  return count.value--;
};
</script>

<template>
  <p>count: {{ count }}</p>
  <Child
    :initCount="count"
    @update-count="increase"
    @click-decrease="decrease"
  />
</template>

<style scoped></style>
