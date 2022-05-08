<template>
  <toggle-pill
    :selected="selected"
    @select="emit('select', actor)"
  >
    {{ `${actor.firstName} ${actor.lastName}` }}
  </toggle-pill>
</template>

<script setup lang="ts">
import { Actor } from "~~/models/actor.model";

const { actor, selected = false } = defineProps<{
  actor: Actor,
  selected?: boolean
}>();

const emit = defineEmits(['select'])
</script>

<style scoped>

</style>