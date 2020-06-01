<template>
      <div class="modal-container-aceptar">
        <div class="card">
        <img v-on:click="closeModal" src="../assets/ic_close_black.svg" alt="">
            <h2>Confirmación {{id}}</h2>
            <p>Por favor ingrese la hora pactada</p>
            <input v-model="horaPactada" name="mensaje"  type="text" placeholder="13:40:00"/>
            <div class="btn-container">
                <button v-on:click="submit">Enviar</button>
            </div>
        </div>
    </div>
</template>

<script>
import SolicitudService from "../services/solicitud.service";
export default {
    name: "ModalAceptarSolicitud",
    props: ['id'],
    data: function(){
        return {
            horaPactada: ""
        }
    },
    methods: {
        closeModal(){
            this.$emit('CloseModalAceptar');
        },
        async submit(){
            try {
                await SolicitudService.aceptarSolicitud(this.$props.id,this.$data.horaPactada+ ":00").then((e)=>{
                    console.log(e)
                })
                this.closeModal();
                
            } catch (error) {
                console.log(error);
            }
        }
    }
}
</script>

<style>
.modal-container-aceptar{
    z-index: 999;
    position: fixed;
    top: 0;
    left: 0;
    display: flex;
    width: 100%;
    height: 100vh;
    background: rgba(0, 0, 0, .37);

}
.modal-container-aceptar .card{
    width: 600px;
    height: fit-content;
    border-radius: 6px;
    padding: 48px 72px;
    position: relative;
    margin: 128px auto;
    background: #ffffff;

    
}
.modal-container-aceptar .card img{
    position: absolute;
    top: 32px;
    right: 32px;
    cursor: pointer;
}
.modal-container-aceptar .card h2{
    font-size: 24px;
    color: #000;
    font-weight: 600;
    margin-bottom: 8px !important;
}
.modal-container-aceptar .card p {
   font-size: 20px;
   color: #848484;
   font-weight: 400; 
   margin-bottom: 32px;
}

.modal-container-aceptar .card input{
    width: 100%;
    border: none;
    border-radius: 6px;
    padding: 24px;
    background: #fafafa;
}
.modal-container-aceptar .btn-container{
    width: 100%;
    display: flex;
    justify-content: flex-start;
    margin-top: 32px;
}

.modal-container-aceptar .btn-container button{
    background: #FFAE31;
    padding: 12px 24px;
    width: 160px;
    color: #ffffff;
    font-weight: 600;
    font-size: 20px;
    border-radius: 6px;
}
.btn-close-modal{
    position: absolute;
}
</style>