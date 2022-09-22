import firebase from 'firebase/app'
import 'firebase/firestore'
import 'firebase/auth'
import 'firebase/storage'

const firebaseConfig = {
  apiKey: "AIzaSyApBsrdjex7WzxaCu6oCcHkL_NnNvr80S4",
  authDomain: "school-20709.firebaseapp.com",
  databaseURL: "https://school-20709.firebaseio.com",
  projectId: "school-20709",
  storageBucket: "school-20709.appspot.com",
  messagingSenderId: "713454403407",
  appId: "1:713454403407:web:a6f1c55b59a68687a08f3a"
};

firebase.initializeApp(firebaseConfig)

export const firestore = firebase.firestore()
export const auth = firebase.auth()
export const storage = firebase.storage()
export const timestamp = firebase.firestore.FieldValue.serverTimestamp()