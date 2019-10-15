import EndPoint from '@/config/EndPoint'

class EndPoints {

  ROOT_API = window.Conf.ROOT_API ? window.Conf.ROOT_API : process.env.ROOT_API

  login = new EndPoint(this.ROOT_API + '/login', 'POST', 'application/json', false)
  generalInfos = new EndPoint(this.ROOT_API + '/private/generalInfos', 'GET', 'application/json', true)
  getProfil = new EndPoint(this.ROOT_API + '/private/profil/get', 'GET', 'application/json', true)
  getMonitoring = new EndPoint(this.ROOT_API + '/private/monitoring/get', 'GET', 'application/json', true)
  saveProfil = new EndPoint(this.ROOT_API + '/private/profil/save', 'POST', 'application/json', true)
  livingRoomTemp = new EndPoint(this.ROOT_API + '/private/temperature/livingroomList', 'GET', 'application/json', true)
  roomTemp = new EndPoint(this.ROOT_API + '/private/temperature/roomList', 'GET', 'application/json', true)
  hcList = new EndPoint(this.ROOT_API + '/private/edf/hcList', 'GET', 'application/json', true)
  hpList = new EndPoint(this.ROOT_API + '/private/edf/hpList', 'GET', 'application/json', true)
  intensityList = new EndPoint(this.ROOT_API + '/private/edf/intensityList', 'GET', 'application/json', true)
  energyOnYear = new EndPoint(this.ROOT_API + '/private/edf/energyonyears', 'GET', 'application/json', true)
  pressureList = new EndPoint(this.ROOT_API + '/private/pressure/list', 'GET', 'application/json', true)
  hygroList = new EndPoint(this.ROOT_API + '/private/hygro/list', 'GET', 'application/json', true)
}
export default new EndPoints()
