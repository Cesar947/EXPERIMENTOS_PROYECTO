<template>
  <div>
    <div v-if="isLogin" class="navbar-container">
      <div class="left-side">
        <div class="logo">
          <img v-on:click="goToHome()" width="180" src="../assets/logo.png" alt="" />
        </div>

        <div class="search-bar">
          <input
            type="text"
            v-model="keyword"
            placeholder="¿Que tipo de servicio estas buscando?"
          />

          <button v-on:click="clickBuscar()">
            Buscar
          </button>
        </div>
      </div>

      <div v-if="isAnunciante" class="nav-link">
        <a href="/public">Publicar</a>
        <a name="opcionMisServiciosNavBar" href="/mis-servicios">Mis Servicios</a>
        <a name="agendaLink" href="/mis-citas">Agenda</a>
        <a id="gold-btn" name="goldButton" href="/membresia">Quiero ser gold</a>
        
      </div>
      <div v-if="isCliente" class="nav-link">
        <a>Servicios</a>
        <a id="anunciante-btn" href="/membresia">Quiero ser anunciante</a>
      </div>
    </div>

    <div v-if="!isLogin" class="navbar-container">
      <div class="left-side">
        <div class="logo">
          <img width="180" src="../assets/logo.png" alt="" />
        </div>

        <div class="search-bar">
          <input
            type="text"
            v-model="keyword"
            placeholder="¿Que tipo de servicio estas buscando?"
          />

          <button v-on:click="clickBuscar()">
            Buscar
          </button>
        </div>
      </div>

      <div class="nav-link">
        <a href="/login">Iniciar Sesión</a>
        <a href="/register">Registrarse</a>
      </div>
    </div>
  </div>
</template>

<script>
import { bus } from "../main";

export default {
  name: "navbar",
  data() {
    return {
      anunciante: true,
      keyword: "",
      isLogin: false,
      isAnunciante:false,
      isCliente:false
    };
  },
  created() {

    this.$data.isLogin = localStorage.getItem("login") ?  true: false;
    if(localStorage.getItem("anunciante")){
      this.$data.isAnunciante =  true
    }
    else if(localStorage.getItem("cliente")){
      this.$data.isCliente =  true;
    }
  },
  methods: {
    clickBuscar() {
      bus.$emit("updateAnuncios", this.keyword);
    },

    goToHome(){
      this.$router.push("/");
    }
  },
};
</script>

<style>
.navbar-container {
  width: 100%;
  padding: 32px 96px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.navbar-container .left-side {
  display: flex;
  align-items: center;
}
.navbar-container .left-side button {
  padding: 16px 32px;
  border: none;
  background: #ff3168;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  font-size: 18px;
}
.navbar-container .left-side .search-bar {
  margin-left: 24px;
}
.navbar-container input {
  width: 320px;
  border-radius: 8px;
  border: none;
  background: #fcfcfc;
  padding: 16px;
  font-size: 16px;
  color: #323232;
  margin: 12px 0;
  border: 1px solid #fcfcfc;
  transition: all 0.2s ease-in-out;
}

#gold-btn {
  background: linear-gradient(
    45deg,
    rgba(255, 86, 25, 1),
    rgba(255, 128, 4, 1)
  );
  color: #ffffff;
  font-weight: 600;
  border-radius: 10000px;
  padding: 16px 48px;
  text-decoration: none;
  transition: all 0.2s ease-in-out;
}
#gold-btn:hover {
  box-shadow: 0 0 20px 3px rgba(255, 128, 4, 0.5);
}

#anunciante-btn{
    background: linear-gradient(
    45deg,
    rgba(255, 86, 25, 1),
    rgb(230, 255, 4)
  );
  color: #ffffff;
  font-weight: 600;
  border-radius: 10000px;
  padding: 16px 48px;
  text-decoration: none;
  transition: all 0.2s ease-in-out;
}
.navbar-container .logo {
  display: flex;
}
.navbar-container .logo h1 {
  margin-left: 12px;
  color: #5f6caf;
}

.navbar-container .nav-link {
  padding-right: 96px;
}

.navbar-container .nav-link a {
  margin: 0 32px;
  color: #323232;
  text-decoration: none;
}
</style>
