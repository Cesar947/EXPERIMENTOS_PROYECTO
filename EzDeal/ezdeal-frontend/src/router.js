import Home from "./view/Home.vue";
import Register from "./view/Register.vue";
import Login from "./view/Login.vue";
import Publication from "./view/PublicationForm.vue";
import MembresiaGold from "./components/MembresiaGold.vue";
import MainHome from "./components/MainHome.vue";
import ServicioDetalle from "./view/ServicioDetalle.vue";
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: "history",
    routes: [
        {
            path: '',
            name: 'Home',
            component: Home,
            children: [
                {
                    path: '/',
                    component: MainHome
                },
                {
                    path: "public",
                    component: Publication
                },
                {
                    path: 'membresia',
                    component: MembresiaGold
                },
                {
                    path: 'servicio/:id',
                    component: ServicioDetalle
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
