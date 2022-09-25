import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
//数据状态管理,数据互通
export default new Vuex.Store({
  state: {
    token: '',
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  getters: {
    //getter
    getUser: state => {
      return state.userInfo;
    }
  },
  mutations: {
    //setter
    SET_TOKEN: (state,token) => {
      state.token = token
      localStorage.setItem("token",token)
    },
    SET_USERINFO: (state,userInfo) => {
      state.userInfo = userInfo
      sessionStorage.setItem("userInfo",JSON.stringify(userInfo))
    },

    REMOVE_INFO: (state) => {
      state.token = ''
      state.userInfo = {}
      localStorage.removeItem("token")
      sessionStorage.removeItem("userInfo")
      // localStorage.setItem("token",'')
      // sessionStorage.setItem("userInfo",JSON.stringify(''))
    }
  },
  actions: {
  },
  modules: {
  }
})
