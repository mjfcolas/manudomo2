<template>
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <dates></dates>
      </div>
    </div>
    <div class="row">
        <div class="col-md-2">
            QT Error rate:
        </div>
        <div class="col-md-1 value">
          {{monitoringVm.qtErrorRate | round }}
        </div>
        <div class="col-md-2">
            N Error rate:
        </div>
        <div class="col-md-1 value">
          {{monitoringVm.nErrorRate | round }}
        </div>
        <div class="col-md-2">
            D Error rate:
        </div>
        <div class="col-md-1 value">
          {{monitoringVm.dErrorRate | round }}
        </div>
        <div class="col-md-2">
            C Error rate:
        </div>
        <div class="col-md-1 value">
          {{monitoringVm.cErrorRate | round }}
        </div>
    </div>
    <div class="row">
      <div class="col-md-12">
        <error-chart></error-chart>
      </div>
    </div>
  </div>
</template>

<script>
import Base from '@/components/base/Base'
import ErrorChart from '@/components/charts/ErrorChart'
import Dates from '@/components/dates/Dates'
import MonitoringService from '@/services/MonitoringService'
import { EventBus } from '@/helpers/eventBus.js'

export default {
  name: 'monitoring',
  extend: Base,
  components: {
    ErrorChart,
    Dates
  },
  data () {
    return {
      monitoringVm: {}
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
      MonitoringService.load(this.$store.state.startTime, this.$store.state.endTime).then(x => {
        this.monitoringVm = x
      })
    }
  }
}
</script>
<style>
.value{
  font-weight: bolder;
}
</style>
