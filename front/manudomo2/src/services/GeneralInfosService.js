import EndPoints from '@/config/EndPoints'

class GeneralInfosService {
  static async load (startTime, endTime) {
    const params = {
      startTime: startTime,
      endTime: endTime
    }
    EndPoints.generalInfos.prepare(params)
    const result = await fetch(EndPoints.generalInfos.url, EndPoints.generalInfos.headers)
    return result.json()
  }
}
export default GeneralInfosService
