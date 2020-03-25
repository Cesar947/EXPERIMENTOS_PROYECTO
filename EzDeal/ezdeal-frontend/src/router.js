import Home from "./view/Home.vue";
import Register from "./view/Register.vue";
import Login from "./view/Login.vue";
import Search from "./view/Search.vue";
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: "history",
    routes: [
        {
            path: '/home',
            name: 'Home',
            component: Home,
            children: [
                {
                    path: 'search',
                    component: Search
                }
            ]
        },

        
        {
            path: '/register',
            name: 'Register',
            component: Register
        },
        {
            path: '/login',
            name: 'Login',
            component: Login
        },
    ]
})