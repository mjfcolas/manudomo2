<template>
  <div class="home container">
      <div class="row">
        <div class="col-md-12">
          <global-command></global-command>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import GlobalCommand from '@/components/globalCommand/GlobalCommand'

export default {
  name: 'profil',
  components: {
    GlobalCommand},
  data () {
    return {
    }
  }
}
</script>
