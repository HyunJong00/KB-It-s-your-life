<script setup>
import MemoList from '@/components/MemoList.vue';
import { ref } from 'vue';
import axios from 'axios';

const BASE = '/api/memo';

// 문제2. src/pages/MemoLsitPage.vue에서는 메모 목록을 서버로부터 받아, MemoList 컴포넌트로 전달한다.
// 스크립트 파트를 완성하세요.

// 2-1) memos를 정의하세요.
const memos = ref('');
// load 함수
const load = async () => {
  try {
    // 2-2) load 함수를 완성하세요.
    const response = await axios.get(BASE);
    memos.value = response.data;
  } catch (e) {
    console.log('목록 요청 에러 ', e);
  }
};

load(); //초기 데이터 로드 함수 호출
</script>

<template>
  <h2>Memo 목록</h2>
  <MemoList :memos="memos" />

  <div>
    <router-link to="/memo/write">새 메모</router-link>
  </div>
</template>

<style scoped></style>
