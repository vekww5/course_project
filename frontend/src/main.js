import Vue from 'vue'
import App from './App.vue'
import router from './routes';
import VueKeyCloak from '@dsb-norge/vue-keycloak-js'

//выбрать лучшее место для импорта vue-select или оставить тут
import vSelect from 'vue-select'
import 'vue-select/dist/vue-select.css';
Vue.component('v-select', vSelect)

import { BootstrapVue } from 'bootstrap-vue'
Vue.use(BootstrapVue)
//import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';

Vue.config.productionTip = false

Vue.use(VueKeyCloak,{
	init: {
     flow: 'standard', 
     checkLoginIframe: false, 
     onLoad: 'login-required', 
   },

	config: {
      realm : 'sportrealm',
      url : 'http://192.168.122.1:8085/auth',
      clientId : 'app-auth',
   },
   onReady (keycloak) {
    console.log(keycloak)
   }
   
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
