<script setup>
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import { useDiaryStore } from '@/stores/diaryStore';

const router = useRouter();
const diaryStore = useDiaryStore();

const selectedDate = ref(new Date());

// 일기 데이터를 VCalendar 속성(Attributes) 형식으로 변환
const attributes = computed(() => {
  const attrs = diaryStore.diaryList.map(diary => ({
    key: diary.id,
    dot: {
      color: 'pink',
      class: 'diary-dot'
    },
    dates: new Date(diary.date),
    customData: diary,
    popover: {
      label: diary.title,
      visibility: 'hover',
    },
  }));

  // 오늘 날짜 특수 표시 추가
  attrs.push({
    key: 'today',
    highlight: {
      color: 'pink',
      fillMode: 'outline',
      class: 'today-highlight',
    },
    dates: new Date(),
  });

  return attrs;
});

// 날짜 클릭 핸들러
const onDayClick = (day) => {
  const dateStr = day.id; // YYYY-MM-DD 형식
  const diary = diaryStore.diaryList.find(d => d.date === dateStr);
  
  if (diary) {
    router.push({ name: 'detail', params: { id: diary.id } });
  } else {
    router.push({ name: 'write', query: { date: dateStr } });
  }
};
</script>

<template>
  <div class="calendar-wrapper">
    <VDatePicker
      v-model="selectedDate"
      :attributes="attributes"
      @dayclick="onDayClick"
      expanded
      borderless
      transparent
      locale="ko"
      title-position="left"
      class="custom-calendar"
    />
  </div>
</template>

<style>
/* VCalendar 스타일 커스텀 (전역 스타일 영향 방지를 위해 wrapper 사용 권장이나 v-calendar 특성상 전역 설정이 많음) */
.custom-calendar .vc-header {
  margin-bottom: 20px;
}

.custom-calendar .vc-title {
  color: #5d4037;
  font-size: 1.5rem;
  font-weight: 700;
  background: transparent;
}

.custom-calendar .vc-weekday {
  color: #8d6e63;
  font-weight: 600;
}

.custom-calendar .vc-day {
  min-height: 80px;
  cursor: pointer;
}

.custom-calendar .vc-day:hover .vc-day-content {
  background-color: #fff0f3 !important;
}

.custom-calendar .vc-highlight {
  background-color: #ffc0cb !important;
}

.vc-pink {
  --vc-accent-500: #ff85a1;
}

.today-highlight {
  border: 2px solid #ff85a1 !important;
  animation: pulse-border 2s infinite;
}

@keyframes pulse-border {
  0% { transform: scale(1); opacity: 1; }
  50% { transform: scale(1.05); opacity: 0.7; }
  100% { transform: scale(1); opacity: 1; }
}

.diary-dot {
  width: 8px !important;
  height: 8px !important;
  box-shadow: 0 0 5px rgba(255, 133, 161, 0.5);
}
</style>
