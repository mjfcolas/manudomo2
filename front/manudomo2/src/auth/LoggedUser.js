import Login from '@/services/Login'
import RequestHelper from '@/helpers/RequestHelper'
import { EventBus } from '@/helpers/eventBus.js'

class LoggedUser {
  static async initialize (username, password) {
    const response = await Login.doLogin(username, password)
    if (RequestHelper.isSuccess(response)) {
      this.storeToken(response)
    }
    EventBus.$emit('login-changed')
    EventBus.$emit('do-display')
  }

  static storeToken (response) {
    const token = response.headers.get('Authorization')
    localStorage.setItem('jwtToken', token)
  }

  static logout () {
    localStorage.removeItem('jwtToken')
    EventBus.$emit('login-changed')
  }

  static isLogged () {
    return localStorage.jwtToken != null
  }
}
export default LoggedUser
