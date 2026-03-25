<template>
  <GalleryListItem
    v-for="image in images"
    :key="image.id"
    :image="image"
    :selectedImage="selectedImage"
    @select="onSelectImage"
  />
</template>
<script>
import GalleryListItem from './GalleryListItem.vue';
export default {
  name: 'GalleryList',
  components: { GalleryListItem },
  props: ['images', 'selectedImage'],
  emits: ['change-image'],
  methods: {
    onSelectImage(image) {
      console.log('[galleryList]selectImage', image);
      this.$emit('change-image', image);
    },
  },
};
</script>
