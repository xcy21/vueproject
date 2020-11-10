// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import router from './router'

Vue.use(Element)
axios.interceptors.request.use(config => {
  if(config.method == 'post')
  config.headers['Content-Type'] = 'application/json'
  return config
})
Vue.prototype.$axios = axios
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
