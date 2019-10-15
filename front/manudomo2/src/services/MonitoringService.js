import EndPoints from '@/config/EndPoints'
import DatasetHelper from '@/helpers/DatasetHelper'

class MonitoringService {
  static async load (startTime, endTime) {
    const params = {
      startTime: startTime,
      endTime: endTime
    }
    EndPoints.getMonitoring.prepare(params)
    const requestResult = await fetch(EndPoints.getMonitoring.url, EndPoints.getMonitoring.headers)
    const jsonResult = await requestResult.json()
    var result = {}
    result.datasetQT = DatasetHelper.createDatasetArray(jsonResult.qtErrorPointsAdded)
    result.datasetN = DatasetHelper.createDatasetArray(jsonResult.nerrorPointsAdded)
    result.datasetD = DatasetHelper.createDatasetArray(jsonResult.derrorPointsAdded)
    result.datasetC = DatasetHelper.createDatasetArray(jsonResult.cerrorPointsAdded)
    result.qtErrorRate = jsonResult.qtErrorNumber / jsonResult.qtSuccessNumber
    result.nErrorRate = jsonResult.nErrorNumber / jsonResult.nSuccessNumber
    result.dErrorRate = jsonResult.dErrorNumber / jsonResult.dSuccessNumber
    result.cErrorRate = jsonResult.cErrorNumber / jsonResult.cSuccessNumber
    return result
  }
}
export default MonitoringService
