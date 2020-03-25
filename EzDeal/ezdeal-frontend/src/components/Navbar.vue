<template>
  <div class="navbar-container">
    <div class="logo">
      <img src="../assets/Logo.svg" alt="" />
      <h1>Ez Deal</h1>
    </div>
    <div class="nav-link">
      <a>Buscar</a>
      <a>Mis Servicios</a>
    </div>
  </div>
</template>

<script>
export default {
  name: "navbar"
};
</script>

<style>
.navbar-container {
  width: 100%;
  padding: 32px 96px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.navbar-container .logo {
  display: flex;
}
.navbar-container .logo h1 {
  margin-left: 12px;
  color: #5f6caf;
}

.navbar-container .nav-link {
  padding-right: 96px;
}

.navbar-container .nav-link a {
  margin: 0 32px;
}
</style>
