<template>
  <div class="register-container">
    <div v-on:click="goToHome" class="header">
      <img src="../assets/logo.png" alt />
    </div>

    <div class="form">
      <h1 style="text-align:center">Bienvenido a EzDeal</h1>
       <h2>Preparate para todos los clientes que obtendrás</h2>
      <p>Se debe de completar todos los campos</p>

      <div class="rol-group">
        <div v-on:click="selectRol(1)" class="rol" :class="{ 'rolActive': clientRole }">
          <img src="../assets/user.svg" alt />
          <h4>Cliente</h4>
        </div>

        <div v-on:click="selectRol(2)" class="rol" v-bind:class="{'rolActive' : announcerRole }">
          <img src="../assets/worker.svg" alt />
          <h4>Agente</h4>
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Nombres</label>
          <input type="text" v-model="nombres" placeholder="Nombres" />
        </div>
        <div v-if="announcerRole" class="field">
          <label for="name">DNI</label>
          <input type="text" v-model="infoAnunciante.dni" placeholder="DNI" />
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Apellido Paterno</label>
          <input type="text" v-model="apellidoPaterno" placeholder="Apellido Paterno" />
        </div>
        <div class="field">
          <label for="name">Apellido Materno</label>
          <input type="text" v-model="apellidoMaterno" placeholder="Apellido Materno" />
        </div>
      </div>
      <div v-if="announcerRole" class="field-group">
        <div class="field">
          <label for="name">Teléfono</label>
          <input type="number" v-model="infoAnunciante.telefonoFijo" placeholder="Telefono" />
        </div>
        <div class="field">
          <label for="name">Número de Celular</label>
          <input type="number" v-model="infoAnunciante.celular" placeholder="Celular" />
        </div>
      </div>
      <div class="field-group">
        <div style="width:100%" class="field large">
          <label for="name">Direccion</label>
          <input style="width:100%" type="text" v-model="direccion" placeholder="Direccion" />
        </div>
      </div>
      <div v-if="announcerRole" class="field-group">
        <div style="width:100%" class="field large">
          <label for="name">Link de contacto</label>
          <input style="width:100%" type="text" v-model="infoAnunciante.urlContacto" placeholder="Link de contacto" />
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Distrito</label>
          <input type="text" v-model="distrito" placeholder="Distrito" />
        </div>

        <div class="field">
          <label for="name">Provincia</label>
          <input type="text" v-model="provincia" placeholder="Provincia" />
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Departamento</label>
          <input type="text" v-model="departamento" placeholder="Departamento" />
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Nombre de usuario</label>
          <input type="text" v-model="nombreUsuario" placeholder="Nombre de usuario" />
        </div>
        <div class="field">
          <label for="name">Subir foto de perfil</label>
          <input type="text" v-model="imagenPerfil" placeholder="Foto de perfil" />
        </div>
      </div>
      <div class="field-group">
        <div class="field">
          <label for="name">Correo electrónico</label>
          <input type="text" v-model="email" placeholder="Correo electrónico" />
        </div>
        <div class="field">
          <label for="name">Contraseña</label>
          <input type="password" v-model="contrasena" placeholder="Contraseña" />
        </div>
      </div>
      <div v-if="announcerRole" class="field-group">
        <div class="field">
          <label for="name">Subir antecedentes penales</label>
          <input type="text" v-model="infoAnunciante.antecedentesPenales" placeholder="Antecedentes" />
        </div>
        <div class="field">
          <label for="name">Membresia</label>
          <input type="text" v-model="membresia" placeholder="Membresia" />
        </div>
      </div>
      <div class="btn-container">
        <button v-on:click="register()">Continuar</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import { environment } from '../environment/environment';
export default {
  name: "Register",
  data: function() {
    return {
     
        nombreUsuario: "",
        email: "",
        contrasena: "",
        nombres: "",
        apellidoPaterno: "",
        apellidoMaterno: "",
        departamento: "",
        provincia: "",
        direccion: "",
        distrito: "",
        imagenPerfil: "",
        infoAnunciante: {
          telefonoFijo: "",
          celular: "",
          dni: "",
          urlContacto: "",
          antecedentesPenales: "",
          fechaCaducidad: ""
        },
        membresiaId: "",
        role: [],
      membresia: "",
      clientRole: false,
      announcerRole: false,
    };
  },

  methods: {
    goToHome: function() {
      this.$router.push("/");
    },

    register: function() {
      if (this.announcerRole){
        this.role = ["cliente", "anunciante"]
      }
      else if (this.clientRole){
        this.role = ["cliente"]
      }
      if (this.membresia == "GOLD"){
        this.membresiaId = 1
      }
      else if (this.membresia == "FREE"){
        this.membresiaId = 2
      } 
      axios.post(`${environment.api}/api/auth/registro`, {
        
        nombreUsuario: this.nombreUsuario,
        email: this.email,
        contrasena: this.contrasena,
        nombres: this.nombres,
        apellidoPaterno: this.apellidoPaterno,
        apellidoMaterno: this.apellidoMaterno,
        departamento: this.departamento,
        provincia: this.provincia,
        direccion: this.direccion,
        distrito: this.distrito,
        imagenPerfil: this.imagenPerfil,
        infoAnunciante: {
          telefonoFijo: this.telefonoFijo,
          celular: this.celular,
          dni: this.dni,
          urlContacto: this.urlContacto,
          antecedentesPenales: this.antecedentesPenales,
          fechaCaducidad: this.fechaCaducidad
        },
        membresiaId: this.membresiaId,
        role: this.role
      })
      .then(res => {console.log(res)})

      this.$router.push("/login");
    },
    selectRol: function(id) {
      console.log(id);
      if (id === 1) {
        this.clientRole = true;
        this.announcerRole = false;
      } else if (id === 2) {
        this.clientRole = true;
        this.announcerRole = true;
      }

      console.log(this.$data);
    }
  }
};
</script>

<style>
.register-container .header {
  padding: 48px;
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
.register-container .rol-group {
  margin: 48px auto;
  display: flex;
  width: 600px;
  justify-content: space-between;
  align-items: center;
}

.register-container .rol-group .rol {
  cursor: pointer;
  width: 190px;
  border: 3px solid #f5f5f5;
  background: #ffffff;
  display: flex;
  flex-direction: column;
  padding: 24px;
  border-radius: 12px;
  transition: all 0.2s ease-in-out;
}
.register-container .rol-group .rol:hover {
  border: 3px solid #07580b;
}
.register-container .rol-group .rol h4 {
  text-align: center;
  margin-top: 24px;
}

.register-container .rol-group .rolActive {
  /*border: 3px solid #ff3168 !important;
  background: rgba(255, 101, 106, 0.38) !important;*/
  border: 3px solid #0c7c11 !important;
  background: rgba(120, 231, 126, 0.38) !important;
}
.register-container .field-group .field label {
  margin-bottom: 8px;
  font-size: 16px;
  font-weight: 600;
  color: #323232;
}

.register-container .form h2,
.register-container .form p {
  text-align: center;
}
.register-container .form h2 {
  margin-bottom: 8px;
}
.register-container .form p {
  color: #646464;
}
.register-container .field-group .field input {
  width: 320px;
  border-radius: 8px;
  border: none;
  background: #f3efef;
  padding: 16px;
  font-size: 16px;
  color: #323232;
  margin: 12px 0;
  border: 1px solid #f6f6f6;
  transition: all 0.2s ease-in-out;
}
.register-container .field-group .field input:focus {
  border: 1px solid #ff3168;
}
.register-container .btn-container {
  width: 100%;
  display: flex;
  justify-content: center;
}
.register-container .form button {
  padding: 18px 96px;
  border: none;
  background: #ff3168;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin: 24px auto;
  font-size: 18px;
}
</style>
