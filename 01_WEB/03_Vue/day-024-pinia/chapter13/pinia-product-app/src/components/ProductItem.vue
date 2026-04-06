<script setup>
import { useProductStore } from '@/stores/counter';
import { defineProps } from 'vue';
const props = defineProps(['product', 'index']);

const store = useProductStore();
const { deleteProduct } = store;
</script>

<template>
  <div class="container">
    <div>상품명: {{ props.product.name }}</div>
    <div>단가: {{ props.product.price }}</div>
    <div>개수: {{ props.product.quantity }}</div>
    <div>합계: {{ props.product.price * props.product.quantity }}</div>
    번호: {{ props.index + 1 }}
    <button @click="deleteProduct(props.index)">삭제</button>
  </div>
</template>
<style scoped>
.container {
  border: 1px solid black;
}
div {
  margin: 10px;
}
</style>
