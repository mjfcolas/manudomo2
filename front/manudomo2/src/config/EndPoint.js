class EndPoint {
  url
  headers

  constructor (url, method, contentType, auth) {
    this.urlString = url
    this.url = new URL(url)
    this.method = method
    this.contentType = contentType
    this.auth = auth
  }

  prepare (params) {
    const headers = {
      method: this.method,
      headers: {
        'Accept': this.contentType,
        'Content-Type': this.contentType
      }
    }
    if (this.method === 'POST') {
      headers.body = JSON.stringify(params)
    } else if (this.method === 'GET') {
      this.url = new URL(this.urlString)
      Object.keys(params).forEach(key => this.url.searchParams.append(key, params[key]))
    }
    if (this.auth) {
      headers.headers['Authorization'] = localStorage.jwtToken
    }
    this.headers = headers
  }
}
export default EndPoint
