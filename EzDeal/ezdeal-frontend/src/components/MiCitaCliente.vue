<template>
  <div class="card-contenedor">
    <h3 class="name">Servicio: {{cita.solicitud.servicio.titulo}}</h3>
    <p class="name">Anuciante: {{cita.solicitud.servicio.anunciante.nombres}}</p>
    <p class="rating-label">Estado</p>
    <p class="rating-value">{{cita.estado}}</p>
    <div class="rating">
      <p class="rating-label">Hora Inicio</p>
      <p v-if="cita.horaInicio" class="rating-value">{{cita.horaInicio}}</p>
       <p v-if="!cita.horaInicio" class="rating-value">
          Pendiente
        </p>

      <p class="rating-label">Hora Fin</p>
      <p v-if="cita.horaFin" class="rating-value">{{cita.horaFin}}</p>
      <p v-if="!cita.horaFin" class="rating-value">
          Pendiente
        </p>
    </div>
    <div class="enlace">
      <a v-on:click="navigateToDetail()">Resenar</a>
    </div>

  </div>
</template>

<script>
import CitaService from "../services/cita.service"
export default {
  name: "MiCitaCliente",
  props: ["cita"],
  methods: {
    navigateToDetail(){
       this.$router.push(`/cita/${this.$props.cita.id}`);
    },
    async actualizarCita(estado){
      try {
        await CitaService.actualizarEstadoCita(estado, this.id);
        alert(`La cita ha sido ${estado}`)
        this.$emit('Listar')
      } catch (error) {
        console.log(error);
      }
    }
  },
  data(){
    return {
      id: -1,
    }
  },
  mounted(){
    this.id =  this.$props.cita.id
  }
};
</script>

<style>
.card-contenedor {
  width: 400px;
  padding: 16px;
  background: #ffffff;
  box-shadow: 0 2px 12px 1px rgba(0, 0, 0, 0.05);
  display: flex;
  
  border-radius: 10px;
  flex-direction: column;
  align-items: center;
}
.card-contenedor img {
  width: 64px;
  height: 64px;
  border-radius: 50%;
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
  color:rgba(230, 129, 14, 0.05);
}

.input-cost{
  width: 150px;
  border-radius: 8px;
  border: none;
  background: #e0dcdce7;
  padding: 16px;
  font-size: 16px;
  color: #323232;
  margin: 0 0;
  border: 1px solid #fcfcfc;
  transition: all 0.2s ease-in-out;
}

.cost-button{
  padding: 4px 10px;
  border: none;
  background: #ff3168;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin-top: 5px;
  font-size: 14px;
}

.enlace{

  flex-wrap: wrap;
  justify-items: space-evenly;

}

</style>
