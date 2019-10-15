<template>
  <div class="home container">
    <div class="row">
      <div class="col-md-12">
        <monitoring></monitoring>
      </div>
    </div>
  </div>
</template>

<script>
import Monitoring from '@/components/monitoring/Monitoring'

export default {
  name: 'monitoringPage',
  components: {
    Monitoring
  },
  data () {
    return {
    }
  }
}
</script>
