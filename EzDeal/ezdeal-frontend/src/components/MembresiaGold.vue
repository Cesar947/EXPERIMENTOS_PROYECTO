<template>
  <div class="publication-form-container">
    <div class="ilustration-container">
      <img src="../assets/card_gold_membership.svg" alt="" />
    </div>
    <div class="form-container">
      <h2>Membresia Gold</h2>
      <p>Muestra tus servicios en la vista principal de nuestra página web</p>

      <div class="form">

        <div class="field">
          <label for="">Numero de tarjeta</label>
          <input name="numTarjeta" v-model="membresia.numeroTarjeta" type="text" placeholder="Número de tarjeta" />
        </div>
        <div class="field-group">
          <div class="field">
            <label for="">CCV</label>
            <input name="ccv" v-model="membresia.ccv" type="text" placeholder="CCV" />
          </div>
          <div class="field">
            <label for="">Fecha de vencimiento</label>
            <input name="fechaV" v-model="membresia.fechaVencimiento" type="text" placeholder="MM/AA" />
          </div>
        </div>


        <div class="btn-submit">
          <button name="quieroGold" v-on:click="getMembershipGold()" >Quiero ser gold</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Usuario from '../models/usuario';
import MembershipService from "../services/membership-gold.service";
export default {
  name: "MembresiaGold",
  data: function(){
    return{
      membresia:  new Usuario(1,'','','','')
    }
  },

  methods: {
    getMembershipGold(){
      MembershipService.goldMembreship(parseInt(localStorage.getItem("id"))).then( res=>{
        console.log(res);
        this.$router.push("/");
      })
    }
  }
};
</script>

<style>
.ilustration-container{
  position: relative;
  top: -50px;
  left: -50px;
}
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
.publication-form-container .form-container .form .btn-submit {
  display: flex;
  width: 100%;
  justify-content: center;
}

.publication-form-container .form-container .form .btn-submit button {
  padding: 18px 32px;
  border: none;
  background: #FFAE31;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin: 24px auto;
  font-size: 18px;
}

.publication-form-container .form-container .field input:focus {
  border: 1px solid #ff3168;
}
</style>
