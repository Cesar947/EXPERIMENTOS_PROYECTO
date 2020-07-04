<template>

  <div class="servicios-container">
    <div class="cards-servicios">
      <h1>Mis Solicitudes</h1>
      <div class="lista-servicios">
        <VistaSolicitud
          v-for="(solicitud, key) in solicitudes"
          v-bind:key="key"
          v-bind:solicitud="solicitud"
        >
        </VistaSolicitud>
      </div>
    </div>
  </div>
</template>

<script>

// import MiSolicitud from "../components/MisSolicitudes.vue";
import VistaSolicitud from "../components/VistaSolicitud.vue";
import { environment } from "../environment/environment.js";
import axios from 'axios';
export default {
  name: "SolicitudesEnviadas",
  components: { VistaSolicitud },
  data() {
    return {
      solicitudes: [],
      isShowModal: false,
      isShowModalAceptar: false,
      solicitudSelected: -1,
    };
  },
  created() {
    this.listarSolicitudesPorCliente();
  },

  methods: {

    async listarSolicitudesPorCliente() {
      const id = parseInt(localStorage.getItem("id"));  
      const token = localStorage.getItem("token");
       const config = { headers: { Authorization: `Bearer ${token}` } };
      await axios.get(`${environment.api}/solicitudes/cliente/${id}`,
        config).then((e) => {
        console.log(e.data);
        this.$data.solicitudes = e.data;
      });
    },
    
  },
};
</script>
<style>
.servicios-container {
  display: flex;
  width: 90%;
  margin: 0 auto;
}
.servicios-container .cards-servicios {
  width: 70%;
}

.servicios-container .card-solicitudes {
  width: 20%;
}

.servicios-container .lista-servicios {
  display: flex;
  flex-wrap: wrap;
}

.servicios-container .lista-solicitudes {
  height: 600px;
  overflow-y: auto;
  padding: 24px 0;
}
</style>
