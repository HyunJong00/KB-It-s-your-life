<template>
  <div class="d-flex justify-content-between align-items-center mb-4">
    <h3 class="text-warm mb-0">
      <i class="fas fa-calendar-alt me-2 text-pink"></i>나의 일기 달력
    </h3>
    <RouterLink to="/write" class="btn btn-primary rounded-pill px-4 shadow-sm">
      <i class="fas fa-plus me-2"></i>새 일기
    </RouterLink>
  </div>
</template>

<style scoped>
.text-pink { color: #ff85a1; }
</style>
