<template>
  <div class="card-solicitud">
    <div class="header">
      <img
      width="24"
        src="https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-creador-de-avatar-masculino.jpg"
        alt=""
      />
      <h2>
        {{ solicitud.cliente.nombres }} {{ solicitud.cliente.apellidoPaterno }}
      </h2>
    </div>
    <div class="information">
        <p>{{solicitud.horaPactada.slice(0,5 )}}</p>
        <p>{{solicitud.fechaPactada}}</p>
    </div>
    <div class="decision-buttons">
        <button v-bind:name="'botonAceptar' + solicitud.id" v-on:click="openModalAceptar()" class="aceptar-btn">Aceptar</button>
        <button v-bind:name="'botonRechazar' + solicitud.id" v-on:click="cerrar()" class="rechazar-btn">Rechazar</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "MiSolicitud",
  props: ["solicitud"],
  methods: {
    cerrar(){
      this.$emit('Event',this.$props.solicitud.id)
    },
    openModalAceptar(){
      this.$emit('OpenModalAceptar', this.$props.solicitud.id)
    }
  }
};
</script>

<style>
.card-solicitud{
    margin: 32px auto ;

}

.card-solicitud .header{
    display: flex;
    align-items: center;
    justify-content: flex-start;
}
.card-solicitud h2{
    font-size: 20px;
    font-weight: 600;
    margin-left: 16px;
}
.card-solicitud .information{
    display: flex;
    width: 100%;
    justify-content: space-between;
    padding-left: 52px;
}

.card-solicitud img{
    width: 36px !important;
    height: 36px !important;
}

.card-solicitud .decision-buttons{
    display: flex;
    justify-content: flex-start;
    margin-left: 52px;
}
.card-solicitud .decision-buttons button{
    border-radius: 6px;
    padding: 8px 16px;
    cursor: pointer;
    text-align: center;
    font-weight: 600;
    color: #ffffff;
    margin: 0 16px 0 0;
}

.card-solicitud .decision-buttons .aceptar-btn{
    background: #FFAE31;
}
.card-solicitud .decision-buttons .rechazar-btn{
    background: #FF656A;
}

</style>
