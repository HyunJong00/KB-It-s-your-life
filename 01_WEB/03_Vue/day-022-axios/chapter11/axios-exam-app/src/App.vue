<script setup>
import axios from 'axios';
import { onMounted, reactive, ref } from 'vue';

const users = reactive([]);
const name = ref('');
//onmount

onMounted(async () => {
  const res = await axios.get('/api/users');
  console.log(...res.data);
  console.log(res.data);
  users.splice(0, users.length, ...res.data);
});
//추가
const addUser = async () => {
  if (!name.value) return;
  const res = await axios.post('/api/users', { name: name.value });
  users.push(res.data);
  console.log();
  name.value = '';
};
//get
const getUser = async () => {
  const res = await axios.get('/api/users');
  users.splice(0, users.length, ...res.data);
};
//del
const deleteUser = async (id) => {
  await axios.delete(`/api/users/${id}`);
  const index = users.findIndex((item) => item.id === id);
  users.splice(index, 1);
};
</script>

<template>
  <h1>사용자 관리</h1>

  <input v-model="name" placeholder="이름 입력" />
  <button @click="addUser">추가</button>
  <button @click="getUser">목록</button>
  <hr />
  <ul>
    <li v-for="user in users" :key="user.id">
      {{ user.id }}/ {{ user.name }}
      <button @click="deleteUser(user.id)">삭제</button>
    </li>
  </ul>
</template>

<style scoped>
input {
  margin-right: 10px;
}
</style>
