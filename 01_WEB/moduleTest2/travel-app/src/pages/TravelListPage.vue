<script setup>
import TravelList from '@/components/travel/TravelList.vue';
import { reactive } from 'vue';

import axios from 'axios';

const BASE = '/api/travels';

const state = reactive({ travels: [] });

// 문제 2. src/pages/TravelListPage.vue에서는 관광지 목록을 서버로부터 받아, TravelList 컴포넌트로 전달한다.
// 스크립트 파트를 완성하세요.

// load 함수
const load = async () => {
  try {
    // 2-1) load 함수를 완성하세요.
    const response = await axios.get(BASE);
    state.travels = response.data;
  } catch (e) {
    console.log('목록 요청 에러 ', e);
  }
};

load(); //초기 데이터 로드 함수 호출
</script>

<template>
  <h2>관광지 목록</h2>

  <!-- 2-2) TravelList 컴포넌트를 배치하고 travels 프로퍼티를 설정하세요 -->
  <TravelList :travels="state.travels"></TravelList>
  <div>
    <router-link to="/travel/write">관광지 추가</router-link>
  </div>
</template>
