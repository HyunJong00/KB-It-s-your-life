<script setup>
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';

const BASE = '/api/memo';

// 문제 4.	메모 상세 보기 페이지의 스크립트 코드를 완성하세요.
// 4-1) router를 설정하세요.
const router = useRouter();
// 4-2) currentRoute를 설정하세요.
const currentRoute = useRoute();
// 4-3) 쿼리 파라미터에서 id 추출하여 id를 설정하세요.
const id = currentRoute.params.id;
// 4-4) 반응형 데이터 memo 정의하세요.
const memo = ref('');
// 데이 로드
const load = async () => {
  try {
    // 4-5) load 함수를 완성하세요.
    const response = await axios.get(`${BASE}/${id}`);
    memo.value = response.data;
  } catch (e) {
    console.log(`${id} 얻기 실패!`, e);
  }
};

load(); //초기 데이터 로드 함수 호출

// 4-6) 돌아가기 버튼 이벤트 핸들러 함수 back을 정의하세요.
//      클릭하면 목록 보기로 이동하도록 구현하세요.
const back = () => {
  router.go(-1);
};
</script>

<template>
  <div>
    <h2>제목: {{ memo.title }}</h2>
    <hr />
    {{ memo.content }}
    <div>
      <button @click="back">돌아가기</button>
    </div>
  </div>
</template>

<style scoped></style>
