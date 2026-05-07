<script setup>
import { RouterView } from 'vue-router'
import TheHeader from '@/components/TheHeader.vue'
</script>

<template>
  <TheHeader />

  <main class="container">
    <RouterView />
  </main>

  <footer class="text-center py-4 text-muted mt-5">
    <p>&copy; 2026 My Diary. All rights reserved.</p>
  </footer>
</template>

<style>
:root {
  --bg-pastel-pink: #fff0f3;
  --bg-pastel-yellow: #fff9db;
  --text-warm-brown: #5d4037;
  --primary-pastel: #ffc0cb;
}

body {
  background-color: var(--bg-pastel-pink);
  color: var(--text-warm-brown);
  font-family: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui, Roboto, sans-serif;
}

/* 공통 버튼 스타일 */
.btn-primary {
  background-color: #ff85a1;
  border-color: #ff85a1;
}

.btn-primary:hover {
  background-color: #ff5c8a;
  border-color: #ff5c8a;
}

.card {
  border: none;
  border-radius: 15px;
  background-color: #ffffff;
}
</style>
