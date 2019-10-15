import EndPoints from '@/config/EndPoints'
import DatasetHelper from '@/helpers/DatasetHelper'

class DatasetService {
  static async loadLivingRoomTemp (startTime, endTime) {
    return DatasetService.loadDatasetInternal(startTime, endTime, EndPoints.livingRoomTemp)
  }

  static async loadRoomTemp (startTime, endTime) {
    return DatasetService.loadDatasetInternal(startTime, endTime, EndPoints.roomTemp)
  }

  static async loadEdfHc (startTime, endTime) {
    const result = DatasetService.loadDatasetInternal(startTime, endTime, EndPoints.hcList)
    return result
  }

  static async loadEdfHp (startTime, endTime) {
    const result = DatasetService.loadDatasetInternal(startTime, endTime, EndPoints.hpList)
    return result
  }

  static async loadIntensity (startTime, endTime) {
    const result = DatasetService.loadDatasetInternal(startTime, endTime, EndPoints.intensityList)
    return result
  }

  static async loadPressure (startTime, endTime) {
    const result = DatasetService.loadDatasetInternal(startTime, endTime, EndPoints.pressureList)
    return result
  }

  static async loadHygro (startTime, endTime) {
    const result = DatasetService.loadDatasetInternal(startTime, endTime, EndPoints.hygroList)
    return result
  }

  static async loadMonitoring (startTime, endTime) {
    const params = {
      startTime: startTime,
      endTime: endTime
    }
    EndPoints.getMonitoring.prepare(params)
    const requestResult = await fetch(EndPoints.getMonitoring.url, EndPoints.getMonitoring.headers)
    const jsonResult = await requestResult.json()
    console.log(jsonResult)
    var result = {}
    result.datasetQT = DatasetHelper.createDatasetArray(jsonResult.qtErrorPointsAdded)
    result.datasetN = DatasetHelper.createDatasetArray(jsonResult.nerrorPointsAdded)
    result.datasetD = DatasetHelper.createDatasetArray(jsonResult.derrorPointsAdded)
    result.datasetC = DatasetHelper.createDatasetArray(jsonResult.cerrorPointsAdded)
    return result
  }

  static async loadEnergyOnYear () {
    EndPoints.energyOnYear.prepare({})
    const requestResult = await fetch(EndPoints.energyOnYear.url, EndPoints.energyOnYear.headers)
    const jsonResult = await requestResult.json()
    return DatasetHelper.createBarForYearDatasetArray(jsonResult)
  }

  static async loadDatasetInternal (startTime, endTime, endpoint) {
    const params = {
      startTime: startTime,
      endTime: endTime
    }
    endpoint.prepare(params)
    const requestResult = await fetch(endpoint.url, endpoint.headers)
    const jsonResult = await requestResult.json()
    return DatasetHelper.createDatasetArray(jsonResult)
  }
}
export default DatasetService
