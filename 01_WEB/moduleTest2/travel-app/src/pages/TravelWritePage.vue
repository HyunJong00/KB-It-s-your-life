<script setup>
import { reactive } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const BASE = '/api/travels';

// 문제 5.	관광지 등록 코드를 완성하세요.
// 5-1) router를 설정하세요.
const router = useRouter();
// 5-2) reactive로 반응형 데이터 travel를 정의하세요.
const travel = reactive({ images: [] });

const submit = async () => {
  // 5-3)submit 이벤트 핸들러에서 "등록하시겠습니까?" 물어보고
  // 예를 누른 경우에 등록하도록 하세요.
  if (confirm('등록하시겠습니까?')) {
    try {
      // 5-4) submit 이벤트 핸들러 함수를 완성하세요.
      //      - 추가된 관광지의 id값은 JSON 서버에서 자동 추가됨.
      //      - 입력한 데이터가 JSON서버에 저장
      //      - 목록보기로 이동
      const payload = travel;
      axios.post(BASE, payload);
      back();
    } catch (e) {
      console.log('관광지 생성 실패', e);
    }
  }
};

// 5-5) 돌아가기 버튼 이벤트 핸들러 함수 back을 정의하세요.
//      클릭하면 목록 보기로 이동하도록 구현하세요.
const back = () => router.push({ path: '/travel/list' });
</script>

<template>
  <h2 class="my-5">관광지 등록</h2>

  <!-- 5-6) submit 이벤트 핸들러를 등록하세요. -->
  <!--      submit 디폴트 액션은 차단하세요. -->
  <form @click.prevent>
    <div>
      <label> 권역: </label>
      <input type="text" v-model="travel.district" />
    </div>
    <div>
      <label> 관광지명: </label>
      <input type="text" v-model="travel.title" />
    </div>
    <div>
      <label> 주소: </label>
      <input type="text" v-model="travel.address" />
    </div>
    <div>
      <label> 전화번호: </label>
      <input type="text" v-model="travel.phone" />
    </div>
    <div>
      <label> 설명: </label><br />
      <textarea v-model="travel.description" rows="5" cols="80"></textarea>
    </div>
    <input type="submit" value="확인" @click.prevent="submit" />
    &nbsp;&nbsp;
    <button type="button" @click="back">돌아가기</button>
  </form>
</template>
