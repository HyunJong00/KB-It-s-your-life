import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueDevTools from 'vite-plugin-vue-devtools';

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vueDevTools()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    proxy: {
      // 개발때만 적용 ( json 서버의 응답을 proxy가 받기 때문에 crossOrigin 문제가 없음)
      '/api': {
        target: 'http://localhost:3000',
        changeOrigin: true, // crossorigin 문제를 해결
        rewrite: (path) => path.replace(/^\/api/, ''),
      },
    },
  },
});
