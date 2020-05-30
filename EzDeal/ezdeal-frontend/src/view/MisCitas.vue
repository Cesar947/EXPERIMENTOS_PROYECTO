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
      <h1>Mis Citas</h1>
      <div class="lista-citas">
          <MiCita
          v-for="(cita, key) in citas"
          v-bind:key="key"
          v-bind:cita="cita">
          </MiCita>
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
            citas: []
        }
    },
    created(){
        this.listarMisCitas();
    },
        
    methods:{
        listarMisCitas(){
            const id = parseInt(localStorage.getItem("id"))
            const token = localStorage.getItem("token")
            console.log(id)
            console.log(token)
            const config = { headers : { Authorization : `Bearer ${token}` }
            }
            axios.get(`${environment.api}/citas/usuario/${id}`, config
            )
            .then(response => {
            this.citas = response.data
            })
            .catch(error => {
                console.log(error)
            })

        }   
        

    }
};
</script>
<style>
    .cards-citas{
        width: 1200px;
        margin: 0 auto;
    }
</style>
