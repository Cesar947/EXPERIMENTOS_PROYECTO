<template>
  <div class="register-container">
    <div v-on:click="goToHome" class="header">
      <img src="../assets/Logo.svg" alt="" />
      <h1>Ez Deal</h1>
    </div>

    <div class="form">
      <div class="field-group">
        <div class="field">
          <label for="name">Nombres</label>
          <input type="text" v-model="name" placeholder="Nombres" />
        </div>
        <div class="field">
          <label for="name">Apellidos</label>
          <input type="text" v-model="lastname" placeholder="Apellidos" />
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Teléfono</label>
          <input type="number" v-model="phone" placeholder="Telefono" />
        </div>
        <div class="field">
          <label for="name">Celular</label>
          <input type="number" v-model="cellphone" placeholder="Celular" />
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Distrito</label>
          <input type="text" v-model="district" placeholder="Distrito" />
        </div>
        <div class="field">
          <label for="name">Correo electrónico</label>
          <input type="text" v-model="email" placeholder="Correo electrónico" />
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Contraseña</label>
          <input type="password" v-model="password" placeholder="Contraseña" />
        </div>
        <div class="field">
          <label for="name">Repetir Contraseña</label>
          <input type="password" placeholder="Repetir Contraseña" />
        </div>
      </div>
      <div class="btn-container">
        <button v-on:click="register()">Registrar</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
  data: function() {
    return {
      email: "",
      password: "",
      name: "",
      lastname: "",
      phone: "",
      cellphone: "",
      district: ""
    };
  },
  methods: {
    goToHome: function() {
      this.$router.push("/login");
    },

    register: function() {
      // This camp will have logic of register

      this.$router.push("/login");
    }
  }
};
</script>

<style>
.register-container .header {
  padding: 96px 0 48px 0;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  cursor: pointer;
}

.register-container .header h1 {
  color: #5f6caf;
  margin-top: 8px;
}
.register-container .field-group {
  width: 800px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.register-container .field-group .field {
  width: 40%;
  display: flex;
  flex-direction: column;
  margin: 12px 0;
}

.register-container .field-group .field label {
  margin-bottom: 8px;
  font-size: 16px;
  font-weight: 600;
  color: #323232;
}

.register-container .field-group .field input {
  width: 320px;
  border-radius: 8px;
  border: none;
  background: #fafafa;
  padding: 16px;
  font-size: 16px;
  color: #323232;
  margin: 12px 0;
  border: 1px solid #f6f6f6;
  transition: all 0.2s ease-in-out;
}
.register-container .field-group .field input:focus {
  border: 1px solid #5f6caf;
}
.register-container .btn-container {
  width: 100%;
  display: flex;
  justify-content: center;
}
.register-container .form button {
  padding: 18px 96px;
  border: none;
  background: #5f6caf;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin: 24px auto;
  font-size: 18px;
}
</style>
