<script setup>
import { onMounted, computed } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { useDiaryStore } from '@/stores/diaryStore';

const route = useRoute();
const router = useRouter();
const diaryStore = useDiaryStore();

const id = route.params.id;

const weatherIcons = {
  '맑음': { icon: 'fa-sun', color: 'text-warning' },
  '흐림': { icon: 'fa-cloud', color: 'text-secondary' },
  '비': { icon: 'fa-cloud-showers-heavy', color: 'text-primary' },
  '눈': { icon: 'fa-snowflake', color: 'text-info' },
  '바람': { icon: 'fa-wind', color: 'text-success' }
};

const diary = computed(() => diaryStore.currentDiary);

const deleteDiary = async () => {
  if (confirm('정말로 이 일기를 삭제할까요?')) {
    await diaryStore.deleteDiary(id);
    router.push('/');
  }
};

const goBack = () => {
  router.push('/');
};

const goToEdit = () => {
  router.push({ name: 'edit', params: { id } });
};

onMounted(async () => {
  await diaryStore.fetchDiary(id);
});
</script>

<template>
  <div class="detail-container mx-auto" style="max-width: 800px;">
    <div v-if="diaryStore.isLoading" class="text-center py-5">
      <div class="spinner-border text-pink" role="status">
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>

    <div v-else-if="diary" class="card shadow-sm border-0 overflow-hidden">
      <!-- 상단 색상 바 -->
      <div class="bg-pastel-pink py-2"></div>
      
      <div class="card-body p-4 p-md-5">
        <div class="d-flex justify-content-between align-items-start mb-4">
          <div>
            <span class="badge rounded-pill bg-white text-pink border-pink mb-2 px-3">
              <i class="fas fa-calendar-alt me-1"></i>{{ diary.date }}
            </span>
            <h1 class="display-6 fw-bold text-warm mb-0">{{ diary.title }}</h1>
          </div>
          <div class="weather-display text-center">
            <i class="fas fa-3x mb-1" :class="[weatherIcons[diary.weather]?.icon, weatherIcons[diary.weather]?.color]"></i>
            <div class="small text-muted">{{ diary.weather }}</div>
          </div>
        </div>

        <hr class="my-4 opacity-10">

        <div class="diary-content mb-5">
          <p class="lead text-warm-brown pre-wrap">{{ diary.content }}</p>
        </div>

        <div class="d-flex justify-content-between align-items-center mt-auto pt-4 border-top">
          <button @click="goBack" class="btn btn-outline-secondary rounded-pill px-4">
            <i class="fas fa-arrow-left me-2"></i>목록으로
          </button>
          <div class="btn-group gap-2">
            <button @click="goToEdit" class="btn btn-outline-pastel rounded-pill px-4">
              <i class="fas fa-edit me-2"></i>수정
            </button>
            <button @click="deleteDiary" class="btn btn-outline-danger rounded-pill px-4">
              <i class="fas fa-trash-alt me-2"></i>삭제
            </button>
          </div>
        </div>
      </div>

      <div class="card-footer bg-light border-0 py-3 text-center small text-muted">
        작성일: {{ new Date(diary.createdAt).toLocaleString() }}
      </div>
    </div>

    <div v-else class="text-center py-5">
      <p>일기를 찾을 수 없습니다.</p>
      <button @click="goBack" class="btn btn-primary rounded-pill">목록으로 돌아가기</button>
    </div>
  </div>
</template>

<style scoped>
.text-pink { color: #ff85a1; }
.border-pink { border: 1px solid #ff85a1 !important; }
.bg-pastel-pink { background-color: #fff0f3; }
.text-warm-brown { color: #5d4037; }

.pre-wrap {
  white-space: pre-wrap;
  word-break: break-all;
  line-height: 2;
}

.btn-outline-pastel {
  border-color: #ffc0cb;
  color: #ff85a1;
}

.btn-outline-pastel:hover {
  background-color: #fff0f3;
  border-color: #ff85a1;
  color: #ff85a1;
}

.spinner-border.text-pink {
  color: #ff85a1 !important;
}

.weather-display i {
  filter: drop-shadow(0 2px 4px rgba(0,0,0,0.05));
}
</style>
