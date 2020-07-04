<template>
  <div class="modal-container-rechazar">
    <div class="card">
      <img v-on:click="closeModal" src="../assets/ic_close_black.svg" alt="" />
      <h2>Motivo de rechazo</h2>
      <p>Por favor ingrese el motivo de su rechazo</p>
      <textarea name="contenidoMotivo" v-model="motivo" id=""></textarea>
      <div class="btn-container">
        <button name="enviarMotivoRechazo" v-on:click="submit">Enviar</button>
      </div>
    </div>
  </div>
</template>

<script>
import SolicitudService from "../services/solicitud.service";
export default {
  name: "ModalRechazarSolicitud",
  props: ["id"],
  data: function() {
    return {
      motivo: "",
    };
  },
  methods: {
    closeModal() {
      this.$emit("CloseModal");
    },
    async submit() {
      try {
        await SolicitudService.rechazarSolicitud(this.$props.id, {
          motivo: this.$data.motivo,
        });
        this.closeModal();
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style>
.modal-container-rechazar {
  z-index: 999;
  position: fixed;
  top: 0;
  left: 0;
  display: flex;
  width: 100%;
  height: 100vh;
  background: rgba(0, 0, 0, 0.37);
}
.modal-container-rechazar .card {
  width: 900px;
  height: fit-content;
  border-radius: 6px;
  padding: 48px 72px;
  position: relative;
  margin: 128px auto;
  background: #ffffff;
}
.modal-container-rechazar .card img {
  position: absolute;
  top: 32px;
  right: 32px;
  cursor: pointer;
}
.modal-container-rechazar .card h2 {
  font-size: 24px;
  color: #000;
  font-weight: 600;
  margin-bottom: 8px !important;
}
.modal-container-rechazar .card p {
  font-size: 20px;
  color: #848484;
  font-weight: 400;
  margin-bottom: 32px;
}

.modal-container-rechazar .card textarea {
  width: 100%;
  height: 200px;
  border: none;
  border-radius: 6px;
  padding: 24px;
  background: #fafafa;
}
.modal-container-rechazar .btn-container {
  width: 100%;
  display: flex;
  justify-content: flex-end;
  margin-top: 32px;
}

.modal-container-rechazar .btn-container button {
  background: #ff3168;
  padding: 12px 24px;
  width: 160px;
  color: #ffffff;
  font-weight: 600;
  font-size: 20px;
  border-radius: 6px;
}
.btn-close-modal {
  position: absolute;
}
</style>
