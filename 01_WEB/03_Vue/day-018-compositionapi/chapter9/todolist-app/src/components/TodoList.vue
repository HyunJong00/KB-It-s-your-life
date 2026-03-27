<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
          @delete-todo="emit('delete-todo', todoItem.id)"
          @toggle-completed="emit('toggle-completed', todoItem.id)"
        />
      </ul>
    </div>
  </div>
</template>
<script setup>
import TodoListItem from './TodoListItem.vue';

// 템플릿에서만 사용하므로 없어도 됨?
// 없으니까 안되는데?
const props = defineProps({
  todoList: { type: Array, required: true },
});

const emit = defineEmits(['delete-todo', 'toggle-completed']);
</script>
