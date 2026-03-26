<template>
  <UserPanel v-model:username="username" />
  <ThemeDisplay />
</template>
<script>
import ThemeDisplay from './ThemeDisplay.vue';
import UserPanel from './UserPanel.vue';

export default {
  name: 'App',
  components: { UserPanel, ThemeDisplay },
  data() {
    return { theme: 'dark', username: '' };
  },
  provide() {
    return {
      theme: this.theme,
      username: this.username,
    };
  },
};
</script>
<style scoped></style>
