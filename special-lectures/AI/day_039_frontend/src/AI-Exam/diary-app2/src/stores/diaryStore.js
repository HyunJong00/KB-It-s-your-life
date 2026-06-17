import { defineStore } from 'pinia';
import { ref } from 'vue';
import diaryApi from '@/api/diaryApi';

export const useDiaryStore = defineStore('diary', () => {
  const diaryList = ref([]);
  const currentDiary = ref(null);
  const isLoading = ref(false);

  // 일기 목록 가져오기 (날짜 필터링 포함)
  const fetchDiaryList = async (date = null) => {
    isLoading.value = true;
    try {
      const params = date ? { date } : {};
      diaryList.value = await diaryApi.getDiaryList(params);
    } catch (error) {
      console.error('Failed to fetch diary list:', error);
    } finally {
      isLoading.value = false;
    }
  };

  // 특정 날짜의 일기 하나 가져오기
  const fetchDiaryByDate = async (date) => {
    isLoading.value = true;
    try {
      const data = await diaryApi.getDiaryList({ date });
      currentDiary.value = data.length > 0 ? data[0] : null;
    } catch (error) {
      console.error(`Failed to fetch diary for date ${date}:`, error);
    } finally {
      isLoading.value = false;
    }
  };

  // 단일 일기 상세 정보 가져오기
  const fetchDiary = async (id) => {
    isLoading.value = true;
    try {
      currentDiary.value = await diaryApi.getDiary(id);
    } catch (error) {
      console.error(`Failed to fetch diary with id ${id}:`, error);
    } finally {
      isLoading.value = false;
    }
  };

  // 일기 추가
  const addDiary = async (diary) => {
    isLoading.value = true;
    try {
      const newDiary = await diaryApi.createDiary(diary);
      diaryList.value.push(newDiary);
    } catch (error) {
      console.error('Failed to add diary:', error);
    } finally {
      isLoading.value = false;
    }
  };

  // 일기 수정
  const updateDiary = async (id, updatedData) => {
    isLoading.value = true;
    try {
      const updatedDiary = await diaryApi.updateDiary(id, updatedData);
      
      // 목록 업데이트
      const index = diaryList.value.findIndex(d => d.id === id);
      if (index !== -1) diaryList.value[index] = updatedDiary;
      
      // 현재 상세 정보가 수정된 데이터라면 업데이트
      if (currentDiary.value?.id === id) {
        currentDiary.value = updatedDiary;
      }
    } catch (error) {
      console.error(`Failed to update diary with id ${id}:`, error);
    } finally {
      isLoading.value = false;
    }
  };

  // 일기 삭제
  const deleteDiary = async (id) => {
    isLoading.value = true;
    try {
      await diaryApi.deleteDiary(id);
      diaryList.value = diaryList.value.filter(d => d.id !== id);
      
      if (currentDiary.value?.id === id) {
        currentDiary.value = null;
      }
    } catch (error) {
      console.error(`Failed to delete diary with id ${id}:`, error);
    } finally {
      isLoading.value = false;
    }
  };

  return {
    diaryList,
    currentDiary,
    isLoading,
    fetchDiaryList,
    fetchDiary,
    addDiary,
    updateDiary,
    deleteDiary
  };
});
