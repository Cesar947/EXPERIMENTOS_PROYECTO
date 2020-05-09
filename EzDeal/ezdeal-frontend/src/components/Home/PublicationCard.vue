<template>
  <div class="card-container">
    <img src="https://www.pnliafi.com.ar/wp-content/uploads/2016/01/avatar-user.png" alt />
    <h3 class="name">{{anuncio.titulo}}</h3>
    <p class="rol">{{anuncio.descripcion}}</p>

    <div class="rating">
      <p class="rating-label">Costo del servicio</p>
      <p class="rating-value">{{anuncio.costoServicio}}</p>
    </div>
    <div class="enlace">
      <a v-on:click="navigateToDetail()">Ver más</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "PublicationCard",
  props: ["anuncio"],
  methods: {
    navigateToDetail(){
       this.$router.push(`/servicio/${this.$props.anuncio.id}`);

    }
  }
};
</script>

<style>
.card-container {
  width: 240px;
  padding: 32px;
  background: #ffffff;
  box-shadow: 0 2px 12px 1px rgba(0, 0, 0, 0.05);
  display: flex;
  margin: 24px;
  border-radius: 10px;
  flex-direction: column;
  align-items: center;
}
.card-container img {
  width: 64px;
  height: 64px;
  border-radius: 50%;
}

.card-container .name {
  width: 80%;
  font-size: 20px;
  margin: 24px 0 4px 0;
  text-align: center;
}
.card-container .rol {
  font-size: 16px;
  color: #434343;
  font-weight: 400;
}

.card-container .rating {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 20px;
}

.card-container .rating-label,
.card-container .rating-value {
  color: #ff3168;
}
.card-container .rating-value {
  font-size: 32px;
  font-weight: 600;
  margin: 0px 0 24px 0;
}
a {
  color:rgba(230, 129, 14, 0.05);
}
</style>
