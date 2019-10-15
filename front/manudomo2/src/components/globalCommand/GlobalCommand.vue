<template>
  <div :class="{'hidden':!isGranted}">
    <div class="header-title">
      <div class="container">
        <div class="row">
          <div class="col-md-2">
            <span class="float-right">
              On/Off Chauffage
            </span>
          </div>
          <div class="col-md-1">
            <label class="switch">
              <input type="checkbox" v-model="comChauff">
              <span class="slider round"></span>
            </label>
          </div>
          <div class="col-md-2">
            <span class="float-right">
              Mode Horaire
            </span>
          </div>
          <div class="col-md-1">
            <label class="switch">
              <input type="checkbox" v-model="modeChauff">
              <span class="slider round"></span>
            </label>
          </div>
          <div class="col-md-2">
            <span class="float-right">
              Temp. générale
            </span>
          </div>
          <div class="col-md-2">
            <select v-model="globalTemperature">
              <option v-for="n in 30" :value="n">{{ n }}</option>
            </select>
          </div>
          <div class="col-md-2">
            <button type="button" class="btn btn-primary" @click="save">Sauvegarder</button>
          </div>
        </div>
        <div class="row">
          <div class="col-md-2">
            <span class="float-right">
              Heure de départ :
            </span>
          </div>
          <div class="col-md-1">
            <select v-model="startHour">
              <option v-for="n in this.startHourList" :value="n">{{n}}h</option>
            </select>
          </div>
          <div class="col-md-2">
            <span class="float-right">
              Heure de fin :
            </span>
          </div>
          <div class="col-md-1">
            <select v-model="endHour">
              <option v-for="n in this.endHourList" :value="n">{{n}}h</option>
            </select>
          </div>
          <div class="col-md-2">
            <span class="float-right">
              Température :
            </span>
          </div>
          <div class="col-md-1">
            <select v-model="profilTemp">
              <option v-for="n in 30" :value="n">{{ n }}</option>
            </select>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <div :class="{'hidden':!isGranted}">
              <canvas :id='chartId' class='chart'></canvas>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import NumberInputSpinner from 'vue-number-input-spinner'
import ProfilService from '@/services/ProfilService'
import Base from '@/components/base/Base'
import Chart from 'chart.js'
import { EventBus } from '@/helpers/eventBus.js'

export default {
  name: 'global-command',
  extends: Base,
  components: {
    NumberInputSpinner
  },
  data () {
    return {
      comChauff: false,
      modeChauff: false,
      globalTemperature: null,
      startHour: null,
      endHour: null,
      profilTemp: null,
      chartCreated: false,
      chart: null,
      chartId: 'temp-profile-chart'
    }
  },
  mounted () {
    this.load()
    EventBus.$on('do-display', this.load)
  },
  destroyed: function () {
    EventBus.$off('do-display', this.load)
  },
  computed: {
    startHourList: function () {
      let result = []
      const limit = this.endHour == null ? 24 : this.endHour
      for (let i = 0; i < limit; i++) {
        result.push(i)
      }
      return result
    },
    endHourList: function () {
      let result = []
      const limit = this.startHour == null ? 1 : this.startHour + 1
      for (let i = limit; i <= 24; i++) {
        result.push(i)
      }
      return result
    }
  },
  methods: {
    load: function () {
      let self = this
      ProfilService.load().then(x => {
        this.comChauff = x.comChauff
        this.modeChauff = x.modeChauff
        this.globalTemperature = x.globalTemperature
        self.drawProfile(x.hourTempMap)
      })
    },
    save: function () {
      const profil = {
        comChauff: this.comChauff,
        modeChauff: this.modeChauff,
        globalTemperature: this.globalTemperature,
        startHour: this.startHour,
        endHour: this.endHour,
        profilTemp: this.profilTemp
      }
      let self = this
      ProfilService.saveProfil(profil).then(x => {
        self.drawProfile(x.hourTempMap)
      })
    },
    drawProfile: function (profilMap) {
      const points = []
      Object.keys(profilMap).map(function (key, index) {
        let value = profilMap[key]
        points.push({x: Number(key), y: Number(value)})
        points.push({x: Number(key) + 1, y: Number(value)})
      })
      this.createChart(points)
    },
    createChart (dataset) {
      const datasetGraph = {
        borderColor: 'rgba(7,75,234,0.5)',
        backgroundColor: 'rgba(7,75,234,0.1)',
        label: 'Profil',
        data: dataset
      }
      if (!this.chartCreated) {
        const options = {
          type: 'scatter',
          data: {
            datasets: [datasetGraph]
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
                type: 'time',
                position: 'bottom'
              }],
              yAxes: [{
                ticks: {
                  beginAtZero: true
                }
              }]
            }
          }
        }
        this.chart = new Chart(this.chartId, options)
        this.chartCreated = true
      } else {
        this.chart.data.datasets = [datasetGraph]
        this.chart.update()
      }
    }
  }
}
</script>
<style>
.number-temp-input{
  width:80px;
}
.number-profil-input{
  width:60px;
}
.hour-line{
  padding-bottom:20px;
}
</style>
