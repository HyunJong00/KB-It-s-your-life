<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div classe="title">:: TodolistApp</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoList
          :todoList="state.todoList"
          @delete-todo="deleteTodo"
          @toggle-completed="toggleCompleted"
        />
      </div>
    </div>
  </div>
</template>
<script setup>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';

import { reactive, onMounted } from 'vue';

const ts = new Date().getTime();
const state = reactive({ todoList: [] });

// const todoList = reactive([]);
// 위의 경우 서버의 새로운 list로 대체해야 할 경우 : todoList = new Arr; 로 안됨
// 반응형이 아닌 순수배열이 됨
// state.todoList = new Arr; 하게 되면 반응성 잃지 않음
// 객체가 하나밖에 없더라도 멤버로 선언하는 이유

onMounted(() => {
  // onMounted 통해 서버에서 데이터 받는것 처럼 상황 가정
  state.todoList.push({ id: ts, todo: '자전거 타기', completed: false });
  state.todoList.push({
    id: ts + 1,
    todo: '딸과 공원 산책',
    completed: true,
  });
  state.todoList.push({
    id: ts + 2,
    todo: '일요일 애견 카페',
    completed: false,
  });
  state.todoList.push({
    id: ts + 3,
    todo: 'Vue 원고 집필',
    completed: false,
  });
});
const addTodo = (todo) => {
  if (todo.length >= 2) {
    state.todoList.push({
      id: new Date().getTime(),
      todo: todo,
      complted: false,
    });
  }
};
const deleteTodo = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  state.todoList.splice(index, 1);
};
const toggleCompleted = (id) => {
  let index = state.todoList.findIndex((item) => item.id === id);
  state.todoList[index].completed = !state.todoList[index].completed;
};
</script>
