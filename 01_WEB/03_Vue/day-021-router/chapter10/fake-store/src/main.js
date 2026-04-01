import 'bootstrap/dist/css/bootstrap.min.css';
import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

import { fas } from '@fortawesome/free-solid-svg-icons';

import { createApp } from 'vue';
import App from './App.vue';
import router from './router';

const app = createApp(App);

library.add(fas);
app.component('font-awesome-icon', FontAwesomeIcon);

app.use(router);
app.mount('#app');
