import { defineStore } from 'pinia'
import { ref, watchEffect } from 'vue'

/**
 * DiaryStore - 일기 데이터 관리를 위한 Pinia 스토어
 */
export const useDiaryStore = defineStore('diary', () => {
  // 일기 목록 상태 (초기값은 빈 배열)
  const diaries = ref([])

  // 앱 초기화 시 로컬 스토리지에서 데이터 로드
  const storedDiaries = localStorage.getItem('diaries')
  if (storedDiaries) {
    try {
      diaries.value = JSON.parse(storedDiaries)
    } catch (e) {
      console.error('LocalStorage 데이터 복구 실패:', e)
      diaries.value = []
    }
  }

  /**
   * watchEffect를 사용하여 상태 변화가 감지될 때마다 로컬 스토리지에 자동 저장
   * diaries.value를 참조하므로 반응형으로 동작함
   */
  watchEffect(() => {
    localStorage.setItem('diaries', JSON.stringify(diaries.value))
  })

  /**
   * 새 일기 추가
   * @param {string} content - 일기 내용
   */
  const addDiary = (content) => {
    const newDiary = {
      id: Date.now(), // 타임스탬프를 고유 ID로 사용
      content,
      createdAt: new Date().toISOString() // 현재 시간을 ISO 문자열로 저장
    }
    // 배열의 앞에 추가하여 최신순으로 정렬되게 함 (선택 사항, 여기서는 push 사용)
    diaries.value.unshift(newDiary)
  }

  /**
   * 특정 일기 삭제
   * @param {number} id - 삭제할 일기의 고유 ID
   */
  const deleteDiary = (id) => {
    diaries.value = diaries.value.filter((diary) => diary.id !== id)
  }

  // 외부에서 사용할 상태와 함수 반환
  return {
    diaries,
    addDiary,
    deleteDiary
  }
})
