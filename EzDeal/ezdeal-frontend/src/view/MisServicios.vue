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
  <div class="cards-servicios">
      <h1>Mis Servicios</h1>
      <div class="lista-servicios">
          <MiServicio
          v-for="(servicio, key) in servicios"
          v-bind:key="key"
          v-bind:servicio="servicio">
          </MiServicio>
      </div>
  </div>
</template>

<script>
import MiServicio from "../components/MiServicio.vue";
import axios from 'axios';
import { environment } from '../environment/environment';
export default {
    name: "MisServicios",
    components: { MiServicio },
    data(){
        return{
            servicios: []
        }
    },
    created(){
        this.listarMisServicios();
    },
        
    methods:{
        listarMisServicios(){
            const id = parseInt(localStorage.getItem("id"))
            axios.get(`${environment.api}/servicios/anunciante/${id}`)
            .then(response => {
            this.servicios = response.data
            })
            .catch(error => {
                console.log(error)
            })

        }   
        

    }
};
</script>
<style>
    .cards-servicios{
        width: 1200px;
        margin: 0 auto;
    }
</style>
