import Vue from 'vue'

Vue.filter('round', x => {
  if (!x) {
    return ''
  }
  return x.toFixed(2)
})
