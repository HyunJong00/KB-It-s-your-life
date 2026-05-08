<script setup>
import { RouterLink, useRoute, useRouter } from 'vue-router';
import { ref } from 'vue';
import axios from 'axios';

const BASE = '/api/travels';

// 문제 4.	관광지 상세 보기 페이지의 스크립트 코드를 완성하세요.
// 4-1) router를 설정하세요.
const router = useRouter();
// 4-2) currentRoute를 설정하세요.
const currentRoute = useRoute();
// 4-3) 라우트 파라미터에서 id 추출하여 id를 설정하세요.
const id = parseInt(currentRoute.params.id);
// 4-4) 반응형 데이터 travel 정의하세요.
const travel = ref([]);

// 데이터 로드
const load = async () => {
  try {
    // 4-5) load 함수를 완성하세요.
    const response = await axios.get(`${BASE}/${id}`);
    travel.value = response.data;
  } catch (e) {
    console.log(`${id} 얻기 실패!`, e);
  }
};

load(); //초기 데이터 로드 함수 호출

// 4-6) 돌아가기 버튼 이벤트 핸들러 함수 back을 정의하세요.
//      클릭하면 목록 보기로 이동하도록 구현하세요.
const back = () => router.push({ path: '/travel/list' });
</script>
<template>
  <h3>[{{ travel.district }}]{{ travel.title }}</h3>
  <div>{{ travel.address }} / {{ travel.phone }}</div>
  <div>
    <!-- 4-7) 관광지의 이미지 목록을 출력하세요.  -->
    <!--      관광지 이미지의 폭 크기를 150px로 하세요. -->
    <img v-for="image in travel.images" :src="image" style="width: 150px" />
  </div>
  <div>
    {{ travel.description }}
  </div>

  <div>
    <button @click="back">돌아가기</button>
  </div>
</template>
