<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          placeholder="할일을여기에입력!"
          v-model.trim="todo"
          @keyup.enter="addTodoHandler"
        />
        <span class="btn btn-primary input-group-addon" @click="addTodoHandler"
          >추가</span
        >
      </div>
    </div>
  </div>
</template>
<script setup>
import { ref } from 'vue';

const todo = ref('');
const emit = defineEmits(['add-todo']);

const addTodoHandler = () => {
  if (todo.value.length >= 3) {
    emit('add-todo', todo.value);
    todo.value = '';
  }
};
</script>
