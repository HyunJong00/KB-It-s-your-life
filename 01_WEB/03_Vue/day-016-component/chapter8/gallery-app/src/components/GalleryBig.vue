<template>
  <img :src="image.url" width="70%" alt="selectedImage" />
  <hr />
</template>
<script>
export default {
  name: 'GalleryBig',
  props: ['image'],
};
</script>
