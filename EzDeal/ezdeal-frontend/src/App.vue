<template>
  <v-app>
    <v-content>
      <router-view/>
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>

<style>
@font-face {
  font-family: "G-sans";
  src: url("./assets/fonts/ProductSans-Regular.ttf");
  
}
::placeholder{
  color: rgba(0,0,0,.36);
}
*::-webkit-scrollbar{
  width: 10px !important;
}
*::-webkit-scrollbar-thumb{
  background: #e2e2e2 !important;
  border-radius: 10px;
}
*::-webkit-scrollbar-track{
  background: #ffffff;
}
*{
  margin: 0;
  padding: 0;
  font-family: "G-sans" !important;
  outline: none !important;
}

</style>
