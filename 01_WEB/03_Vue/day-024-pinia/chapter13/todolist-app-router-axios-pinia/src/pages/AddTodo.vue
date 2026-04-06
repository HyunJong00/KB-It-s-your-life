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
        <!--추가 버튼, 취소버튼 구현 필요-->
        <button type="button" class="btn btn-primary m-1">추 가</button>
        <button type="button" class="btn btn-primary m-1">취 소</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import { useRoute } from 'vue-router';
import { useTodoListStore } from '../store/todoList';

const router = useRoute;
const { addTodo } = useTodoListStore();
const todoItem = reactive({ todo: '', desc: '' });

const addTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할일을 입력해주세요');
    return;
  }
  // addTodo(todoItem) 으로 입력 할 경우 reactive객체로 들어감.
  addTodo({ ...todoItem });
  router.push('/todos');
};
</script>
