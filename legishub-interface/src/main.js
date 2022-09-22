import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import Vuex from "vuex";
import VuexPersistence from "vuex-persist";
import VueRouter from "vue-router";
import Chats from "./pages/Chats.vue";
import Messages from "./pages/Messages.vue";
import Login from "./pages/Login.vue";
import { auth, firestore, timestamp } from "./config/firebase.js";
import axios from "axios";

Vue.use(Vuex);
Vue.use(VueRouter);

const chat = {
  namespaced: true,
  state: {
    messages: [],
  },
  actions: {
    // eslint-disable-next-line no-unused-vars
    async sendMessage({ commit }, payload) {
      try {
        payload.createdAt = timestamp;
        await firestore.collection("messages").add(payload);
        axios
          .post("http://localhost:8080/api/protocols", payload)
          .catch((e) => console.log("api down", e));
        console.log("mensagem enviada");
      } catch (error) {
        console.log(error);
      }
      // commit('addMessage', payload)
    },
  },
  mutations: {
    addMessage(state, messages) {
      state.messages.push(messages);
    },
  },
};

const users = {
  namespaced: true,
  state: {
    users: [
      {
        name: "Criar protocolo",
        id: 0,
      },
      {
        name: "Informações do Advogado",
        id: 1,
      },
      {
        name: "Gerenciar protocolos",
        id: 2,
      },
      {
        name: "Gerenciar Cartões",
        id: 3,
      },
    ],
    loggedUser: null,
  },
  actions: {
    async create({ commit }, payload) {
      const { email, password } = payload;
      auth
        .createUserWithEmailAndPassword(email, password)
        .then(async (res) => {
          const token = await res.user.getIdToken();
          console.log(token);
          axios
            .post("http://localhost:8080/sessions", token)
            .catch((e) => console.log("api down", e));
          axios
            .post("http://localhost:8082/api/wallet/cards", {
              login: res.user.email,
              bandeira: "VISA",
              numero: "54654564",
              codigo: 232,
              validade: 2027,
            })
            .catch((e) => console.log("api down", e));
          commit("setUser", res.user);
          router.push("/home");
        })
        .catch((err) => {
          console.error(err);
          alert(err.message);
          return false;
        });
    },

    async authenticate({ commit }, payload) {
      const { email, password } = payload;
      auth
        .signInWithEmailAndPassword(email, password)
        .then(async (res) => {
          const token = await res.user.getIdToken();
          console.log(token);
          axios
            .post("http://localhost:8081/api/sessions", token)
            .catch((e) => console.log("api down", e));
          commit("setUser", res.user);
          router.push("/home");
        })
        .catch((err) => {
          console.log(err);
          alert(err.message);
        });
    },
  },
  mutations: {
    setUser(state, user) {
      state.loggedUser = user;
    },
  },
};

const store = new Vuex.Store({
  modules: {
    users: users,
    chat: chat,
  },
  plugins: [new VuexPersistence().plugin],
});

const routes = [
  {
    path: "/",
    component: Login,
  },
  {
    path: "/home",
    component: Chats,
  },
  {
    path: "/home/:id",
    component: Messages,
  },
];

const router = new VueRouter({
  routes,
});

Vue.config.productionTip = false;

new Vue({
  vuetify,
  store,
  router,
  render: (h) => h(App),
}).$mount("#app");
