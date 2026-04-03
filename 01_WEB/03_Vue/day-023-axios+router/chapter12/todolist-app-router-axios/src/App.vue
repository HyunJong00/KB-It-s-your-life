<template>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>

<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';

const states = reactive({
  todoList: [
    { id: 1, todo: 'ES6학습', desc: '설명1', done: false },
    { id: 2, todo: 'React학습', desc: '설명2', done: false },
    { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
    { id: 4, todo: '야구경기 관람', desc: '설명4', done: false },
  ],
});

const addTodo = ({ todo, desc }) => {};

// updateTodo({ id: 1, todo: 'vue 학습', desc: 'vue는 중요해요', done: false });
const updateTodo = ({ id, todo, desc, done }) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index] = { ...states.todoList[index], todo, desc, done };
};
const deleteTodo = () => {};
const toggleDone = () => {};
// todoList는 읽기 전용으로 전달하므로 함수를 전달하여 호출 가능하도록 함
provide(
  'todoList',
  computed(() => states.todoList),
);
provide('action', { addTodo, deleteTodo, toggleDone, updateTodo });
</script>
