<template>
  <div>
    <input
      type="text"
      placeholder="제목을 입력하세요"
      :value="title"
      @input="$emit('update:title', $event.target.value)"
    />
  </div>
  <div>
    <textarea
      name="content"
      id="content"
      :value="content"
      @input="$emit('update:content', $event.target.value)"
    ></textarea>
  </div>
  <hr />
  <div>
    <h3>MyForm</h3>
    title: {{ title }}
  </div>
</template>

<script>
export default {
  name: 'MyForm',
  props: { title: String, content: String },
};
</script>
