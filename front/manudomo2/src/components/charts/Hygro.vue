<script>
import BaseChart from '@/components/charts/BaseChart'
import DatasetService from '@/services/DatasetService'
import { EventBus } from '@/helpers/eventBus.js'

export default {
  name: 'intensity',
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
      const dataset = {
        borderColor: 'rgba(7,75,234,0.5)',
        backgroundColor: 'rgba(7,75,234,0.1)',
        label: 'Pression relative (hPa)',
        data: []
      }
      DatasetService.loadPressure(this.$store.state.startTime, this.$store.state.endTime).then(x => {
        dataset.data = x
        dataset.pointRadius = 1
        dataset.pointBorderWidth = 1
        this.createChart([dataset])
      })
    }
  }
}
</script>

<style>
</style>
