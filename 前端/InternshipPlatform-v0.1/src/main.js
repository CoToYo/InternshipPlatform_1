import Vue from 'vue'
import ElementUi from 'element-ui'
import '../node_modules/element-ui/lib/theme-chalk/index.css'
import App from './App.vue'
import router from './router/index.js'
import axios from 'axios'


Vue.use(ElementUi);
Vue.prototype.$http=axios;
Vue.prototype.$base_URL=''
axios.default.baseURL = 'http://localhost:8080/#/'


new Vue({
	el:'#app',
	router,
	axios,
  render: h => h(App),
})
