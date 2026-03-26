<template>
  <p>Theme: {{ theme }}</p>
</template>
<script>
export default {
  name: 'ThemeDisplay',
  inject: ['theme'],
};
</script>
