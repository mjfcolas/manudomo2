<template>
  <span :class="{'hidden':!isGranted}" id="generic-infos">
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <datetime v-model="startTime" format="dd/LL/yyyy T" type="datetime"></datetime>
        </div>
        <div class="col-sm-4">
          <datetime v-model="endTime" format="dd/LL/yyyy T" type="datetime"></datetime>
        </div>
        <div class="col-sm-1">
          <input type="button" value="Afficher" class="btn btn-primary" id="display-button" @click="load"/>
        </div>
      </div>
    </div>
  </span>
</template>

<script>
import Base from '@/components/base/Base'
import 'vue-datetime/dist/vue-datetime.css'
import {Datetime} from 'vue-datetime'
import {EventBus} from '@/helpers/eventBus.js'
import DateHelper from '@/helpers/DateHelper.js'
import store from '@/main'

export default {
  name: 'dates',
  extends: Base,
  components: { datetime: Datetime },
  data () {
    return {
      startTime: DateHelper.formatDate(DateHelper.removeDays(new Date(), 1)),
      endTime: DateHelper.formatDate(new Date())
    }
  },
  mounted: function () {
    this.load()
  },
  methods: {
    load: function () {
      store.commit('setStartTime', this.startTime)
      store.commit('setEndTime', this.endTime)
      EventBus.$emit('do-display')
    }
  }
}
</script>
