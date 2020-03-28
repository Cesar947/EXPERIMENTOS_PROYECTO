<template>
  <div class="register-container">
    <div v-on:click="goToHome" class="header">
      <img src="../assets/Logo_dark.svg" alt="" />
    </div>

    <div class="form">


      <h2>Registro</h2>
      <p>Se debe de completar todos los campos</p>

      <div class="rol-group">
        <div v-on:click="selectRol(1)"  class="rol"  :class="{ 'rolActive': clientRole }"
>
          <img src="../assets/user.svg" alt="">
          <h4>Cliente</h4>
        </div>

        <div v-on:click="selectRol(2)"  class="rol" v-bind:class="{'rolActive' : agentRole }">
          <img src="../assets/worker.svg" alt="">
          <h4>Agente</h4>
        </div>
      </div>
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
          <label for="name">Número de Celular</label>
          <input type="number" v-model="cellphone" placeholder="Celular" />
        </div>
      </div>
      <div class="field-group">
        <div style="width:100%" class="field large">
          <label for="name">Direccion</label>
          <input style="width:100%" type="text" v-model="address" placeholder="Direccion" />
        </div>
      
      </div>
      <div v-if="agentRole" class="field-group">
        <div style="width:100%" class="field large">
          <label for="name">Link de contacto</label>
          <input style="width:100%" type="text" v-model="contactLink" placeholder="Direccion" />
        </div>
      
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Distrito</label>
          <input type="text" v-model="district" placeholder="Distrito" />
        </div>
     
        <div class="field">
          <label for="name">Provincia</label>
          <input type="text" v-model="depatarment" placeholder="Provincia" />
        </div>
     
      </div>
      <div class="field-group">
           <div class="field">
          <label for="name">Correo electrónico</label>
          <input type="text" v-model="email" placeholder="Correo electrónico" />
        </div>
        <div class="field">
          <label for="name">Contraseña</label>
          <input type="password" v-model="password" placeholder="Contraseña" />
        </div>
    
      </div>
      <div class="btn-container">
        <button v-on:click="register()">Continuar</button>
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
      address: "",
      district: "",
      depatarment: "",
      clientRole:false,
      agentRole:false,
      contactLink:"",
    };
  },


  methods: {
    goToHome: function() {
      this.$router.push("/login");
    },

    register: function() {
      // This camp will have logic of register

      this.$router.push("/login");
    },
    selectRol : function(id){

      console.log(id)
        if(id=== 1){
          this.clientRole =  true;
          this.agentRole =  false;

        }
        else if(id=== 2){
          this.clientRole =  false;
          this.agentRole =  true;

        }


      console.log(this.$data);
    }
  }
};
</script>

<style>
.register-container .header {
  padding: 48px ;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  
  cursor: pointer;
}


.register-container .field-group {
  width: 800px;
  margin: 0 auto;
  display: flex;
  align-items: center;
  justify-content: space-between;
  position: relative;
}
.register-container .field-group .field {
  width: 40%;
  display: flex;
  flex-direction: column;
  margin: 12px 0;
}
.register-container .rol-group{
  margin: 48px auto;
  display: flex;
  width: 600px;
  justify-content: space-between;
  align-items: center;
}

.register-container .rol-group .rol{
  cursor: pointer;
  width: 190px;
  border: 3px solid #f5f5f5;
  background: #ffffff;
  display: flex;
  flex-direction: column;
  padding: 24px;
  border-radius: 12px;
  transition: all .2s ease-in-out;
}
.register-container .rol-group .rol:hover{
    border: 3px solid #FF3168;

}
.register-container .rol-group .rol h4{
  text-align: center;
  margin-top: 24px;
}

.register-container .rol-group .rolActive{
    border: 3px solid #FF3168 !important;
    background: rgba(255,101,106,.38) !important;
}
.register-container .field-group .field label {
  margin-bottom: 8px;
  font-size: 16px;
  font-weight: 600;
  color: #323232;
}

.register-container .form h2,.register-container .form p{
  text-align: center;
}
.register-container .form h2{
  margin-bottom: 8px;
}
.register-container .form p{
  color: #646464;
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
  border: 1px solid #FF3168;
}
.register-container .btn-container {
  width: 100%;
  display: flex;
  justify-content: center;
}
.register-container .form button {
  padding: 18px 96px;
  border: none;
  background: #FF3168;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin: 24px auto;
  font-size: 18px;
}
</style>
