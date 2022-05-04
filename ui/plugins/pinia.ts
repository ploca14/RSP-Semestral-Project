import { createNuxtPersistedState } from 'pinia-plugin-persistedstate'
import { defineNuxtPlugin } from '#app'
import { useLocalStorage } from '@vueuse/core'

export default defineNuxtPlugin(nuxtApp => {
  nuxtApp.$pinia.use(createNuxtPersistedState(useLocalStorage))
})