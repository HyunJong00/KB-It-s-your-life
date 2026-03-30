const loginBtn = document.getElementById('loginBtn');
const errorBox = document.getElementById('errorBox');
const inputId = document.getElementById('userId');
const inputPassword = document.getElementById('userPw');
const users = [
  { id: 12, password: 12 },
  { id: 'admin', password: 1234 },
  { id: 11, password: 11 },
];

// 메시지 초기화 함수
// 로그인 시도 전에 기존 메시지를 모두 숨기고 초기화
function resetMessages() {
  // 메시지 영역 숨기기
  errorBox.classList.add('hidden');
  successBox.classList.add('hidden');
  helperLink.classList.add('hidden');

  // 메시지 내용 초기화
  errorBox.textContent = '';
  successBox.textContent = '';
}
resetMessages();
loginBtn.addEventListener('click', () => {
  errorBox.textContent = '오류가 발생했습니다.';
  errorBox.classList.remove('hidden');

  const user = users.find((user) => user.id == inputId.value);

  if (user == undefined) {
    errorBox.textContent = '아이디가 잘못 입력되었습니다.';
  } else if (user.password != inputPassword.value) {
    errorBox.textContent = '비밀번호가 잘못 입력되었습니다.';
  } else {
    errorBox.classList.add('hidden');
    successBox.classList.remove('hidden');
    successBox.textContent = '로그인에 성공했습니다.';
  }
});
