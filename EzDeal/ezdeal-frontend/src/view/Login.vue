<template>
  <div class="login-container">
    <div class="header">
      <img src="../assets/logo.png" alt="" />
      <p>Encuentra todo tipo de servicios</p>
    </div>
    <form class="form" v-on:submit.prevent="login()">
      <input
        name="usuario"
        v-model="nombreUsuario"
        v-validate="'required'"
        type="text"
        placeholder="Usuario"
      />
      <input
        name="contraseña"
        v-model="contrasena"
        v-validate="'required'"
        type="password"
        placeholder="Contraseña"
      />

      <button name="loginButton" type="submit">Ingresar</button>
      <p>Aun no tienes cuenta?</p>
      <a v-on:click="goToRegister">Registrate</a>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import { environment } from "../environment/environment";
export default {
  name: "Login",
  data: function() {
    return {
      nombreUsuario: "",
      contrasena: "",
    };
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/");
    }
  },
  methods: {
    handleLogin() {
      console.log(this.nombreUsuario);
      console.log(this.contrasena);
    },
    goToRegister: function() {
      this.$router.push("/register");
    },
    login: function() {
      axios
        .post(`${environment.api}/api/auth/login`, {
          nombreUsuario: this.nombreUsuario,
          contrasena: this.contrasena,
        })
        .then((response) => {
          console.log(response.data);
        
          localStorage.setItem("id",response.data.usuarioId);
          localStorage.setItem("token",response.data.token);
          localStorage.setItem("login", "true");
          console.log(localStorage.getItem("id"));
          console.log(localStorage.getItem("login"));
          console.log(localStorage.getItem("token"));
          var rolesUsuario = response.data.roles

          for(var i = 0; i < 2; i++){
              if (rolesUsuario[i] != undefined){
                  if(rolesUsuario[i] == "ROL_CLIENTE"){
                      localStorage.setItem("cliente", "true");
                  }
                  else if(rolesUsuario[i] == "ROL_ANUNCIANTE"){
                      localStorage.setItem("anunciante", "true");
              }
              }
              
          }
          console.log("Cliente: " + localStorage.getItem("cliente"))
          console.log("Anunciante: " + localStorage.getItem("anunciante"))
          this.$router.push("/");

          
        });
      // this camp will have logic of authenticate
      
    
    },
  },
};
</script>

<style>
.login-container {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.login-container .header {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-top: -64px;
  margin-bottom: 60px;
}
.login-container .header p {
  color: #858585;
  font-weight: 400;
  margin-top: 12px;
}

.login-container .form {
  display: flex;
  flex-direction: column;
}

.login-container .form input {
  width: 320px;
  border-radius: 8px;
  border: none;
  background: #fafafa;
  padding: 16px;
  font-size: 16px;
  color: #323232;
  margin: 12px 0;
  border: 1px solid #fcfcfc;
  transition: all 0.2s ease-in-out;
}

.login-container .form button {
  padding: 18px 96px;
  border: none;
  background: #ff3168;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin-top: 24px;
  font-size: 18px;
}

.login-container .form input:focus {
  border: 1px solid #ff3168;
}

.login-container .form p {
  margin-top: 24px;
  text-align: center;
  color: #becbd5;
  margin-top: 80px;
}
.login-container .form a {
  padding: 16px 48px;
  border: 1px solid #ff3168;
  border-radius: 8px;
  margin-top: 12px;
  font-weight: 400;
  font-size: 16px;
  color: #ff3168;
  text-decoration: none;
  text-align: center;
  transition: all 0.15s ease-in-out;
}

.login-container .form a:hover {
  background: #ff3168;
  color: #ffffff;
}
</style>




