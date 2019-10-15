<template>
  <span :class="{'hidden':!isGranted}" id="generic-infos">
    <div class="container">
      <div class="row">
        <div class="col-md-5">
          <span class="float-right">
            Température Salon (°C):
          </span>
        </div>
        <div class="col-md-1 value">
          {{generalInfosVm.livingRoomTemp | round }}
        </div>
        <div class="col-md-1">
        </div>
        <div class="col-md-3">
          <span class="float-right">
            Prix HP (€):
          </span>
        </div>
        <div class="col-md-2 value">
          {{generalInfosVm.hpPrice | round }}
        </div>
      </div>
      <div class="row">
        <div class="col-md-5">
          <span class="float-right">
            Température Chambre (°C):
          </span>
        </div>
        <div class="col-md-1 value">
          {{generalInfosVm.roomTemp | round }}
        </div>
        <div class="col-md-1">
        </div>
        <div class="col-md-3">
          <span class="float-right">
            Prix HC (€):
          </span>
        </div>
        <div class="col-md-2 value">
          {{generalInfosVm.hcPrice | round }}
        </div>
      </div>
      <div class="row">
        <div class="col-md-5">
          <span class="float-right">
            Pression relative (hPa):
          </span>
        </div>
        <div class="col-md-1 value">
          {{generalInfosVm.normPressure | round }}
        </div>
        <div class="col-md-1">
        </div>
        <div class="col-md-3">
          <span class="float-right">
            Hygrométrie(%):
          </span>
        </div>
        <div class="col-md-2 value">
          {{generalInfosVm.hygro | round }}
        </div>
      </div>
    </div>
  </span>
</template>

<script>
import Base from '@/components/base/Base'
import GeneralInfosService from '@/services/GeneralInfosService'
import { EventBus } from '@/helpers/eventBus.js'

export default {
  name: 'general-infos',
  extends: Base,
  data () {
    return {
      generalInfosVm: {}
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
      GeneralInfosService.load(this.$store.state.startTime, this.$store.state.endTime).then(x => {
        this.generalInfosVm = x
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
