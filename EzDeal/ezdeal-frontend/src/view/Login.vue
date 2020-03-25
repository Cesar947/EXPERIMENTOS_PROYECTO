<template>
  <div class="login-container">
    <div class="header">
      <img src="../assets/Logo.svg" alt="" />
      <h1>Ez Deal</h1>
      <p>Encuentra todo tipo de servicios</p>
    </div>
    <div class="form">
      <input type="text" placeholder="Usuario" />
      <input type="password" placeholder="Contraseña" />

      <button>Ingresar</button>
      <a v-on:click="goToRegister()">Aun no tienes cuenta? Regístrate</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
   methods: {
    goToRegister: function () {
      this.$router.push("/register");
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

.header {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-top: -64px;
  margin-bottom: 128px;
}
.header p {
  color: #858585;
  font-weight: 400;
}

.header h1 {
  margin: 16px 0 8px 0;
}
.form {
  display: flex;
  flex-direction: column;
}

.form input {
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

.form button {
  padding: 18px 96px;
  border: none;
  background: #5f6caf;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin-top: 24px;
  font-size: 18px;
}

.form input:focus {
  border: 1px solid #5f6caf;
}

.form a {
  margin-top: 48px;
  font-weight: 400;
  font-size: 16px;
  color: #5f6caf;
  text-decoration: underline;
  text-align: center;
}
</style>
