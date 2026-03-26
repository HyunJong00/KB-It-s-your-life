<script>
import Inputname from './components/Inputname.vue';
export default {
  name: 'App',
  components: {
    Inputname,
  },
  data() {
    return {
      serchName: '',
    };
  },
};
</script>
<template>
  <div>
    <Inputname v-model:name="serchName" />
    <h3>검색어 : {{ serchName }}</h3>
  </div>
</template>

<style scoped></style>
