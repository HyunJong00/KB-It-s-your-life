<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일 :</label>
        <input type="text" class="form-control" id="todo" />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명 :</label>
        <textarea class="form-control" rows="3" id="desc"></textarea>
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="addTodoHandler"
        >
          추 가
        </button>
        <button type="button" class="btn btn-primary m-1">취 소</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, reactive } from 'vue';
import { useRoute } from 'vue-router';

const router = useRoute;
const { addTodo } = inject('action');
const todoItem = reactive({ todo: '', desc: '' });

const addTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할일을 입력해주세요');
    return;
  }
  // ()은 콜백임)
  addTodo({ ...todoItem }, () => {
    router.push('/todos');
  });
};
</script>
