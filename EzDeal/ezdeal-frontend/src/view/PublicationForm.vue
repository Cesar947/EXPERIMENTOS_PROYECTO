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
          <textarea
            v-model="service.descripcion"
            type="text"
            placeholder="Descripción"
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
        <div class="horarios">
          <div v-if="service.horarios.length > 0">
            <div
              v-for="(horario, index) in service.horarios"
              v-bind:key="index"
              class="card-horario"
            >
              <button
                v-on:click="deleteHorario(horario)"
                class="delete-horario"
              >
                <img src="../assets/close.svg" width="16" alt="" />
              </button>

              <div class="field-group">
                <div class="field">
                  <label for="">Día</label>
                  <input
                    type="text"
                    v-model="horario.dia"
                    placeholder="Lunes, Martes,..."
                  />
                </div>
                <div class="field">
                  <label for="">Hora de inicio</label>
                  <input
                    type="text"
                    v-model="horario.horaApertura"
                    placeholder="13:40 | 09:30"
                  />
                </div>
                <div class="field">
                  <label for="">Hora de fin</label>
                  <input
                    type="text"
                    v-model="horario.horaCierre"
                    placeholder="13:40 |  09:30"
                  />
                </div>
              </div>
            </div>
            <button v-on:click="agregarHorario()">Agregar horario</button>
          </div>
          <div class="horario-info" v-if="service.horarios.length === 0">
            <img src="../assets/time.svg" width="64" alt="" />
            <h2>Horario</h2>
            <p>Tus clientes necesitan saber tu disponibilidad</p>
            <button v-on:click="agregarHorario()">Agregar horario</button>
          </div>
        </div>
        <div class="btn-submit">
          <button v-if="service.horarios.length > 0" v-on:click="submit()">
            Publicar
          </button>
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
      service: new ServiceRequest("", "", "", ""),
      day: "",
      picker: null,
      pickerEnd: "",
      dia: "",
      horaApertura: "",
      horaCierre: "",
    };
  },

  methods: {
    changeHoraCierre() {
      console.log(this.$data.pickerEnd);
    },

    submit() {
      this.$data.service.costoServicio = parseFloat(
        this.$data.service.costoServicio
      );
      this.$data.service.modalidad = parseInt(this.$data.service.modalidad);

      this.$data.service.horarios.forEach((e) => {
        e.horaApertura = `${e.horaApertura}:00.333`;
        e.horaCierre = `${e.horaCierre}:00.333`;
      });
      const id = parseInt(localStorage.getItem("id"));
     const request  = {

        "titulo": this.service.titulo,
        "imagen": this.service.imagen,
        "costoServicio": this.service.costoServicio,
        "descripcion": this.service.descripcion,
        "estaHabilitado": this.service.estaHabilitado,
        "valoracion": this.service.valoracion,
        "modalidad": this.service.modalidad,
        "videoPresentacion": this.service.videoPresentacion,
        "horarios": [...this.service.horarios]
    }
      console.log(request);
      ServicePublication.submitService(id, 1, request).then(
        () => {
          console.log("Servicio correctamente");
          this.$router.push("/");
        },
        (e) => {
          console.log("hubo un error",e);
        }
      );
    },
    agregarHorario() {
      this.$data.service.horarios.push({
        dia: "",
        horaApertura: "",
        horaCierre: "",
      });
    },

    deleteHorario(horario) {
      this.$data.service.horarios = this.$data.service.horarios.filter(
        (e) => e !== horario
      );
    },
  },
};
</script>

<style>
.publication-form-container {
  width: 80%;
  margin: 48px auto;
  display: flex;
  flex-direction: row-reverse;
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
.publication-form-container .form-container .field select,
.publication-form-container .form-container .field textarea {
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
.publication-form-container .horario-info {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 32px;
}
.publication-form-container .horario-info h2 {
  font-size: 22px !important;
  margin: 8px 0 !important;
}

.publication-form-container .horario-info p {
  font-size: 18px !important;
  margin: 0px !important;
}
.publication-form-container .horarios button {
  padding: 10px 20px;
  border-radius: 6px;
  background: #ff3168;
  color: #ffffff;
  margin-top: 16px;
  border: none;
}

.publication-form-container .card-horario {
  width: 100%;
  height: 100%;
  padding: 32px 24px;
  border-radius: 8px;
  background: linear-gradient(45deg, rgb(255, 57, 100), rgb(255, 138, 59));
  position: relative;
  margin: 24px 0;
  animation-name: example;
  animation-duration: 0.4s;
  animation-timing-function: ease-in-out;
}

.publication-form-container .card-horario .field {
  width: 31% !important;
}
.publication-form-container .card-horario label {
  color: #ffffff !important;
}

.publication-form-container .card-horario input {
  background: rgba(255, 255, 255, 0.1) !important;
  color: #ffffff !important;
  border: none !important;
  font-size: 18px !important;
}
.publication-form-container .card-horario input::placeholder {
  color: rgba(255, 255, 255, 0.37) !important;
}
.publication-form-container .card-horario .delete-horario {
  background: transparent;
  position: absolute;
  top: 0;
  right: 0;
}
@keyframes example {
  0% {
    transform: translateX(-100px);
    opacity: 0;
  }

  100% {
    transform: translateX(0);
    opacity: 1;
  }
}
</style>
