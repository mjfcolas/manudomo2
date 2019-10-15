<script>
import BaseChart from '@/components/charts/BaseChart'
import MonitoringService from '@/services/MonitoringService'
import { EventBus } from '@/helpers/eventBus.js'

export default {
  name: 'error-chart',
  extends: BaseChart,
  mounted () {
    this.load()
    EventBus.$on('do-display', this.load)
  },
  destroyed: function () {
    EventBus.$off('do-display', this.load)
  },
  methods: {
    load: function () {
      var datasetQT = {
        borderColor: 'rgba(255,0,0,0.5)',
        backgroundColor: 'rgba(255,255,255,0)',
        label: 'QT Errors',
        data: []
      }
      var datasetN = {
        borderColor: 'rgba(0,0,255,0.5)',
        backgroundColor: 'rgba(255,255,255,0)',
        label: 'N Errors',
        data: []
      }
      var datasetD = {
        borderColor: 'rgba(0,255,0,0.5)',
        backgroundColor: 'rgba(255,255,255,0)',
        label: 'D Errors',
        data: []
      }

      var datasetC = {
        borderColor: 'rgba(0,255,255,0.5)',
        backgroundColor: 'rgba(255,255,255,0)',
        label: 'C Errors',
        data: []
      }
      const options = {
        type: 'scatter',
        data: {
          datasets: [datasetQT, datasetN, datasetD, datasetC]
        },
        options: {
          elements: {
            line: {
              tension: 0
            }
          },
          scales: {
            xAxes: [{
              type: 'time'
            }],
            yAxes: [{
              ticks: {
                beginAtZero: true
              }
            }]
          }
        }
      }

      MonitoringService.load(this.$store.state.startTime, this.$store.state.endTime).then(x => {
        datasetQT.data = x.datasetQT
        datasetQT.pointRadius = 1
        datasetQT.pointBorderWidth = 4

        datasetN.data = x.datasetN
        datasetN.pointRadius = 1
        datasetN.pointBorderWidth = 4

        datasetD.data = x.datasetD
        datasetD.pointRadius = 1
        datasetD.pointBorderWidth = 4

        datasetC.data = x.datasetC
        datasetC.pointRadius = 1
        datasetC.pointBorderWidth = 4
        this.createChart([datasetQT, datasetN, datasetD, datasetC], options)
      })
    }
  }
}
</script>

<style>
</style>
