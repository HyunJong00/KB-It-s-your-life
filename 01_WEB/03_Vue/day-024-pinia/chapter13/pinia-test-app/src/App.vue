<script setup>
import { useCounterStore } from './stores/counter';

const { increment } = useCounterStore();
const store = useCounterStore;
const doubleCount = computed(() => store.doubleCount);
</script>

<template>
  count: {{ store.count }} doubleCount : {{ doubleCount }}
  <div>
    <button @click="increment">increase</button>
  </div>
</template>
<style scoped></style>
