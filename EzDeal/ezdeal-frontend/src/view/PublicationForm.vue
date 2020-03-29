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
          <input type="text" placeholder="Titulo" />
        </div>
        <div class="field">
          <label for="">Descripción</label>
          <input type="text" placeholder="Descripcion" />
        </div>

        <div class="field-group">
          <div class="field">
            <label for="">Tipo de servicio</label>
            <input type="text" placeholder="Electricista, pintor,etc" />
          </div>
          <div class="field">
            <label for="">Costo (Soles)</label>
            <input type="text" placeholder="15.00" />
          </div>
        </div>

        <div class="btn-submit">
            <button>Publicar</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Publication"
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
  margin-bottom: 48px ;
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
.publication-form-container .form-container .field input {
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
.publication-form-container .form-container .form .btn-submit{
    display: flex;
    width: 100%;
    justify-content: center;

}

.publication-form-container .form-container .form .btn-submit button{
 padding: 18px 32px;
  border: none;
  background: #FF3168;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin: 24px auto;
  font-size: 18px;
}

.publication-form-container .form-container .field input:focus {
  border: 1px solid #FF3168;
}
</style>
