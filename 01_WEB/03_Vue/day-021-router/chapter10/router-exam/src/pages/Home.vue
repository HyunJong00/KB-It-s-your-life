<template>
  <div>
    <h1>게시물</h1>
    <!-- <ul>
      <li><router-link to="/post/1">１번글</router-link></li>
      <li>
        <router-link :to="{ name: 'post', params: { id: 2 } }"
          >２번글</router-link
        >
      </li>
      <li>
        <router-link :to="{ name: 'post', params: { id: 3 } }"
          >３번글</router-link
        >
      </li>
    </ul> -->
    <ul>
      <li v-for="post in posts" :key="post.id">
        <router-link :to="{ name: 'post', params: { id: post.id } }"
          >ID :{{ posts.id }}번글 }}</router-link
        >
      </li>
    </ul>
  </div>
</template>
<script setup>
import { reactive } from 'vue';
const posts = reactive([{ id: 1 }, { id: 2 }, { id: 3 }]);
</script>
