<template>
  <div class="home container">
      <div class="row">
        <div class="col-md-6">
          <dates></dates>
        </div>
        <div class="col-md-6">
          <general-infos></general-infos>
        </div>
      </div>
      <div class="row">
          <div class="col-md-6">
            <living-room-temp></living-room-temp>
          </div>
          <div class="col-md-6">
            <room-temp></room-temp>
          </div>
      </div>
      <div class="row">
          <div class="col-md-6">
            <pressure></pressure>
          </div>
          <div class="col-md-6">
            <hygro></hygro>
          </div>
      </div>
      <div class="row">
          <div class="col-md-6">
            <edf-hp></edf-hp>
          </div>
          <div class="col-md-6">
            <edf-hc></edf-hc>
          </div>
      </div>
      <div class="row">
          <div class="col-md-6">
            <intensity></intensity>
          </div>
          <div class="col-md-6">
            <energy-on-year></energy-on-year>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
import GeneralInfos from '@/components/generalInfos/GeneralInfos'
import LivingRoomTemp from '@/components/charts/LivingRoomTemp'
import RoomTemp from '@/components/charts/RoomTemp'
import Pressure from '@/components/charts/Pressure'
import Hygro from '@/components/charts/Hygro'
import EdfHp from '@/components/charts/EdfHp'
import EdfHc from '@/components/charts/EdfHc'
import Intensity from '@/components/charts/Intensity'
import EnergyOnYear from '@/components/charts/EnergyOnYear'
import Dates from '@/components/dates/Dates'
import Base from '@/components/base/Base'

export default {
  name: 'home',
  extend: Base,
  components: {
    GeneralInfos,
    LivingRoomTemp,
    RoomTemp,
    Pressure,
    Hygro,
    EdfHp,
    EdfHc,
    Intensity,
    EnergyOnYear,
    Dates},
  data () {
    return {
    }
  }
}
</script>
<style>
</style>
