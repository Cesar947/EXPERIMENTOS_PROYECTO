<template>
  <div class="login-container">
    <div class="header">
      <img src="../assets/Logo.svg" alt="" />
      <p>Encuentra todo tipo de servicios</p>
    </div>
    <form class="form" v-on:submit.prevent="handleLogin()">
      <input v-model="usuario.nombreUsuario" v-validate="'required'" type="text" placeholder="Usuario" />
      <input v-model="usuario.contrasena" v-validate="'required'" type="password" placeholder="Contraseña" />

      <button type="submit">Ingresar</button>
      <p >Aun no tienes cuenta? </p>
      <a v-on:click="goToRegister">Registrate</a>
    </form>
  </div>
</template>

<script>
import Usuario from '../models/usuario';

export default {
  name: "Login",
  data: function() {
    return {
     /* username: "",
      password: ""*/
      usuario: new Usuario('', ''),
      loading: false,
      message: ''
    };

  },
  computed: {
      loggedIn(){
        return this.$store.state.auth.status.loggedIn;
      }
  },
  created(){
      if(this.loggedIn){
        this.$router.push('/home');
      }
  },
  methods: {
    handleLogin() {
      console.log(this.usuario)
      this.loading = true;
      this.$validator.validateAll().then(isValid => {
        if (!isValid) {
          this.loading = false;
          return;
        }

        if (this.usuario.nombreUsuario && this.usuario.contrasena) {
          this.$store.dispatch('auth/login', this.usuario).then(
            () => {
              this.$router.push('/profile');
            },
            error => {
              this.loading = false;
              this.message =
                (error.response && error.response.data) ||
                error.message ||
                error.toString();
            }
          );
        }
      });
    }
   /* goToRegister: function() {
      this.$router.push("/register");
    },
    login: function() {

      // this camp will have logic of authenticate
      this.$router.push("/home");

      console.log("username",this.username);
      console.log("password",this.password);
    }*/


  }
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
  background: #fcfcfc;
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
  background: #FF3168;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin-top: 24px;
  font-size: 18px;
}

.login-container .form input:focus {
  border: 1px solid #FF3168;
}

.login-container .form p {
  margin-top: 24px;
  text-align: center;
  color: #BECBD5;
  margin-top: 80px;

  }
.login-container .form a {
  padding: 16px 48px;
  border: 1px solid #ff3168;
  border-radius: 8px;
  margin-top: 12px;
  font-weight: 400;
  font-size: 16px;
  color: #FF3168;
  text-decoration: none;
  text-align: center;
  transition: all .15s ease-in-out;
}

.login-container .form a:hover{
  background: #ff3168;
  color: #ffffff;
}
</style>
