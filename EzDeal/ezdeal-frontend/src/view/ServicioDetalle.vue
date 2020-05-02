<template>
  <div class="reserva-container">
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

        <div class="rating">
          <p>Rating:</p>
          <p>{{ servicioDetalle.valorServicio }}</p>
        </div>
      </div>
    </div>

    <div class="contact-info">
      <div>
        <p class="label-text">
          Celular
        </p>
        <p class="contact-number">{{ servicioDetalle.anunciante.telefonoCelular }}</p>
      </div>

      <div>
        <p class="label-text">
          Teléfono
        </p>
        <p class="contact-number">
          {{ servicioDetalle.anunciante.telefonoFijo }}
        </p>
      </div>
    </div>

    <div class="informacion-service">
      <p class="title-info">Descripción</p>
      <p>{{ servicioDetalle.descripcion }}</p>
    </div>

    <div>
      <button class="btn-solicitar">Solicitar</button>
    </div>
  </div>
</template>

<script>
import ServicioDetalle from "../models/ServicioDetalle";
export default {
  name: "ServicioDetalle",

  data: function() {
    return {
      qwe: this.$route.params.id,
      servicioDetalle: new ServicioDetalle(5),
    };
  },
};
</script>

<style>
.reserva-container {
  width: 1000px;
  margin: 0 auto;
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

.header-avatar .avatar .desc {
  margin-left: 24px;
}

.header-avatar .avatar .desc h2 {
  color: #ff3168;
  text-align: center;
  font-size: 32px;
}

.header-avatar .avatar .desc p{
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

.contact-info{
  margin-top: 32px;
  display: flex;
}
.contact-info > div{
  margin-right: 32px;
}

.contact-info .label-text{
  font-size: 18px;
  margin: 0;
  color: #4e4e4e;
}
.contact-info .contact-number{
  font-size: 22px;
  font-weight: 600;
  color: #000000;
}


.informacion-service{
  width: 800px;
  padding: 32px;
  background: #fafafb;
  border-radius: 5px;
  margin-top: 24px;
}

.informacion-service .title-info{
  color: #ff3168;
  width: 150px;
  padding-bottom: 24px;
  border-bottom: 4px solid #ff3168;
  font-size: 24px;
  font-weight: 700;
}

.btn-solicitar{
  margin-top: 24px;
  background: #ff3168;
  border-radius: 4px;
  padding: 12px 48px;
  color: #ffffff;
  font-weight: 600;
  cursor: pointer;
}
</style>
