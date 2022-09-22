<template>
  <v-app>
    <img
      alt="Legis logo"
      src="https://cdn-icons-png.flaticon.com/512/924/924954.png"
    />
    <v-form class="login">
      <v-text-field label="Login" v-model="emailField" clearable />
      <v-text-field
        label="Password"
        v-model="passwordField"
        :type="'password'"
        hint="Senha deve ter pelo menos 6 characters"
      />
      <v-btn @click="login"> Log in </v-btn>
      <v-btn>
        <v-icon>
          mdi-google
        </v-icon>
      </v-btn>
      <v-dialog v-model="dialog" width="500">
        <template v-slot:activator="{ on, attrs }">
          <v-btn color="red lighten-2" dark v-bind="attrs" v-on="on">
            criar nova conta
          </v-btn>
        </template>
        <v-card>
          <v-card-title class="text-h5 grey lighten-2">
            Criar nova conta
          </v-card-title>

          <v-text-field
            label="Digite seu email"
            v-model="emailField"
            clearable
            style="margin: 20px;"
          />
          <v-text-field
            label="Digite sua senha"
            v-model="passwordField"
            :type="'password'"
            hint="Senha deve ter pelo menos 6 characters"
            style="margin: 20px;"
          />
          <v-btn @click="createAcc"> Criar </v-btn>

          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="red" text @click="dialog = false">
              Cancelar
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-form>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      emailField: "",
      passwordField: "",
      dialog: false
    };
  },
  methods: {
    async login() {
      console.log("tentando logar com as credenciais");
      this.$store.dispatch("users/authenticate", {
        email: this.emailField,
        password: this.passwordField
      })
    },
    async createAcc() {
      console.log("tentando criar nova conta");
      this.$store.dispatch("users/create", {
        email: this.emailField,
        password: this.passwordField
      })
    }
  }
};
</script>

<style scoped>
.login {
  width: 600px;
  margin: 0 auto;
}
img {
  width: 200px;
  margin: 0 auto;
  margin-bottom: 200px;
  margin-top: 100px;
}
button {
  margin: 10px;
}</style
>>
