<template>
<v-main>
    <v-app>
        <img
          alt="Legis logo"
          src="https://cdn-icons-png.flaticon.com/512/924/924954.png"
        />
        <v-list-item class="options" v-for="user of $store.state.users.users" :key="user.id" @click="goToChat(user)">
            <v-list-item-title>
                {{ user.name }}
            </v-list-item-title>
        </v-list-item>
    </v-app>
</v-main>
</template>

<script>
export default {
    methods: {
        goToChat(user) {
            this.$router.push(`/home/${user.id}`)
        }
    }
}
</script>

<style>

.options {
    margin: 0 auto;
   /* margin-bottom: 20px;
    margin-top: 10px;*/
}


img {
  width: 200px;
  margin: 0 auto;
  margin-bottom: 100px;
  margin-top: 100px;
}

</style>