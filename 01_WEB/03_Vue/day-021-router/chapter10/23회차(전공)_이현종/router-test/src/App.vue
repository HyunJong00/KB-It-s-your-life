<script setup>
import { RouterLink, RouterView } from 'vue-router';
import Header from './components/Header.vue';
</script>

<template>
  <Header />
  <div class="container">
    <RouterView />
  </div>
</template>

<style>
.container {
  text-align: center;
  margin-top: 10px;
}
</style>
