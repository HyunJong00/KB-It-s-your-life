<template>
  <div class="card card-body">
    <h2>About</h2>
    <p>요청 경로 : {{ currentRoute.fullPath }}</p>
  </div>
</template>
<script setup>
import { useRoute } from 'vue-router';

const currentRoute = useRoute();
console.log(currentRoute);
</script>
