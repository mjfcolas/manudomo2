<template>
  <span class="login">
    <div id="login-modal" class="modal fade" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">Connexion</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <div class="container-fluid">
              <form id="login-form">
                <div class="row">
                  <div class="col-md-4">
                    <label for="login-form-login-label">Login</label>
                  </div>
                  <div class="col-md-8">
                    <input type="text" v-model="formLogin.username" id="login-form-login-input" placeholder="emmanuel"/>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-4">
                    <label for="login-form-password-label">Mot de passe</label>
                  </div>
                  <div class="col-md-8">
                    <input type="password" v-model="formLogin.password" id="login-form-password-input" />
                  </div>
                </div>
              </form>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" @click="login">Se connecter</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
          </div>
        </div>
      </div>
    </div>

    <span class="login-buttons">
      <span :class="{'hidden':!isGranted}">
        <input type="button" value="Logout" class="btn btn-primary" @click="logout"/>
      </span>
      <span :class="{'hidden':isGranted}">
        <input type="button" value="Login" class="btn btn-primary" id="open-login-button" data-toggle="modal" data-target="#login-modal"/>
      </span>
    </span>
  </span>
</template>

<script>
import Base from '@/components/base/Base'
import LoggedUser from '@/auth/LoggedUser'
import Login from '@/services/Login'

export default {
  name: 'login',
  extends: Base,
  data () {
    return {
      formLogin: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    login: function () {
      LoggedUser.initialize(this.formLogin.username, this.formLogin.password)
    },
    logout: function () {
      LoggedUser.logout()
    },
    testPrivate: function () {
      Login.privateEndpoint()
    }
  }
}
</script>

<style>
  .login-buttons{
    float: right;
  }
</style>
