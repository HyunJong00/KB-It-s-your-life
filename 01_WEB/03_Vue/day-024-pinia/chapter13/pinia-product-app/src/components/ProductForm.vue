<script setup>
import { useProductStore } from '@/stores/counter';
import { storeToRefs } from 'pinia';
import { reactive } from 'vue';

const store = useProductStore();
const { products } = storeToRefs(store);
const { addProduct } = useProductStore();
const form = reactive({
  name: '',
  price: 0,
  quantity: 0,
});
const submitForm = () => {
  addProduct({ ...form });

  form.name = '';
  form.price = 0;
  form.quantity = 0;
  console.log(products.value); // 첫 번째 상품의 name
};
</script>

<template>
  <div>
    <h3>상품 등록</h3>
    상품명:
    <input type="text" placeholder="상품명 입력" v-model="form.name" /><br />
    단가:
    <input
      type="number"
      placeholder="단가 입력"
      v-model.number="form.price"
    /><br />
    개수:
    <input
      type="number"
      placeholder="개수 입력"
      v-model.number="form.quantity"
    /><br /><br />
    <button @click="submitForm">등록</button>
  </div>
</template>
