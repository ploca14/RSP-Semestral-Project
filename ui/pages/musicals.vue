<template>
  <div>
    <h1 class="text-xl font-medium text-purple-800 sticky top-20 py-4 -mt-4 bg-white z-20">
      Nabídka
    </h1>
    <template v-if="pending">
      <div class="divide-y">
        <div
          v-for="i in 10"
          :key="i"
          class="flex justify-between items-center py-5"
        >
          <skeletor
            :width="Math.random() * 100 + 75"
            height="22"
            class="rounded-full"
          />
        </div>
      </div>
    </template>
    <template v-else>
      <div class="divide-y">
        <NuxtLink
          v-for="musical in musicals"
          :key="musical.id"
          class="flex justify-between items-center py-4"
          :to="`/musical/${musical.id}`"
        >
          {{ musical.name }}
          <span class="bg-purple-500 rounded-full px-3 py-1 text-white">
            Zobrazit
          </span>
        </NuxtLink>
      </div>
    </template>
  </div>
</template>

<script setup lang="ts">
import 'vue-skeletor/dist/vue-skeletor.css';
import { Skeletor } from 'vue-skeletor';

const { preferences } = usePreferencesStore();

const { data, pending } = useLazyAsyncData('musicalsByPreference', () => GqlMusicalsByPreference({preference: preferences}, { accept: 'application/json' }));
const musicals = computed(() => data.value?.musicalsByPreference)

definePageMeta({
  middleware: ['validate']
})

</script>
