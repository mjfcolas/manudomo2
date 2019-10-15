import EndPoints from '@/config/EndPoints'
// import axios from 'axios'

class Login {
  async doLogin (username, password) {
    var params = {
      username: username,
      password: password
    }
    EndPoints.login.prepare(params)
    const result = await fetch(EndPoints.login.url, EndPoints.login.headers)
    return result
  }
}
export default new Login()
