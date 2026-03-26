<template>
  <div>
    <p>제목: {{ title }}</p>
    <p>내용: {{ content }}</p>
  </div>
  <MyForm v-model:title="title" v-model:content="content" />
</template>

<script>
import MyForm from './MyForm.vue';

export default {
  name: 'App',
  components: { MyForm },
  data() {
    return {
      title: '',
      content: '',
    };
  },
};
</script>
