<template>
  <!--<div class="main-home-container">
    <h3>¿Buscas algun servicio?</h3>
    <p>Nosotros te podemos ayudar</p>
    <div class="list-publications-container">
        
      <PublicationCard 
      
      v-for="(value, key) in anuncios" 
      v-bind:key="key" 
      v-bind:anuncio="value" 
      ></PublicationCard>
    </div>
  </div>-->
  <div class="cards-citas">
    <div v-if="isAnunciante">
        <h1>Mis citas de anunciante</h1>
        <div class="lista-citas">
        <MiCita v-for="(cita, key) in citasAnunciantes" v-bind:key="key" v-bind:cita="cita"></MiCita>
        </div>
    </div>
    <div v-if="isCliente">
        <h1>Mis citas de cliente</h1>
        <div class="lista-citas">
        <MiCita v-for="(cita, key) in citasClientes" v-bind:key="key" v-bind:cita="cita" 
        @Listar="listarMisCitas"></MiCita>
        </div>
    </div>
  </div>
</template>

<script>
import MiCita from "../components/MiCita.vue";
import axios from 'axios';
import { environment } from '../environment/environment';
export default {
    name: "MisCitas",

    components: { MiCita },
    data(){
        return{
            citasAnunciantes: [],
            citasClientes: [],
            isCliente: false,
            isAnunciante: false
        }
    },
    created(){
        if (localStorage.getItem("anunciante") != null){
            this.isAnunciante = localStorage.getItem("anunciante")
        }
        if (localStorage.getItem("cliente") != null){
            this.isCliente = localStorage.getItem("cliente")
        }

        this.listarMisCitas();
    },
        
    methods:{
        listarMisCitas(){
            console.log("Lo logró señor")
            const id = parseInt(localStorage.getItem("id"))
            const token = localStorage.getItem("token")
            const roles = localStorage.getItem("roles")
            console.log(id)
            console.log(token)
            console.log(roles)
            const config = { headers : { Authorization : `Bearer ${token}` }}
            
                if (this.isCliente){
                   
                   axios.get(`${environment.api}/citas/cliente/${id}`,config)
                    .then(response => {
                    this.citasClientes = response.data
                    })
                    .catch(error => {
                        console.log(error)
                    })
                }
                if (this.isAnunciante){
                    axios.get(`${environment.api}/citas/anunciante/${id}`,config)
                    .then(response => {
                    this.citasAnunciantes = response.data
                    })
                    .catch(error => {
                        console.log(error)
                    })
                }


            }

            

        }   
        
};
</script>
<style>
.cards-citas {
  width: 1200px;
  margin: 0 auto;
}
.cards-citas .lista-citas {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
</style>
