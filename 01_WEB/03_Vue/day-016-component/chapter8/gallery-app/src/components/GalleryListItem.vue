<template>
  <img
    :src="image.url"
    :alt="image.id"
    width="18%"
    height="50px"
    @click="$emit('select', image)"
    :style="{
      border: image == selectedImage ? '1px red solid' : '1px gray solid',
    }"
  />
</template>
<script>
export default {
  name: 'GalleryListItem',
  props: ['image', 'selectedImage'],
  mouted() {
    console.log(this.image, this.selectedImage);
  },
};
</script>
