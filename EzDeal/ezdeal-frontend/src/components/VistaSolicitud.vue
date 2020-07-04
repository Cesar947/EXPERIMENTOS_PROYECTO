<template>
  <div class="card-contenedor">
    

    <h3 class="name">Solicitud {{ solicitud.estado }}</h3>
    <p class="rol">Servicio: {{ solicitud.servicio.titulo }}</p>

    <div class="rating">
      <p class="rating-label">Fecha pactada</p>
      <p class="rating-value">{{ solicitud.fechaPactada }}</p>
    </div>
    <div class="rating">
      <p class="rating-label">Hora inicio</p>
      <p class="rating-value">{{ solicitud.horaPactada }}</p>
    </div>
    <div class="rating">
      <p v-if="!rechazado" class="rating-label">Hora fin</p>
      <p v-if="solicitud.horaFin && !rechazado" class="rating-value">{{ solicitud.horaFin }}</p>
      <p v-if="!solicitud.horaFin && !rechazado" class="rating-value">Confirmación pendiente</p>
    </div>
    
    <h3 v-if="rechazado" class="name">Motivo de rechazo</h3>
    <p v-if="rechazado" name="motivoRechazo" class="rol">{{ solicitud.motivoRechazo }}</p>

    <div v-if="rechazado" class="enlace">
      <a v-on:click="navigateToDetail()">Volver a solicitar</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "VistaSolicitud",
  props: ["solicitud"],
  data: function() {
    return {
      rechazado: false
    };
  },

  created() {
      if(this.$props.solicitud.estado === "Rechazada"){
          this.$data.rechazado = true;
      }
    
  },

  navigateToDetail(){
      this.$router.push("/servicio/" + this.$props.solicitud.servicio.id)
  }

  
 
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
  text-align: center;
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
