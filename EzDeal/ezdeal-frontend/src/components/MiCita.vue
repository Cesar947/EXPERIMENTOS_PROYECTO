<template>
  <div class="card-contenedor">
    <img src="https://vignette.wikia.nocookie.net/memes-pedia/images/f/fe/Suprised_Patrick.jpg/revision/latest/top-crop/width/360/height/450?cb=20160222150600&path-prefix=es" alt />
    <h3 class="name">Servicio: {{cita.solicitud.servicio.titulo}}</h3>
    <p class="name">Anuciante: {{cita.solicitud.servicio.anunciante.nombres}}</p>
    <p class="rol">Estado: {{cita.estado}}</p>
    <p class="rol">Costo: {{cita.costoFinal}}</p>

    <div class="rating">
      <p class="rating-label">Hora Inicio</p>
      <p class="rating-value">{{cita.horaInicio}}</p>
      <p class="rating-label">Hora Fin</p>
      <p class="rating-value">{{cita.horaFin}}</p>
    </div>
    <div class="enlace">
      <a v-on:click="navigateToDetail()">Resenar</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "MiCita",
  props: ["cita"],
  methods: {
    navigateToDetail(){
       this.$router.push(`/cita/${this.$props.cita.id}`);
    }
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
</style>
