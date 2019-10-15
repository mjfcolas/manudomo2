class DateHelper {
  static formatDate (d, format) {
    format = format || 'yyyy-MM-ddThh:mm:ss.SSSZ'
    var dd = ('0' + d.getDate()).slice(-2)
    var MM = ('0' + (d.getMonth() + 1)).slice(-2)
    var yyyy = d.getFullYear()
    var hh = ('0' + d.getHours()).slice(-2)
    var mm = ('0' + d.getMinutes()).slice(-2)
    var ss = ('0' + d.getSeconds()).slice(-2)
    var SSS = ('00' + d.getMilliseconds()).slice(-3)

    var dateString = format.replace('dd', dd)
    dateString = dateString.replace('MM', MM)
    dateString = dateString.replace('yyyy', yyyy)
    dateString = dateString.replace('hh', hh)
    dateString = dateString.replace('mm', mm)
    dateString = dateString.replace('ss', ss)
    dateString = dateString.replace('SSS', SSS)
    return dateString
  }

  static removeDays (d, days) {
    d.setDate(d.getDate() - days)
    return d
  }
}
export default DateHelper
