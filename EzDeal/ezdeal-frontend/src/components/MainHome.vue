<template>
  <div class="main-home-container">
    <h3>¿Buscas algun servicio?</h3>
    <p>Nosotros te podemos ayudar</p>
    <div class="list-publications-container">
        
      <PublicationCard 
      
      v-for="(value, key) in anuncios" 
      v-bind:key="key" 
      v-bind:anuncio="value" 
      ></PublicationCard>
    </div>
  </div>
</template>

<script>
import PublicationCard from "./Home/PublicationCard";
import axios from 'axios';
import { environment } from '../environment/environment';
import { bus } from '../main';

export default {
  name: "MainHome",
  components: { PublicationCard },
  data(){
    return {
      publications: [
        { id: 1, name: "Name 1 mas largo del mundo", rol: "Electricista", rating: 4.5 },
        { id: 2, name: "Name 2", rol: "Profesor", rating: 3.5 },
        { id: 3, name: "Name 3", rol: "Mecánico", rating: 4.8 },
        { id: 4, name: "Name 4", rol: "Albañil", rating: 4.2 },
        { id: 5, name: "Name 5", rol: "Pintor", rating: 4.4 },
        { id: 6, name: "Name 6", rol: "Enfemero", rating: 4.3 },
        { id: 7, name: "Name 7", rol: "Niñero", rating: 4.9 },
        { id: 8, name: "Name 8", rol: "Electricista", rating: 4.1 },
        { id: 9, name: "Name 9", rol: "Wachiman", rating: 4.2 },
        { id: 10, name: "Name 10", rol: "Electricista", rating: 4.0 }
      ],
      anuncios: []
    };

  },
  created(){

    bus.$on('updateAnuncios', (keyword) => {

      this.buscarServicios(keyword);

    })

    this.listarServicios();
  },

  methods: {
    listarServicios() {

        axios.get(`${environment.api}/servicios/lista`)
        .then(response => {
          this.anuncios = response.data
          console.log(this.anuncios)
        })
        .catch( error => {
          console.log(error)
        });

    },

    buscarServicios(keyword){
      
      axios.get(`${environment.api}/auth/servicios/titulo?keyword=${keyword}`)
        .then(response => {
          
          this.anuncios = response.data
        
        })
        .catch(error => {
          console.log(error)
          alert("error");
        });

    }
  }

  
};
</script>

<style>
.main-home-container > h3,.main-home-container > p{

        text-align: center;
}
.list-publications-container{
    width: 90%;
    margin: 48px auto 0;
    display: flex;
    flex-wrap: wrap;  
    justify-content: flex-start;
    
}
</style>
