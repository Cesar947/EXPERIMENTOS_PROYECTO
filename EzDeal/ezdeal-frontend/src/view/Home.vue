<template>
  <div>
    <Navbar></Navbar>
    <router-view></router-view>
  </div>
</template>

<script>
import Navbar from "../components/Navbar";
export default {
  name: "Home",
  components: {Navbar}
};
</script>

<style></style>
