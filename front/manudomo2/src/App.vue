<template>
  <div id="app">
    <main>
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <header-title></header-title>
          </div>
          <div class="col-md-4 display-large">
            <login></login>
          </div>
        </div>
      </div>
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
import Login from '@/components/login/Login'
import HeaderTitle from '@/components/headerTitle/HeaderTitle'

export default {
  name: 'app',
  components: {
    Login,
    HeaderTitle}
}
</script>

<style>
  .hidden {
    display: none
  }
</style>
