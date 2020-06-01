<template>
  <div class="card-contenedor">
    <div class="solicitudes-container">
      <div class="message-icon">
        <img src="../assets/ic_solicitud.svg" alt="" />
        <p>{{ solicitudes.length }}</p>
      </div>
      <div class="card-list-solicitudes">
        <h2>Mis solicitudes</h2>
        <p>Tiene {{ solicitudes.length }} solicitudes</p>
        <MiSolicitud
          @Event="openModal"
          @OpenModalAceptar="openModalAceptar"
          :solicitud="solicitud"
          v-for="(solicitud, i) in solicitudes"
          v-bind:key="i"
        ></MiSolicitud>
      </div>
    </div>

    <img
      src="https://vignette.wikia.nocookie.net/memes-pedia/images/f/fe/Suprised_Patrick.jpg/revision/latest/top-crop/width/360/height/450?cb=20160222150600&path-prefix=es"
      alt
    />
    <h3 class="name">{{ servicio.titulo }}</h3>
    <p class="rol">{{ servicio.descripcion }}</p>

    <div class="rating">
      <p class="rating-label">Costo del servicio</p>
      <p class="rating-value">{{ servicio.costoServicio }}</p>
    </div>
    <div class="enlace">
      <a v-on:click="navigateToDetail()">Ver detalle</a>
    </div>
  </div>
</template>

<script>
import SolicitudService from "../services/solicitud.service";
import MiSolicitud from "../components/MisSolicitudes";
export default {
  name: "MiServicio",
  components: { MiSolicitud },
  props: ["servicio"],
  created() {
    this.listarSolicitudes();
    console.log(" he sido creado");
  },

  data: function() {
    return {
      solicitudes: [],
      idSolicitudSelected: -1,
    };
  },
  methods: {
    openModal(e) {
      console.log(e);
      this.$emit("Event", e);
    },

    openModalAceptar(e) {
      this.$emit("OpenModalAceptar",e);
    },

    navigateToDetail() {
      this.$router.push(`/servicio/${this.$props.servicio.id}`);
    },
    async listarSolicitudes() {
      await SolicitudService.getSolicitudesPorServicio(
        this.$props.servicio.id
      ).then((e) => {
        console.log(e.data);
        this.$data.solicitudes = e.data;
      });
    },
  },
};
</script>

<style>
.card-contenedor {
  width: 60%;
  padding: 32px;
  background: #ffffff;
  box-shadow: 0 2px 12px 1px rgba(0, 0, 0, 0.05);
  display: flex;
  margin: 24px;
  border-radius: 10px;
  flex-direction: column;
  align-items: center;
  position: relative;
}
.card-contenedor img {
  width: 24;
  height: 24px;
  border-radius: 50%;
}
.card-contenedor .card-list-solicitudes {
  position: absolute;
  display: none;
  width: 400px;
  padding: 32px;
  top: 20px;
  left: 20px;
  height: 500px;
  overflow-y: auto;
  z-index: 12;
  background: #ffffff;
  border-radius: 6px;
  box-shadow: 0 0 71px 0 rgba(0, 0, 0, 0.1);
}
.card-contenedor .solicitudes-container {
  position: absolute;
  top: 12px;
  right: 24px;
}

.card-contenedor .solicitudes-container:hover .card-list-solicitudes {
  display: initial;
}
.card-contenedor .solicitudes-container .message-icon img {
  width: 24px;
  border-radius: 0px;
}
.card-contenedor .solicitudes-container .message-icon p {
  position: absolute;
  top: 10px;
  right: -6px;
  text-align: center;
  background: #ff3168;
  color: #ffffff;
  padding: 6px;
  font-size: 12px;
  line-height: 10px;
  width: 20px;
  height: 20px;
  border-radius: 50px;
}
.card-contenedor .name {
  width: 80%;
  font-size: 20px;
  margin: 24px 0 4px 0;
  text-align: center;
}
.card-contenedor .rol {
  font-size: 16px;
  color: #434343;
  font-weight: 400;
}

.card-contenedor .rating {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.card-contenedor .rating-label,
.card-contenedor .rating-value {
  color: #ff3168;
}
.card-contenedor .rating-value {
  font-size: 32px;
  font-weight: 600;
  margin: 0px 0 24px 0;
}
a {
  color: rgba(230, 129, 14, 0.05);
}
</style>
