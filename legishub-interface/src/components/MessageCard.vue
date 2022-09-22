<template>
    <v-card outlined class="ma-3" :class="messageProp.name == 'Eu' ? 'purple lighten-2' : 'teal accent-4'">
        <v-card-subtitle class="font-weight-bold">{{  messageProp.name }}</v-card-subtitle>
        <v-card-text>{{ messageProp.text}}</v-card-text>
    </v-card>
</template>

<script>
export default {
    props: {
        messageProp: {
            type: Object,
            required: true
        }
    }
}
</script>
