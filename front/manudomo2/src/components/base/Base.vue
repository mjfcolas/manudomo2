<script>
import LoggedUser from '@/auth/LoggedUser'
import { EventBus } from '@/helpers/eventBus.js'

export default {
  name: 'base',
  data () {
    return {
      isGranted: false
    }
  },
  mounted: function () {
    this.isGranted = LoggedUser.isLogged()
    EventBus.$on('login-changed', this.changeLoginState)
  },
  destroyed: function () {
    EventBus.$off('login-changed', this.changeLoginState)
  },
  methods: {
    changeLoginState: function () {
      this.isGranted = LoggedUser.isLogged()
    }
  }
}
</script>
