import axios from 'axios'
import Element from 'element-ui'
import router from './router'
import store from './store'
//全局axios拦截


axios.defaults.baseURL = "http://localhost:8080"//前缀

//前置拦截，发起请求做的通知
axios.interceptors.request.use(config => {

    return config
})

axios.interceptors.response.use(response => {
    let res = response.data;

    console.log("------------");
    console.log(res);
    console.log("------------");

    if (res.code == 200) {
        return response;
    } else {
        Element.Notification.error({
            title: '错误',
            message: '这是一条错误的提示消息',
            duration: 3 * 1000
        });

        return Promise.reject(response.data.msg);
    }
    //401是没有权限，后端异常可以查到
},
    error => {
        console.log(error)
        if(error.response.data){
            error.message = error.response.data.msg
        }

        if(error.response.status === 401){
            store.commit("REMOVE_INFO")
            router.push("/login")
        }

        Element.Message.error(error.message, {duration: 3 * 1000})
        return Promise.reject(error)
    }
)

