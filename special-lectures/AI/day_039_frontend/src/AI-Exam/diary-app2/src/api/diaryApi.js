import axios from 'axios';

const BASE_URL = '/api/diary';

const diaryApi = {
  // 일기 목록 조회 (날짜 등 필터링 지원)
  async getDiaryList(params) {
    const response = await axios.get(BASE_URL, { params });
    return response.data;
  },

  // 특정 일기 조회
  async getDiary(id) {
    const response = await axios.get(`${BASE_URL}/${id}`);
    return response.data;
  },

  // 일기 작성
  async createDiary(diary) {
    const response = await axios.post(BASE_URL, diary);
    return response.data;
  },

  // 일기 수정
  async updateDiary(id, diary) {
    const response = await axios.put(`${BASE_URL}/${id}`, diary);
    return response.data;
  },

  // 일기 삭제
  async deleteDiary(id) {
    const response = await axios.delete(`${BASE_URL}/${id}`);
    return response.data;
  }
};

export default diaryApi;
