// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import '@/style.css'
import '@/switch.css'
import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import router from './router'
import '@/filters'

Vue.config.productionTip = false
Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    startTime: null,
    endTime: null,
    idCounter: 0
  },
  mutations: {
    setStartTime (state, date) {
      this.state.startTime = date
    },
    setEndTime (state, date) {
      this.state.endTime = date
    },
    incrementCounter (state, date) {
      this.state.idCounter++
    }
  },
  getters: {
    idCounter: state => store => {
      store.commit('incrementCounter')
      return state.idCounter
    }
  }
})
export default store

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})
