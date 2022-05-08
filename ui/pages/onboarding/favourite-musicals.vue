<template>
  <div class="max-w-screen-xl mx-auto">
    <h1 class="text-xl font-medium text-purple-800 sticky top-20 py-4 -mt-4 bg-white z-20">
      Vyberte alespoň 3 muzikály, které se vám líbí:
    </h1>
    <client-only>
      <div class="grid gap-4 grid-cols-2 lg:grid-cols-4 mb-6">
        <musical-picker
          v-for="musical in musicals"
          :key="musical.name"
          :musical="musical"
          :selected="isSelected(musical)"
          @select="handleSelection(musical)"
        />
      </div>
      <div v-if="error" class="text-red-500 text-center mb-4">
        {{ error }}
      </div>
      <div class="flex justify-end mb-4">
        <NuxtLink
          :to="error ? null : '/onboarding/favourite-actors'"
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
            v-for="musical in musicals"
            :key="musical.id"
            height="150"
            class="rounded-xl"
          />
        </div>
      </template>
    </client-only>
  </div>
</template>

<script setup lang="ts">
import { Musical, generateFakeData } from "~~/models/musical.model";
import 'vue-skeletor/dist/vue-skeletor.css';
import { Skeletor } from 'vue-skeletor';

const { data } = await useAsyncData('musicals', () => GqlMusicals(null, { accept: 'application/json' }));
const musicals = ref(data.value.musicals as Musical[]);

const { preferences, addMusical, removeMusical } = usePreferencesStore();

const isSelected = (musical: Musical) => {
  return preferences.musicals.some(m => m === Number(musical.id))
}

const handleSelection = (musical: Musical) => {
  if (isSelected(musical)) {
    return removeMusical(musical);
  }

  addMusical(musical);
}

const error = computed(() => {
  if (preferences.musicals.length < 2) {
    return `Vyberte ještě alespoň ${3 - preferences.musicals.length} muzikály`
  }

  if (preferences.musicals.length < 3) {
    return 'Vyberte ještě alespoň 1 muzikál'
  }

  return null
});

definePageMeta({
  alias: "/onboarding",
});
</script>