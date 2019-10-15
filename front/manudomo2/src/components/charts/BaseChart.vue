<template>
  <div :class="{'hidden':!isGranted}">
    <canvas :id='chartId' class='chart'></canvas>
  </div>
</template>

<script>
import Chart from 'chart.js'
import Base from '@/components/base/Base'
import store from '@/main'

export default {
  name: 'base-chart',
  extends: Base,
  data () {
    return {
      datacollection: null,
      chartId: `canvas-${this.$store.getters.idCounter(store)}`,
      chart: null,
      chartCreated: false
    }
  },
  methods: {
    createChart (datasets, custOptions) {
      if (!this.chartCreated) {
        var options = {
          type: 'scatter',
          data: {
            datasets: datasets
          },
          options: {
            elements: {
              line: {
                tension: 0
              }
            },
            showLines: true,
            scales: {
              xAxes: [{
                type: 'time'
              }]
            }
          }
        }
        if (custOptions) {
          options = custOptions
        }
        this.chart = new Chart(this.chartId, options)
        this.chartCreated = true
      } else {
        this.chart.data.datasets = datasets
        this.chart.update()
      }
    }
  }
}
</script>
<style>
.chart{
  width:100px;
  height: 20px;
}
</style>
