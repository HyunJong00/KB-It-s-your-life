<template>
  <div class="mt-4 d-flex justify-content-center gap-3 small text-muted">
    <div class="d-flex align-items-center">
      <span class="dot-sample bg-pink me-1"></span> 일기 있음
    </div>
    <div class="d-flex align-items-center">
      <span class="dot-sample border-pink me-1"></span> 오늘
    </div>
  </div>
</template>

<style scoped>
.dot-sample {
  width: 10px;
  height: 10px;
  border-radius: 50%;
  display: inline-block;
}
.bg-pink { background-color: #ff85a1; }
.border-pink { border: 2px solid #ffc0cb; }
</style>
