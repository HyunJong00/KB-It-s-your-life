<template>
  <h1>게시물 상세 페이지</h1>
  <h3>ID {{ currentRoute.params.id }}</h3>
</template>
<script setup>
import { useRoute } from 'vue-router';
const currentRoute = useRoute();
</script>
