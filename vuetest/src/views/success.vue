<template>
  <div>Welcome{{msg}}</div>
</template>

<script>
export default {
  data(){
    return {
    msg: this.$route.query.data
    };
  }
}
</script>
