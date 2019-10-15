class DatasetHelper {
  static createDatasetArray (datas) {
    const result = []
    for (var i = 0; i < datas.length; i++) {
      result.push({x: new Date(datas[i].date), y: datas[i].value})
    }
    return result
  }

  static createBarForYearDatasetArray (datas) {
    const result = []
    for (var i = 0; i < datas.length; i++) {
      let red = 255 * (i === 0 ? 1 : 0)
      let green = 255 * (i === 1 ? 1 : 0)
      let blue = 255 * (i === 2 ? 1 : 0)
      const dataset = {
        borderColor: 'rgba(' + red + ',' + green + ',' + blue + ',1)',
        backgroundColor: 'rgba(' + red + ',' + green + ',' + blue + ',0.5)',
        label: datas[i].year + '(Wh)',
        borderWidth: 1,
        data: []
      }
      for (var j = 0; j < 12; j++) {
        dataset.data.push(datas[i].values[j])
      }
      result.push(dataset)
    }
    return result
  }
}
export default DatasetHelper
