<template>
  <div class="header-title">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <h1 class="float-left">
            Manudomo2
          </h1>
        </div>
        <div class="col-md-6">
          <nav class="nav nav-tabs">
            <router-link class="nav-item nav-link" active-class="active" data-toggle="tab" to="/home">Graphiques</router-link>
            <router-link class="nav-item nav-link" active-class="active" data-toggle="tab" to="/profil">Profil</router-link>
            <router-link class="nav-item nav-link" active-class="active" data-toggle="tab" to="/monitoring">Monitoring</router-link>
          </nav>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: 'header-title'
}
</script>
