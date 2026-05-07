<script setup>
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import { useDiaryStore } from '@/stores/diaryStore';

const route = useRoute();
const router = useRouter();
const diaryStore = useDiaryStore();

const id = route.params.id;

const diary = ref({
  title: '',
  date: '',
  weather: '맑음',
  content: ''
});

const weathers = [
  { label: '맑음', icon: 'fa-sun', color: 'text-warning' },
  { label: '흐림', icon: 'fa-cloud', color: 'text-secondary' },
  { label: '비', icon: 'fa-cloud-showers-heavy', color: 'text-primary' },
  { label: '눈', icon: 'fa-snowflake', color: 'text-info' },
  { label: '바람', icon: 'fa-wind', color: 'text-success' }
];

const updateDiary = async () => {
  if (!diary.value.title.trim() || !diary.value.content.trim()) {
    alert('제목과 내용을 모두 입력해주세요!');
    return;
  }

  await diaryStore.updateDiary(id, {
    ...diary.value
  });
  
  router.push({ name: 'detail', params: { id } });
};

const goBack = () => {
  router.back();
};

onMounted(async () => {
  await diaryStore.fetchDiary(id);
  if (diaryStore.currentDiary) {
    diary.value = { ...diaryStore.currentDiary };
  } else {
    alert('일기를 찾을 수 없습니다.');
    router.push('/');
  }
});
</script>

<template>
  <div class="edit-container mx-auto" style="max-width: 800px;">
    <div v-if="diaryStore.isLoading && !diary.title" class="text-center py-5">
      <div class="spinner-border text-pink" role="status">
        <span class="visually-hidden">Loading...</span>
      </div>
    </div>

    <div v-else class="card shadow-sm border-0 p-4">
      <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-warm mb-0">
          <i class="fas fa-edit me-2 text-pink"></i>이야기 수정하기
        </h2>
        <button @click="goBack" class="btn btn-light btn-sm rounded-pill px-3">
          <i class="fas fa-times me-1"></i>취소
        </button>
      </div>

      <form @submit.prevent="updateDiary">
        <div class="row g-3">
          <div class="col-md-6">
            <label class="form-label fw-bold small text-muted">날짜</label>
            <input type="date" v-model="diary.date" class="form-control rounded-pill border-pastel" required />
          </div>
          <div class="col-md-6">
            <label class="form-label fw-bold small text-muted">날씨</label>
            <div class="d-flex justify-content-between bg-light p-1 rounded-pill border-pastel">
              <button
                v-for="w in weathers"
                :key="w.label"
                type="button"
                class="btn btn-sm rounded-circle weather-btn"
                :class="[diary.weather === w.label ? 'active-weather shadow-sm' : 'text-muted']"
                @click="diary.weather = w.label"
                :title="w.label"
              >
                <i class="fas" :class="[w.icon, diary.weather === w.label ? w.color : '']"></i>
              </button>
            </div>
          </div>

          <div class="col-12 mt-4">
            <label class="form-label fw-bold small text-muted">제목</label>
            <input
              type="text"
              v-model="diary.title"
              class="form-control border-pastel border-0 border-bottom rounded-0 px-0 fs-4"
              placeholder="제목을 입력하세요"
              required
            />
          </div>

          <div class="col-12 mt-4">
            <label class="form-label fw-bold small text-muted">일기 내용</label>
            <textarea
              v-model="diary.content"
              class="form-control border-pastel p-3"
              rows="12"
              placeholder="내용을 입력하세요"
              required
            ></textarea>
          </div>

          <div class="col-12 mt-5 text-center">
            <button type="submit" class="btn btn-primary btn-lg rounded-pill px-5 shadow" :disabled="diaryStore.isLoading">
              <i class="fas fa-save me-2"></i>수정 완료
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>
.text-pink { color: #ff85a1; }
.border-pastel { border-color: #fff0f3 !important; }

.form-control:focus {
  box-shadow: 0 0 0 0.25rem rgba(255, 192, 203, 0.25);
  border-color: #ffc0cb;
}

.weather-btn {
  width: 36px;
  height: 36px;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: all 0.2s ease;
  border: none;
  background: transparent;
}

.active-weather {
  background-color: white !important;
  transform: scale(1.1);
}

textarea {
  resize: none;
  border-radius: 15px;
  line-height: 1.8;
}
</style>
