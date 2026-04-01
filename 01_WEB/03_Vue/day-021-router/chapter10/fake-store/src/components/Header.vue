<script setup></script>

<template>
  <header>이미지</header>
  <nav class="navbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <router-link :to="{ name: 'home' }">Fake Store</router-link>
      </li>
      <li class="nav-item">
        <router-link :to="{ name: 'eletronics' }">가전</router-link>
      </li>
      <li class="nav-item">
        <router-link :to="JeweleryPage">쥬얼리</router-link>
      </li>
      <li class="nav-item">
        <router-link :to="MensClothingPage">남성의류</router-link>
      </li>
      <li class="nav-item">
        <router-link :to="WomensClothingPage">여성의류</router-link>
      </li>
    </ul>
  </nav>
</template>
