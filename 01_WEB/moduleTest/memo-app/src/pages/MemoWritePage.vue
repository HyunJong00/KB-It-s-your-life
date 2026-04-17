<script setup>
import { ref, reactive } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const BASE = '/api/memo';

// 문제 5.	메모 등록 코드를 완성하세요.
// 5-1) router를 설정하세요.
const router = useRouter();
// 5-2) reactive로 반응형 데이터 memo를 정의하세요.
const memo = reactive({ title: '', content: '' });
const submit = async () => {
  try {
    // 5-3) submit 이벤트 핸들러 함수를 완성하세요.
    //      - 추가된 메모의 id값은 JSON 서버에서 자동 추가됨.
    //      - 입력한 데이터가 JSON서버에 저장
    //      - 목록보기로 이동
    await axios.post(BASE, { title: memo.title, content: memo.content });
    back();
  } catch (e) {
    console.log('목록 생성 실패', e);
  }
};

// 5-4) 돌아가기 버튼 이벤트 핸들러 함수 back을 정의하세요.
//      클릭하면 목록 보기로 이동하도록 구현하세요.
const back = () => {
  router.go(-1);
};
</script>

<template>
  <h2>새 메모 작성</h2>

  <div>제목: <input v-model="memo.title" /></div>
  <!-- 5-5) submit 이벤트 핸들러를 등록하세요. -->
  <!--      submit 디폴트 액션은 차단하세요. -->
  <form>
    <div>
      내용:
      <textarea rows="5" style="width: 100%" v-model="memo.content"></textarea>
    </div>
    <input type="submit" value="확인" @click.prevent="submit" />
    <button @click="back">돌아가기</button>
  </form>
</template>

<style scoped></style>
