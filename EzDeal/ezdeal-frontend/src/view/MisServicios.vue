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

  <div class="servicios-container">
    <div class="cards-servicios">
      <h1>Mis Servicios</h1>
      <div class="lista-servicios">
        <MiServicio
          v-for="(servicio, key) in servicios"
          v-bind:key="key"
          v-bind:servicio="servicio"
          @Event="openModalRechazar"
          @OpenModalAceptar="openModalAceptar"
        >
        </MiServicio>
      </div>
    </div>
    <modal-rechazar-solicitud
      @CloseModal="closeModal"
      v-if="isShowModal"
      :id="solicitudSelected"
    ></modal-rechazar-solicitud>
    <modal-aceptar-solicitud
      @CloseModalAceptar="closeModalAceptar"
      v-if="isShowModalAceptar"
      :id="solicitudSelected"
    ></modal-aceptar-solicitud>
  </div>
</template>

<script>
import MiServicio from "../components/MiServicio.vue";
// import MiSolicitud from "../components/MisSolicitudes.vue";
import ModalRechazarSolicitud from "../components/ModalRechazarSolicitud.vue";
import ModalAceptarSolicitud from "../components/ModalAceptarSolicitud.vue";
import axios from "axios";
import SolicitudService from "../services/solicitud.service";
import { environment } from "../environment/environment";
export default {
  name: "MisServicios",
  components: { MiServicio, ModalRechazarSolicitud, ModalAceptarSolicitud },
  data() {
    return {
      servicios: [],
      solicitudes: [],
      isShowModal: false,
      isShowModalAceptar: false,
      solicitudSelected: -1,
    };
  },
  created() {
    this.listarMisServicios();
  },

  methods: {
    listarMisServicios() {
      const id = parseInt(localStorage.getItem("id"));
      const token = localStorage.getItem("token");
      console.log(id);
      console.log(token);
      const config = { headers: { Authorization: `Bearer ${token}` } };
      axios
        .get(`${environment.api}/servicios/anunciante/${id}`, config)
        .then((response) => {
          this.servicios = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },

    async listarMisSolicitudes() {
      await SolicitudService.getSolicitudesPorAnunciante(
        parseInt(localStorage.getItem("id"))
      ).then((e) => {
        console.log(e.data);
        this.$data.solicitudes = e.data;
      });
    },
    openModalAceptar(e) {
      this.$data.isShowModalAceptar = true;
      this.$data.solicitudSelected = e;
    },
    closeModalAceptar() {
      this.$data.isShowModalAceptar = false;
    },

    openModalRechazar(e) {
      console.log("padre", e);
      this.$data.solicitudSelected = e;
      this.$data.isShowModal = true;
    },
    closeModal() {
      this.$data.isShowModal = false;
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
}

.servicios-container .lista-solicitudes {
  height: 600px;
  overflow-y: auto;
  padding: 24px 0;
}
</style>
