<template>
  <div class="max-w-screen-xl mx-auto">
    <h1 class="text-xl font-medium text-purple-800 sticky top-20 py-4 -mt-4 bg-white z-20">
      Vyberte alespoň 3 muzikály, které se vám líbí:
    </h1>
    <div class="grid gap-4 grid-cols-2 lg:grid-cols-4">
      <musical-picker
        v-for="musical in musicals"
        :key="musical.name"
        :musical="musical"
        :selected="isSelected(musical)"
        @select="handleSelection(musical)"
      />
    </div>
  </div>
</template>

<script setup lang="ts">
import { Musical, generateFakeData } from "~~/models/musical.model";

const { preferences, addFavourite, removeFavourite } = usePreferencesStore();

const musicals = useState('musicals', () => Array.apply(null, Array(10)).map(generateFakeData))

const isSelected = (musical: Musical) => {
  return preferences.favourite.some(m => m?.id === musical.id)
}

const handleSelection = (musical: Musical) => {
  if (isSelected(musical)) {
    return removeFavourite(musical);
  }

  addFavourite(musical);
}

definePageMeta({
  alias: "/onboarding/favourite-musicals",
});
</script>