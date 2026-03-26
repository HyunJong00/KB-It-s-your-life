<template>
  <h2>User Panel</h2>
  <p>현재 사용자: {{ username }}</p>
  <UserForm
    v-model:username="username"
    @update="$emit('update:username', username)"
  />
</template>
<script>
import UserForm from './UserForm.vue';

export default {
  name: 'UserPanel',
  components: { UserForm },
};
</script>
