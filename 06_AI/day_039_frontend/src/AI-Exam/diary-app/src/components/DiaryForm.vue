<script setup>
/**
 * DiaryForm.vue - 일기 작성 폼 컴포넌트
 */
import { ref } from 'vue'
import { useDiaryStore } from '../stores/DiaryStore'

// Pinia 스토어 인스턴스 가져오기
const diaryStore = useDiaryStore()

// 입력 필드와 연결된 반응형 데이터
const content = ref('')

/**
 * 일기 저장 핸들러
 */
const handleSubmit = () => {
  // 공백 제외 유효성 검사
  if (!content.value.trim()) {
    alert('내용을 입력해주세요!')
    return
  }
  
  // 스토어의 addDiary 액션 호출
  diaryStore.addDiary(content.value)
  
  // 입력 필드 초기화
  content.value = ''
}
</script>

<template>
  <div class="card mb-4 shadow-sm border-0">
    <div class="card-body">
      <form @submit.prevent="handleSubmit">
        <div class="mb-3">
          <label for="diaryContent" class="form-label fw-bold">
            <!-- FontAwesome 아이콘 추가: 연필 모양 -->
            <i class="fas fa-pencil-alt me-2 text-primary"></i>오늘의 생각
          </label>
          <textarea
            id="diaryContent"
            class="form-control"
            rows="3"
            v-model="content"
            placeholder="어떤 하루를 보내셨나요? 지금의 감정을 기록해보세요."
          ></textarea>
        </div>
        <div class="d-grid">
          <button type="submit" class="btn btn-primary">
            <!-- FontAwesome 아이콘 추가: 체크 및 저장 -->
            <i class="fas fa-check-circle me-1"></i>기록하기
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>
/* 텍스트 영역 크기 조절 방지 및 포커스 스타일 커스텀 */
textarea {
  resize: none;
}
textarea:focus {
  border-color: #0d6efd;
  box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.1);
}
</style>
