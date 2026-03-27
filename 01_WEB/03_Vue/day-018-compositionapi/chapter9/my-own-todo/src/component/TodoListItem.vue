<template>
  <div>
    <label for="todo">{{ todoItem.todo }}</label>
    <button @click="emits('click-delete'.todoItem.id)">삭제</button>
  </div>
</template>
<script setup>
const props = defineProps(['todoItem']);
const emits = defineEmits(['click-delete']);
</script>
