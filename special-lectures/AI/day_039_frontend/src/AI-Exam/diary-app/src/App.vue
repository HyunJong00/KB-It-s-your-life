<script setup>
/**
 * App.vue - 메인 레이아웃 컴포넌트
 * 따뜻한 파스텔 톤 테마와 Bootstrap5를 결합한 레이아웃
 */
import DiaryForm from './components/DiaryForm.vue'
import DiaryList from './components/DiaryList.vue'
</script>

<template>
  <div class="app-wrapper min-vh-100 py-5">
    <div class="container">
      <!-- 헤더 섹션: 따뜻한 느낌의 제목과 설명 -->
      <header class="text-center mb-5">
        <div class="title-container mb-3">
          <h1 class="display-4 fw-bold text-warm-brown">
            <i class="fas fa-feather-alt me-3 title-icon"></i>나의 포근한 일기장
          </h1>
          <div class="title-underline mx-auto"></div>
        </div>
        <p class="lead text-secondary-warm">
          <i class="fas fa-mug-hot me-2"></i>
          오늘 하루의 조각들을 따뜻하게 기록해보세요
        </p>
      </header>

      <main class="row justify-content-center">
        <div class="col-lg-7 col-md-9">
          <!-- 일기 작성 섹션 -->
          <section class="mb-5">
            <DiaryForm />
          </section>
          
          <!-- 구분선: 부드러운 파스텔 톤 -->
          <div class="divider mb-5">
            <i class="fas fa-star text-pastel-yellow"></i>
          </div>

          <!-- 일기 목록 섹션 -->
          <section>
            <DiaryList />
          </section>
        </div>
      </main>

      <!-- 푸터 섹션 -->
      <footer class="text-center mt-5 py-4 text-secondary-warm border-top border-pastel">
        <p class="mb-0 small">
          <i class="fas fa-heart text-pastel-pink me-1"></i> 
          2026 따스한 기록 프로젝트 | 
          <a href="#" class="text-decoration-none text-secondary-warm fw-bold ms-1">
            <i class="fab fa-github me-1"></i>GitHub
          </a>
        </p>
      </footer>
    </div>
  </div>
</template>

<style>
/* 폰트 및 배경색 설정 (따뜻한 베이지/아이보리 톤) */
body {
  background-color: #fdfaf5; /* 매우 밝은 베이지색 */
  font-family: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui, Roboto, sans-serif;
  color: #5d4037; /* 부드러운 갈색 텍스트 */
}

/* 앱 전체 배경 래퍼 */
.app-wrapper {
  background: linear-gradient(135deg, #fdfaf5 0%, #f7ede2 100%);
}

/* 텍스트 컬러 커스텀 */
.text-warm-brown {
  color: #6d4c41;
}
.text-secondary-warm {
  color: #8d6e63;
}
.text-pastel-yellow {
  color: #ffd54f;
}
.text-pastel-pink {
  color: #f48fb1;
}

/* 타이틀 장식 */
.title-container {
  display: inline-block;
}
.title-icon {
  color: #a1887f;
}
.title-underline {
  height: 4px;
  width: 60%;
  background: linear-gradient(to right, #f48fb1, #ffd54f);
  border-radius: 2px;
  opacity: 0.6;
}

/* 구분선 스타일 */
.divider {
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
}
.divider::before, .divider::after {
  content: "";
  flex: 1;
  height: 1px;
  background-color: #e0e0e0;
}
.divider i {
  margin: 0 15px;
  font-size: 0.8rem;
}

/* Bootstrap 컴포넌트 오버라이드 (파스텔 느낌) */
.card {
  border-radius: 1.25rem !important;
  background-color: rgba(255, 255, 255, 0.8) !important;
  backdrop-filter: blur(5px);
}

.border-pastel {
  border-color: #eee4da !important;
}

/* 버튼 파스텔 톤 적용 (DiaryForm에서 사용될 기본 스타일링) */
.btn-primary {
  background-color: #f48fb1 !important; /* 파스텔 핑크 */
  border-color: #f48fb1 !important;
  color: white !important;
  border-radius: 0.75rem !important;
  font-weight: bold !important;
  transition: all 0.3s ease !important;
}
.btn-primary:hover {
  background-color: #f06292 !important;
  transform: translateY(-1px);
  box-shadow: 0 4px 8px rgba(244, 143, 177, 0.3);
}

/* 배지 파스텔 톤 */
.badge.bg-primary {
  background-color: #81c784 !important; /* 파스텔 그린 */
}
</style>
