<template>
  <div class="reserva-container">
    <div class="divider">
      <div class="header-avatar">
        <div class="avatar">
          <img
            src="https://thumbs.dreamstime.com/b/icono-masculino-del-avatar-en-estilo-plano-icono-masculino-del-usuario-avatar-del-hombre-de-la-historieta-91602735.jpg"
            alt=""
          />
          <div class="desc">
            <h2>{{ servicioDetalle.anunciante.nombres }}</h2>
            <p>{{ servicioDetalle.titulo }}</p>
          </div>
        </div>

        <div class="description">
          <h2>{{ servicioDetalle.tipoServicio.nombre }}</h2>

          <div class="sub-description-time">
            <div class="rating">
              <p>Rating:</p>
              <p>{{ servicioDetalle.valoracion }}</p>
            </div>
          </div>
        </div>
      </div>

      <div class="contact-info">
        <div>
          <p class="label-text">
            Celular
          </p>
          <p class="contact-number">
            {{ servicioDetalle.anunciante.infoAnunciante.telefonoFijo }}
          </p>
        </div>

        <div>
          <p class="label-text">
            Teléfono
          </p>
          <p class="contact-number">
            {{ servicioDetalle.anunciante.infoAnunciante.celular }}
          </p>
        </div>
      </div>
      <div>
        <h4>Costo del servicio</h4>
        <h2 class="price">S/. {{ servicioDetalle.costoServicio }}</h2>
      </div>
      <div class="informacion-service">
        <p class="title-info">Descripción</p>
        <p>{{ servicioDetalle.tipoServicio.descripcion }}</p>
      </div>

      <div>
        <button class="btn-solicitar">Solicitar</button>
      </div>
    </div>
    <div class="horarios">
      <h1>Horario</h1>
      <div
      class="horario-container"
        v-for="(horario, index) in servicioDetalle.horarios"
        v-bind:key="index"
      >
        <div class="horario-description">
          <p>{{ horario.dia }}:</p>
          <p>{{ horario.horaApertura }} - {{ horario.horaCierre }}</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ServicioDetalle from "../models/ServicioDetalle";
import ServiceService from "../services/Service.service";
export default {
  name: "ServicioDetalle",

  mounted() {
    this.getServiceDetail();
  },
  
  data: function() {
    return {
      qwe: this.$route.params.id,
      servicioDetalle: new ServicioDetalle(),
    };
  },
  methods: {
    async getServiceDetail() {
      ServiceService.getServiceDetail(this.$route.params.id).then((res) => {
        console.log(res);

        this.$data.servicioDetalle = res.data;
      });
    },
  },
};
</script>

<style>

.price {
  color: #ff3168;
}
.reserva-container {
  width: 1200px;
  margin: 0 auto;
  display: flex;
}
.header-avatar {
  display: flex;
}
.header-avatar .avatar {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.header-avatar .avatar img {
  width: 128px;
}

.header-avatar .avatar .desc h2 {
  color: #ff3168;
  text-align: center;
  font-size: 32px;
}

.header-avatar .avatar .desc p {
  text-align: center;
}
.rating {
  display: flex;
}
.rating p:nth-child(1) {
  margin-right: 12px;
}

.header-avatar .description {
  margin-left: 64px;
}

.contact-info {
  margin-top: 32px;
  display: flex;
}
.contact-info > div {
  margin-right: 32px;
}

.contact-info .label-text {
  font-size: 18px;
  margin: 0;
  color: #4e4e4e;
}
.contact-info .contact-number {
  font-size: 22px;
  font-weight: 600;
  color: #000000;
}

.informacion-service {
  width: 800px;
  padding: 32px;
  background: #fafafb;
  border-radius: 5px;
  margin-top: 24px;
}

.informacion-service .title-info {
  color: #ff3168;
  width: 150px;
  padding-bottom: 24px;
  border-bottom: 4px solid #ff3168;
  font-size: 24px;
  font-weight: 700;
}
 .sub-description-time {
  display: flex;
}
 .horarios {
  margin-left: 24px;
}

.horarios .horario-description {
  display: flex;
}
.horarios .horario-description p:nth-child(2) {
  margin-left: 12px;
}
.horarios .horario-description p:nth-child(1) {
  font-weight: 600;
}

.btn-solicitar {
  margin-top: 24px;
  background: #ff3168;
  border-radius: 4px;
  padding: 12px 48px;
  color: #ffffff;
  font-weight: 600;
  cursor: pointer;
}

.horario-container{
  display: flex;
  align-items: center;
  margin: 12px 0;
    background: #fbfbfb;
  border-radius: 5px;
    padding: 16px 24px;
}
.horario-description p{
margin: 0 12px !important;
color: #232323;
font-size: 18px;

}
</style>
