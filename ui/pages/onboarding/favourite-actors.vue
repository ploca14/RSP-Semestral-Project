<template>
  <div class="max-w-screen-xl mx-auto">
    <h1 class="text-xl font-medium text-purple-800 sticky top-20 py-4 -mt-4 bg-white z-20">
      Vyberte alespoň 3 oblíbené herce:
    </h1>
    <client-only>
      <div class="grid gap-4 grid-cols-2 lg:grid-cols-4 mb-6">
        <actor-picker
          v-for="actor in actors"
          :key="actor.id"
          :actor="actor"
          :selected="isSelected(actor)"
          @select="handleSelection(actor)"
        />
      </div>
      <div v-if="error" class="text-red-500 text-center mb-4">
        {{ error }}
      </div>
      <div class="flex justify-end mb-4">
        <NuxtLink
          to="/onboarding/favourite-musicals"
          class="py-2.5 px-6 font-medium"
        >
          Zpět
        </NuxtLink>
        <NuxtLink
          :to="error ? null : '/onboarding/with-children'"
          class="py-2.5 px-6 rounded font-medium"
          :class="[error ? 'bg-yellow-200 text-gray-600' : 'bg-yellow-500']"
        >
          Pokračovat
        </NuxtLink>
      </div>
      <template #fallback>
          <!-- this will be rendered on server side -->
          <div class="grid gap-4 grid-cols-2 lg:grid-cols-4">
            <skeletor
              v-for="actor in actors"
              :key="actor.id"
              height="36"
              pill
            />
          </div>
        </template>
    </client-only>
  </div>
</template>

<script setup lang="ts">
import { Actor } from 'models/actor.model'
import 'vue-skeletor/dist/vue-skeletor.css';
import { Skeletor } from 'vue-skeletor';

const { data } = await useAsyncData('actors', () => GqlActors(null, { accept: 'application/json' }));
const actors = ref(data.value.actors as Actor[]);

const { preferences, addActor, removeActor } = usePreferencesStore();
    
const isSelected = (actor: Actor) => {
  return preferences.actors.some(a => a === Number(actor.id));
}

const handleSelection = (actor: Actor) => {
  if (isSelected(actor)) {
    return removeActor(actor);
  }

  addActor(actor);
}

const error = computed(() => {
  if (preferences.actors.length < 3) {
    return `Vyberte ještě alespoň ${3 - preferences.actors.length} herce`
  }

  return null
});
</script>