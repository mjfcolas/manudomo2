<template>
  <div :class="{'hidden':!isGranted}">
    <canvas :id='chartId' class='chart'></canvas>
  </div>
</template>

<script>
import DatasetService from '@/services/DatasetService'
import { EventBus } from '@/helpers/eventBus.js'
import Base from '@/components/base/Base'
import Chart from 'chart.js'

export default {
  name: 'energy-on-year',
  extends: Base,
  data () {
    return {
      chartCreated: false,
      chartId: 'energy-on-year-chart'
    }
  },
  mounted () {
    this.load()
    EventBus.$on('do-display', this.load)
  },
  destroyed: function () {
    EventBus.$off('do-display', this.load)
  },
  methods: {
    load: function () {
      DatasetService.loadEnergyOnYear().then(x => {
        console.log(x)
        this.createChart(x)
      })
    },
    createChart (datasets) {
      if (!this.chartCreated) {
        const options = {
          type: 'bar',
          data: {
            labels: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
            datasets: datasets
          }
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
</style>
