<script setup>
import { storeToRefs } from 'pinia';
import ProductItem from './ProductItem.vue';
import { useProductStore } from '@/stores/counter';

const store = useProductStore();
const { products } = storeToRefs(store);
</script>

<template>
  <h3>상품 목록</h3>
  <ProductItem
    v-for="(product, index) in products"
    :key="index"
    :product="product"
    :index="index"
  />
</template>
