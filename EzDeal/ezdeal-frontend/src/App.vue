<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "App"
};
</script>

<style>
@font-face {
  font-family: "Gsans";
  src: url("./assets/fonts/ProductSans-Regular.ttf");
  font-weight: 400;
}
@font-face {
  font-family: "Gsans";
  src: url("./assets/fonts/ProductSans-Medium.ttf");
  font-weight: 600;
}
@font-face {
  font-family: "Gsans";
  src: url("./assets/fonts/ProductSans-Bold.ttf");
  font-weight: 700;
}
::placeholder {
  color: #cbcbcb;
}
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Gsans";
  outline: none;
}

a,
button {
  cursor: pointer;
}
</style>
