<template>
  <TodoListItem
    v-for="todoItem in todoList"
    :key="todoItem.id"
    :todoItem="todoItem"
    @click-delete="emit('click-delete', id)"
  />
</template>
<script setup>
import { onMounted } from 'vue';
import TodoListItem from './TodoListItem.vue';
const props = defineProps(['todoList']);
const emit = defineEmits(['handleDelete']);
onMounted(() => console.log('todolist'));
</script>
