import EndPoints from '@/config/EndPoints'

class ProfilService {
  static async load () {
    EndPoints.getProfil.prepare({})
    const result = await fetch(EndPoints.getProfil.url, EndPoints.getProfil.headers)
    return result.json()
  }

  static async saveProfil (profilVm) {
    EndPoints.saveProfil.prepare(profilVm)
    const result = await fetch(EndPoints.saveProfil.url, EndPoints.saveProfil.headers)
    return result.json()
  }
}
export default ProfilService
