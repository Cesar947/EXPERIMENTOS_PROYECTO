<template>
  <div class="publication-form-container">
    <div class="ilustration-container">
      <img src="../assets/PulbicationPostIlustration.svg" alt="" />
    </div>
    <div class="form-container">
      <h2>Publica un servicio</h2>
      <p>Te ayudamos a posicionar tu trabajo en las mejores búsquedas</p>

      <div class="form">
        <div class="field">
          <label for="">Titulo del servicio</label>
          <input v-model="service.titulo" type="text" placeholder="Titulo" />
        </div>
        <div class="field">
          <label for="">Descripción</label>
          <input
            v-model="service.descripcion"
            type="text"
            placeholder="Descripcion"
          />
        </div>

        <div class="field-group">
          <div class="field">
            <label for="">Tipo de servicio</label>
            <input type="text" placeholder="Electricista, pintor,etc" />
          </div>
          <div class="field">
            <label for="">Costo (Soles)</label>
            <input
              v-model="service.costoServicio"
              type="text"
              placeholder="15.00"
            />
          </div>
        </div>
        <div class="field">
          <label for="">Modalidad</label>
          <select v-model="service.modalidad">
            <option value="1">A domicilio</option>
            <option value="2">A local</option>
            <option value="3">A domicilio & En local </option>
          </select>
        </div>
        <div class="field">
          <label for="">Día</label>
          <select v-model="service.horarios[0].dia">
            <option value="Lunes">Lunes</option>
            <option value="Martes">Martes</option>
            <option value="Miercoles">Miercoles</option>
            <option value="Jueves">Jueves</option>
            <option value="Viernes">Viernes</option>
            <option value="Sábado">Sábado</option>
            <option value="Domingo">Domingo</option>
          </select>
        </div>
        <div class="field-group">
          <div class="field timer-field">
            <label for="">Hora de Apertura</label>
            <v-row justify="center">
              <v-time-picker
                format="24hr"
                v-model="service.horarios[0].horaApertura"
              ></v-time-picker>
            </v-row>
          </div>
          <div class="field timer-field">
            <label for="">Hora de Cierre</label>
            <v-row justify="center">
              <v-time-picker
                format="24hr"
                v-on:change="changeHoraCierre()"
                v-model="service.horarios[0].horaCierre"
              ></v-time-picker>
            </v-row>
          </div>
        </div>

        <div class="btn-submit">
          <button v-on:click="submit()">Publicar</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ServiceRequest from "../models/Service";
import ServicePublication from "../services/Service.service";
export default {
  name: "Publication",

  data: function() {
    return {
      service: new ServiceRequest("", "", "", 1, "", 15.0, 1, ""),
      day: "",
      picker: null,
      pickerEnd: "",
    };
  },

  methods: {
    changeHoraCierre() {
      console.log(this.$data.pickerEnd);
    },

    submit() {
      const obj = {
        titulo: this.$data.service.titulo,
        imagen: "dsgfsadgds.jpg",
        costoServicio: parseInt(this.$data.service.costoServicio),
        descripcion: "Te paseo a tu igüana",
        estaHabilitado: 1,
        modalidad: parseInt(this.$data.service.modalidad),
        videoPresentacion: "dsgasdgdsgds.mp4",
        horarios: [
          {
            dia: "",
            horaApertura:
              this.$data.service.horarios[0].horaApertura + ":00.123456789",
            horaCierre:
              this.$data.service.horarios[0].horaCierre + ":00.123456789",
          },
        ],
      };

      console.log(obj);
      ServicePublication.submitService(1, 1, obj).then((res) => {
        console.log(res);
        this.$router.push("/home");
      });
    },
  },
};
</script>

<style>
.publication-form-container {
  width: 80%;
  margin: 48px auto;
  display: flex;
  justify-content: space-between;
}
.publication-form-container .form-container h2 {
  font-size: 48px;
  font-weight: 700;
  margin-bottom: 16px;
}
.publication-form-container .form-container p {
  font-size: 24px;
  color: #545454;
  margin-bottom: 48px;
}

.publication-form-container .form-container .form > div {
  margin: 24px 0;
}
.publication-form-container .form-container .field-group {
  display: flex;
  justify-content: space-between;
}

.publication-form-container .form-container .field {
  display: flex;
  flex-direction: column;
}
.publication-form-container .form-container .field input,
.publication-form-container .form-container .field select {
  width: 100%;
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
.publication-form-container .form-container .field label {
  margin-bottom: 8px;
  font-size: 24px;
  font-weight: 600;
  color: #323232;
}

.publication-form-container .form-container .field-group .field {
  display: flex;
  flex-direction: column;
  width: 42%;
}
.publication-form-container .form-container .form .btn-submit {
  display: flex;
  width: 100%;
  justify-content: center;
}

.publication-form-container .form-container .form .btn-submit button {
  padding: 18px 32px;
  border: none;
  background: #ff3168;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin: 24px auto;
  font-size: 18px;
}

.publication-form-container .form-container .field input:focus {
  border: 1px solid #ff3168;
}

.publication-form-container .timer-field label {
  margin-bottom: 24px !important;
}
</style>
