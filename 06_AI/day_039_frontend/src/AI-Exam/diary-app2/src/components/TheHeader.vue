<script setup>
import { RouterLink } from 'vue-router'
</script>

<template>
  <nav class="navbar navbar-expand-sm navbar-light bg-pastel shadow-sm mb-4">
    <div class="container">
      <RouterLink class="navbar-brand" to="/">
        <i class="fas fa-book-heart me-2"></i>나의 일기장
      </RouterLink>
      
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <RouterLink class="nav-link" active-class="active" to="/">
              <i class="fas fa-calendar-alt me-1"></i>목록
            </RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" active-class="active" to="/write">
              <i class="fas fa-pen-nib me-1"></i>일기 쓰기
            </RouterLink>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<style scoped>
.bg-pastel {
  background-color: #ffffffd4 !important;
  backdrop-filter: blur(5px);
}

.navbar-brand {
  font-weight: 700;
  color: #e91e63 !important;
}

.nav-link {
  font-weight: 500;
  transition: all 0.3s ease;
  color: #5d4037;
}

.nav-link:hover {
  color: #e91e63 !important;
}

.nav-link.active {
  color: #e91e63 !important;
  border-bottom: 2px solid #e91e63;
}
</style>
