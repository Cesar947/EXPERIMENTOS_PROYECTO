<template>
  <div>
    <div v-if="!loading" class="search-container">
      <img src="../assets/SearchIlustration.svg" height="200" alt="" />
      <h2>¿Buscas algún servicio?</h2>
      <p>Nosotros te podemos ayudar</p>
      <input
        v-model="job"
        type="text"
        placeholder="¿Qué tipo de servicio estás buscando?"
      />
      <button v-on:click="findJobs">Buscar</button>
    </div>
    <div v-if="loading" class="loading-container">
      <loading></loading>
    </div>
  </div>
</template>

<script>
import loading from "../components/Loading";
export default {
  name: "Search",
  components: { loading },
  data: function() {
    return {
      loading: false,
      job: ""
    };
  },
  methods: {
    findJobs: function() {
      this.loading = true;

      setTimeout(() => {
        this.loading = false;
      }, 5000);
    }
  }
};
</script>

<style>
.search-container,
.loading-container {
  width: 100%;
  height: calc(100vh - 120px);
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.search-container h2 {
  margin: 48px 0 12px 0;
  font-weight: 700;
  font-size: 24px;
  color: #323232;
}

.search-container p {
  font-size: 20px;
  font-weight: 400;
  color: #545454;
  opacity: 0.6;
}

.search-container input {
  width: 400px;
  border-radius: 8px;
  border: none;
  background: #fafafa;
  padding: 16px;
  font-size: 18px;
  font-weight: 600;
  color: #323232;
  margin: 12px 0;
  text-align: center;
  border: 1px solid #f6f6f6;
  transition: all 0.2s ease-in-out;
  margin: 48px 0;
}

.search-container input:focus {
  border: 1px solid #ffb677;
}
.search-container button {
  padding: 18px 96px;
  border: none;
  background: #ffb677;
  font-weight: 600;
  color: #ffffff;
  border-radius: 8px;
  margin: 24px auto;
  font-size: 18px;
}
</style>
