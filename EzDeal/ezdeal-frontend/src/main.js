import Vue from 'vue';
import App from './App.vue';

import router  from './router';

import store from './store';
import VeeValidate from 'vee-validate';
import vuetify from './plugins/vuetify';


Vue.config.productionTip = false;

export const bus = new Vue();

Vue.use(VeeValidate);

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app');
