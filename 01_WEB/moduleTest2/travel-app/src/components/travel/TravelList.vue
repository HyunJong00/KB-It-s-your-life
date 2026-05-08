<script setup>
import TravelItem from './TravelItem.vue';

// 문제 3. TravelList.vue 컴포넌트를 완성하세요.
// 3-1). travels 프로퍼티를 정의하세요.
const props = defineProps(['travels']);
</script>

<template>
  <div>
    <!-- 3-2) travels 프로퍼티로 TravelItem 컴포넌트를 관광지수 만큼 렌더링 하세요. -->
    <TravelItem v-for="travel in travels" :key="travel.id" :travel="travel" />
  </div>
</template>
