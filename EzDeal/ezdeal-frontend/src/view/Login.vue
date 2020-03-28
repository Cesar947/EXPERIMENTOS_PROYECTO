<template>
  <div class="login-container">
    <div class="header">
      <img src="../assets/Logo.svg" alt="" />
      <p>Encuentra todo tipo de servicios</p>
    </div>
    <div class="form">
      <input v-model="username" type="text" placeholder="Usuario" />
      <input v-model="password" type="password" placeholder="Contraseña" />

      <button v-on:click="login">Ingresar</button>
      <p >Aun no tienes cuenta? </p>
      <a v-on:click="goToRegister">Registrate</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data: function() {
    return {
      username: "",
      password: ""
    };
  },
  methods: {
    goToRegister: function() {
      this.$router.push("/register");
    },
    login: function() {

      // this camp will have logic of authenticate
      this.$router.push("/home");

      console.log("username",this.username);
      console.log("password",this.password);
    }
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
  margin-bottom: 128px;
}
.login-container .header p {
  color: #858585;
  font-weight: 400;
  margin-top: 12px;
}

.login-container .header h1 {
  margin: 16px 0 8px 0;
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
  margin-top: 48px;

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
