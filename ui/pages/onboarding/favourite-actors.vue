<template>
  <div class="max-w-screen-xl mx-auto">
    <h1 class="text-xl font-medium text-purple-800 sticky top-20 py-4 -mt-4 bg-white z-20">
      Vyberte své oblíbené herce:
    </h1>
    <div class="grid gap-4 grid-cols-2 lg:grid-cols-4">
      <actor-picker
        v-for="actor in actors"
        :key="actor.id"
        :actor="actor"
        :selected="isSelected(actor)"
        @select="handleSelection(actor)"
      >

      </actor-picker>

      
    </div>
  </div>
</template>

<script setup lang="ts">
import { Actor, generateFakeData } from "~~/models/actor.model";

const { preferences, addActor, removeActor } = usePreferencesStore();

const actors = useState('actors', () => Array.apply(null, Array(25)).map(generateFakeData))

const isSelected = (actor: Actor) => {
  return preferences.actors.some(a => a?.id === actor.id)
}

const handleSelection = (actor: Actor) => {
  if (isSelected(actor)) {
    return removeActor(actor);
  }

  addActor(actor);
}
</script>