import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Element from 'element-ui'
import axios from 'axios'
import mavonEditor from 'mavon-editor'

import 'mavon-editor/dist/css/index.css'
import "element-ui/lib/theme-chalk/index.css"

import "./axios.js"
import "./permission.js"

// 关于vue动态路由刷新匹配错误问题以及解决办法：
// https://blog.csdn.net/masierty/article/details/124954392
Vue.use(Element)

// use
Vue.use(mavonEditor)

Vue.prototype.$axios = axios //

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')


