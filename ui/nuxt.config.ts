import gql from 'graphql-tag'
import { defineNuxtConfig } from 'nuxt'

// https://v3.nuxtjs.org/api/configuration/nuxt.config
export default defineNuxtConfig({
    modules: [
        '@nuxtjs/tailwindcss',
        '@pinia/nuxt',
        'nuxt-graphql-client',
    ],

    runtimeConfig: {
        public: {
            'graphql-client': {
                clients: {
                    default: {
                        host: 'http://localhost:8080/musicals/graphql', // overwritten by process.env.GQL_HOST 
                        headers: {
                            accept: 'application/json',
                        },
                    }
                }
            }
        },
    }
})
