<script setup>
/**
 * DiaryList.vue - 일기 목록 표시 컴포넌트
 */
import { useDiaryStore } from '../stores/DiaryStore'

// Pinia 스토어 인스턴스 가져오기
const diaryStore = useDiaryStore()

/**
 * 날짜 포맷팅 함수
 * @param {string} dateString - ISO 날짜 문자열
 * @returns {string} 포맷팅된 날짜 (한국어 기준)
 */
const formatDate = (dateString) => {
  if (!dateString) return ''
  const date = new Date(dateString)
  return date.toLocaleString('ko-KR', {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    hour: '2-digit',
    minute: '2-digit'
  })
}

/**
 * 삭제 버튼 클릭 핸들러
 * @param {number} id - 삭제할 일기의 고유 ID
 */
const handleDelete = (id) => {
  if (confirm('이 기록을 영구적으로 삭제하시겠습니까?')) {
    diaryStore.deleteDiary(id)
  }
}
</script>

<template>
  <div class="diary-list">
    <!-- 목록 헤더 -->
    <div class="d-flex justify-content-between align-items-center mb-4">
      <h4 class="mb-0 fw-bold text-dark">
        <i class="fas fa-stream me-2 text-primary"></i>지난 기록들
      </h4>
      <span class="badge bg-primary rounded-pill px-3">
        <i class="fas fa-sticky-note me-1"></i> 총 {{ diaryStore.diaries.length }}개
      </span>
    </div>

    <!-- 일기가 없을 때 표시할 빈 상태 화면 (Empty State) -->
    <div v-if="diaryStore.diaries.length === 0" class="text-center py-5 bg-white rounded shadow-sm border border-light">
      <i class="fas fa-ghost fa-3x mb-3 text-muted opacity-50"></i>
      <p class="text-muted mb-0 font-italic">아직 기록된 일기가 없습니다.</p>
      <small class="text-secondary">작은 기록이 큰 추억이 됩니다.</small>
    </div>

    <!-- 일기 목록 렌더링 -->
    <div v-else class="row g-4">
      <div v-for="diary in diaryStore.diaries" :key="diary.id" class="col-12">
        <div class="card shadow-sm border-0 h-100 diary-card">
          <div class="card-body p-4">
            <div class="d-flex justify-content-between align-items-start mb-3">
              <div class="date-info">
                <i class="far fa-calendar-alt me-2 text-secondary"></i>
                <small class="text-muted fw-bold">
                  {{ formatDate(diary.createdAt) }}
                </small>
              </div>
              <!-- 삭제 버튼 -->
              <button 
                @click="handleDelete(diary.id)" 
                class="btn btn-link text-danger p-0 border-0"
                title="기록 삭제"
              >
                <i class="fas fa-minus-circle"></i>
              </button>
            </div>
            <!-- 일기 내용 -->
            <p class="card-text text-dark white-space-pre mb-0">
              <i class="fas fa-quote-left me-2 text-light"></i>
              {{ diary.content }}
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* 텍스트의 줄바꿈 처리 */
.white-space-pre {
  white-space: pre-wrap;
  word-break: break-all;
  line-height: 1.6;
}

/* 카드 호버 효과 */
.diary-card {
  transition: all 0.3s ease;
  border-left: 4px solid transparent !important;
}
.diary-card:hover {
  transform: translateX(5px);
  border-left-color: #0d6efd !important;
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.1) !important;
}

.date-info i {
  font-size: 0.9rem;
}

.fa-quote-left {
  font-size: 1.2rem;
  vertical-align: top;
}
</style>
