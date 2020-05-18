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
*{
  margin: 0;
  padding: 0;
  font-family: "G-sans" !important;
  outline: none !important;
}

</style>
