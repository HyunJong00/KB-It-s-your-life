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
      <span>완료된 할일: {{ doneCount }}</span>
    </div>
  </div>
  <h2>Todo 목록 보기</h2>
</template>

<script setup>
import TodoItem from '../components/TodoItem.vue';
import { useTodoListStore } from '../store/todoList';
import { computed } from 'vue';

const todoListStore = useTodoListStore();
const { fetchTodoList } = todoListStore;
const doneCount = computed(() => todoListStore.doneCount);
const todoList = computed(() => todoListStore.todoList);
</script>
