<script setup>
import { onMounted, ref } from 'vue';
import InputTodo from './component/InputTodo.vue';
import TodoList from './component/TodoList.vue';

//TODO:  토글 함수 생성
// 데이터, 관리함수는 상단에서 관리하는게 좋은듯
//TODO: TS로 객체구조 인터페이스로 만들어도 좋을듯
//TODO: 이벤트 생성
const ts = new Date().toString;
const mockData = [
  { id: ts, todo: '자전거 타기', completed: false },
  {
    id: ts + 1,
    todo: '딸과 공원 산책',
    completed: true,
  },
  {
    id: ts + 2,
    todo: '일요일 애견 카페',
    completed: false,
  },
  {
    id: ts + 3,
    todo: 'Vue 원고 집필',
    completed: false,
  },
];
const todoList = ref([]);
const addTodo = (todo) => {
  todoList.value.push({ id: new Date.toString(), todo: todo, completd: false });
};
const deleteTodo = (id) => {
  const index = todoList.value.findIndex((item) => item.id === id);
  todoList.value.splice(index, 1);
};
// 서버에서 배열로 받아서 바로 사용 가능한가?
onMounted(() => {
  todoList.value = mockData;
  console.log(todoList.value);
});
</script>

<template>
  <h2>My Todo</h2>
  <InputTodo />
  <TodoList :todoList="todoList" />
</template>

<style scoped></style>
