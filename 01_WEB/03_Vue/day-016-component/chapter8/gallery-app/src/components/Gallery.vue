<template>
  <div>
    <GalleryBig :image="selectedImage" />
    <GalleryList
      :images="images"
      @change-image="changeImage"
      :selectedImage="selectedImage"
    />
  </div>
</template>

<script>
import GalleryBig from './GalleryBig.vue';
import GalleryList from './GalleryList.vue';
export default {
  name: 'Gallery',
  components: { GalleryBig, GalleryList },
  data() {
    return {
      images: [
        { id: 'img01', url: '/images/cat1.jpg' },
        { id: 'img02', url: '/images/cat2.jpg' },
        { id: 'img03', url: '/images/cat3.jpg' },
        { id: 'img04', url: '/images/cat4.jpg' },
        { id: 'img05', url: '/images/cat5.jpg' },
      ],
      selectedImage: { id: 'img01', url: '/images/cat1.jpg' },
    };
  },
  methods: {
    changeImage(image) {
      console.log('gallery', image);
      this.selectedImage = image;
    },
  },
};
</script>
