<script setup>
import { onMounted } from 'vue';
import { useDiaryStore } from '@/stores/diaryStore';
import DiaryListHeader from '@/components/diary/DiaryListHeader.vue';
import DiaryCalendar from '@/components/diary/DiaryCalendar.vue';
import DiaryCalendarLegend from '@/components/diary/DiaryCalendarLegend.vue';

const diaryStore = useDiaryStore();

onMounted(async () => {
  await diaryStore.fetchDiaryList();
});
</script>

<template>
  <div class="diary-list-view mx-auto" style="max-width: 900px;">
    <div class="card shadow-sm p-4 border-0 rounded-4">
      <DiaryListHeader />
      
      <div v-if="diaryStore.isLoading && diaryStore.diaryList.length === 0" class="text-center py-5">
        <div class="spinner-border text-pink" role="status">
          <span class="visually-hidden">Loading...</span>
        </div>
      </div>
      
      <DiaryCalendar v-else />
      
      <DiaryCalendarLegend />
    </div>
  </div>
</template>

<style scoped>
.text-pink {
  color: #ff85a1 !important;
}
</style>
