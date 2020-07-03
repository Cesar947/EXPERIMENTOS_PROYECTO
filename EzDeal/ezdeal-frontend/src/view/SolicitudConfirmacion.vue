<template>
  <div class="solicitud-confirmacion">
    <img src="../assets/solicitar_confirmed.svg" alt="" />
    <h2>Enhorabuena</h2>
    <p>Su solicitud al anunciante ha sido enviado correctamente</p>
    <button name="irAInicio" v-on:click="goToHome"> Ir al inicio </button>
  </div>
</template>

<script>
export default {
  name: "SolicitudConfirmacion",
  methods: {
    goToHome: function() {
        console.log("wqe");
      this.$router.push("/");
    },
  },
};
</script>

<style>
    .solicitud-confirmacion{
        overflow: hidden;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: calc(100vh - 190px);
    }

    .solicitud-confirmacion img{
        width: 200px;
    }
    .solicitud-confirmacion h2 {
        color: #FF6065;
        margin: 8px 0;
    }
    .solicitud-confirmacion p{
        color: #343434;
        font-size: 18px;
        width: 330px;
        text-align: center;
        font-weight: 300;
    }

    .solicitud-confirmacion button{
        padding: 16px 48px;
        border-radius: 8px;
        background: #FF3168;
        color: #ffffff;
        text-align: center;
        font-size: 18px;
        font-weight: 600;
        margin-top: 16px;
    }

</style>
