<template>
    <p>Hola soy el detalle {{qwe}}</p>
</template>

<script>
export default {
    name: "ServicioDetalle",

    
    data:  function(){
        return {
            "qwe": this.$route.params.id
        }
    }
    
}
</script>

<style>

</style>