class RequestHelper {
  isSuccess (response) {
    return response.status === 200
  }
}
export default new RequestHelper()
