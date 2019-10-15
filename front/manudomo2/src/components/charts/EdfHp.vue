<script>
import BaseChart from '@/components/charts/BaseChart'
import DatasetService from '@/services/DatasetService'
import { EventBus } from '@/helpers/eventBus.js'

export default {
  name: 'edf-hp',
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
        borderColor: 'rgba(234,75,7,0.5)',
        backgroundColor: 'rgba(234,75,7,0.1)',
        label: 'Indexs EDF HP (Wh)',
        data: []
      }
      DatasetService.loadEdfHp(this.$store.state.startTime, this.$store.state.endTime).then(x => {
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
