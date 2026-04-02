<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>
<script setup>
import axios from 'axios';
const requestAPI = () => {
  const url = 'http://localhost:3000/todos/1';
  axios.get(url).then((response) => {
    console.log('# 응답객체 : ', response.data);
  });
};

// proxy 설정 후 + async/await
const requetsAPI2 = async () => {
  const url = '/api/todos';
  let todoList;
  let response = await axios.get(url);
  todoList = response.data;
  console.log('after proxy: ', todoList);
};
requestAPI();
requetsAPI2();
</script>
