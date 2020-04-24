import Vue from 'vue';
import App from './App.vue';
<<<<<<< HEAD
import router  from './router';
=======
import  router  from './router';
>>>>>>> 9a16850ad80ebdc267c44ea0df953006d6710b02
import store from './store';
import VeeValidate from 'vee-validate';


Vue.config.productionTip = false;

Vue.use(VeeValidate);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app');
