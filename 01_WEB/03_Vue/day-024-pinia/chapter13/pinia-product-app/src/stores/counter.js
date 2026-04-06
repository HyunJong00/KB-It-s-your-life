import { ref, reactive, computed } from 'vue';
import { defineStore } from 'pinia';

export const useProductStore = defineStore('product', () => {
  // const state = reactive({ pruduct: [] });
  const products = ref([
    { name: '새우깡', price: 2500, quantity: 3 },
    {
      name: '포카칩',
      price: 1500,
      quantity: 4,
    },
  ]);
  const addProduct = ({ name, price, quantity }) => {
    products.value.push({ name: name, price: price, quantity: quantity });
  };
  const deleteProduct = (index) => {
    console.log('value' + products.value);
    products.value.splice(index, 1);
  };
  return { products, addProduct, deleteProduct };
});
