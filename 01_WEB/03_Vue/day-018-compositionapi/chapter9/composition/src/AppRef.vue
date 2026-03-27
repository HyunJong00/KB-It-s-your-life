<template>
  <div>
    <input type="text" v-model="count" />
    <p>Count:{{ count }}</p>
    <button @click="countUp">up</button>
    <button @click="countDown">down</button>
  </div>
</template>
<script setup>
import { ref } from 'vue';
const count = ref(0);
const countUp = () => count.value++;
const countDown = () => count.value--;
</script>
