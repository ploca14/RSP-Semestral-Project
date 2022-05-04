<template>
  <div
    class="bg-gray-100 rounded-xl overflow-hidden grid cursor-pointer"
    @click="emit('select', musical)"
    
  >
    <div class="row-start-1 col-start-1 transition-opacity duration-100 ease-in-out" :class="{'opacity-10': selected}">
      <img
        :src="musical.imageSource"
        :alt="musical.name"
        class="aspect-video w-full object-cover"
      />
      <div class="p-4">
        <h3 class=" text-purple-500 font-medium capitalize">
          {{ musical.name }}
        </h3>
      </div>
    </div>
    <div v-if="selected" class="row-start-1 col-start-1 z-10 justify-self-center self-center">
      <svg xmlns="http://www.w3.org/2000/svg" class="h-12 w-12 text-purple-500" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
        <path stroke-linecap="round" stroke-linejoin="round" d="M5 13l4 4L19 7" />
      </svg>
    </div>
  </div>
</template>

<script setup lang="ts">
import { Musical } from "~~/models/musical.model"


const props = defineProps<{
  musical: Musical
  selected: boolean
}>()

const emit = defineEmits(['select'])
</script>

<style scoped>
* {
    -webkit-tap-highlight-color: transparent;
    -ms-touch-action: manipulation;
    touch-action: manipulation;
}
</style>