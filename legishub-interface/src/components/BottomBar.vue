<template>
  <v-app-bar color="#424242" bottom fixed>
    <v-text-field @keyup.enter="send()" v-model="field" solo hide-details label="Número do processo..."></v-text-field>
      <v-file-input v-model="file" accept="document/pdf" label="Clique aqui para adicionar o arquivo" solo hide-details></v-file-input>
      <v-btn @click='fileMode = !fileMode' icon color="blue">
        <!-- <v-icon v-if="fileMode">mdi-file</v-icon>
        <v-icon v-else>mdi-text</v-icon> -->
      </v-btn>
    <v-btn @click="send()" x-large icon color="blue">
      <v-icon>mdi-send</v-icon>
    </v-btn>
  </v-app-bar>
</template>

<script>
// import axios from 'axios'
export default {
  data () {
    return {
      field: '',
      fileMode: false,
      file: null
    }
  },
  methods: {
    send() {
      let message = {
        numeroCnj: this.field,
        arquivo: this.file
      }
      this.$emit('send-message', message)
      // axios.post('', {message})
      this.field = ''
      this.file = null
    }
  }
}
</script>

<style scoped>
.message-card {
  border: 3px solid red
}
</style>