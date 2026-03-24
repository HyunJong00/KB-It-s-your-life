<script>
import CheckboxItem from './components/CheckboxItem.vue';
import InputName from './components/InputName.vue';
export default {
  name: 'App',
  components: { CheckboxItem, InputName },
  data() {
    return {
      parentName: '',
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink', checked: false },
        { id: 3, name: 'EXO', checked: false },
        { id: 4, name: 'ITZY', checked: false },
      ],
    };
  },
  methods: {
    nameChangedHandler(e) {
      this.parentName = e.name;
    },
  },
};
</script>

<template>
  <!-- <div>
    <h2>관심있는 K-POP 가수?</h2>
    <hr />
    <ul>
      <CheckboxItem
        v-for="idol in idols"
        :key="idol.id"
        :id="idol.id"
        :name="idol.name"
        :checked="idol.checked"
      />
    </ul>
  </div> -->
  <div>
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터: {{ parentName }}</h3>
  </div>
</template>
