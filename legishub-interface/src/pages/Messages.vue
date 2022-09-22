<template>
<v-main>
    <v-app-bar color="green">{{ firstName }}</v-app-bar>
    <div v-for="(message, index) in messages" :key="index" class="messages-container">
    <message-card :messageProp="message"/>
    </div>
    <bottom-bar @send-message="addMessage($event)"/>
</v-main>
</template>

<script>
import MessageCard from '../components/MessageCard.vue'
import BottomBar from '../components/BottomBar.vue'
// import { firestore } from '../config/firebase.js'
export default {
  components: {
    MessageCard,
    BottomBar
  },
  data() {
    return {
      messages: []
    }
  },
  computed: {
    firstName() {
      const user = this.$store.state.users.users.find(u => u.id === parseInt(this.$route.params.id))
      return user.name
    }
  },
  methods: {
    addMessage(event) {
      const newMessage = {
        name: this.$store.state.users.loggedUser.email,
        text: event.text,
        file: event.file || null,
        from: this.$store.state.users.loggedUser.uid,
        to: this.$route.params.id
      }
      console.log(newMessage)

      this.$store.dispatch('chat/sendMessage', newMessage)
    }
  }, 
  created() {
    /* firestore.collection('messages')
    .where('from', '==', this.$store.state.users.loggedUser.uid)
    .where('to', '==', this.$route.params.id)
    .orderBy('createdAt', 'desc')
    .onSnapshot(snap => {
      this.messages = []
      snap.forEach(doc => {
        this.messages.push(doc.data())
      })
    })*/
  }
}
</script>

<style>

</style>