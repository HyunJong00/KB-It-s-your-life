<script setup>
import { RouterLink } from 'vue-router';

// 문제 3. TravelItem.vue 컴포넌트를 완성하세요.
const props = defineProps({ travel: { type: Object, required: true } });
</script>

<template>
  <div>
    <!-- 3-3) 관광지의 대표이미지(첫번째 이미지) 출력하세요. 
              이미지의 폭을 20px로 합니다.  
              이미지가 없다면 출력하지 않습니다.
          -->
    <img
      v-if="travel.images[0]"
      :src="travel.images[0]"
      style="width: 20px; height: 20px"
    />
    <RouterLink :to="{ name: 'travel/view', params: { id: travel.id } }">
      {{ travel.title }}
    </RouterLink>
    <hr />
  </div>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
