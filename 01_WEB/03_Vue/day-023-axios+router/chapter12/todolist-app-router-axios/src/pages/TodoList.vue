<template>
  <div class="row">
    <div class="col p-3">
      <router-link class="btn btn-primary" to="/todos/add"
        >할일 추가</router-link
      >
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="ist-group">
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
  </div>
  <h2>Todo 목록 보기</h2>
</template>

<script setup>
import TodoItem from '../components/TodoItem.vue';
import { inject } from 'vue';

const todoList = inject('todoList');
</script>
