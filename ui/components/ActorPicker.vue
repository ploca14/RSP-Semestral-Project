<template>
  <div
    class="bg-gray-100 px-4 py-1.5 rounded-full overflow-hidden whitespace-nowrap text-ellipsis"
    :class="[selected ? 'bg-purple-500 text-white' : 'bg-gray-100']"
    @click="emit('select', actor)"
  >
    {{ actor.name }}
  </div>
</template>

<script setup lang="ts">
import { Actor } from "~~/models/actor.model";

const props = defineProps<{
  actor: Actor,
  selected: boolean
}>();

const emit = defineEmits(['select'])
</script>

<style scoped>

</style>