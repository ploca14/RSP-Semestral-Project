<template>
  <div>
    <h1 class="text-2xl font-medium text-purple-800 sticky top-20 py-4 -mt-4 bg-white z-20 flex items-center">
      <NuxtLink
        to="/"
        class="text-md mr-3 inline-grid place-items-center"
      >
        <arrow-left-icon class="h-6 w-6 inline" />
      </NuxtLink>
      Nabídka
    </h1>

    <template v-if="pending">
      <div class="flex gap-4">
        <skeletor
          width="60"
          height="24"
        />
        <skeletor
          width="70"
          height="24"
        />
      </div>
    </template>
    <template v-else>
      <sort-menu
        class="mb-2"
        v-model:price="sortByPrice"
        v-model:date="sortByDate"
        @sort="handleSort"
      />
    </template>

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
import { ArrowLeftIcon } from '@heroicons/vue/outline';

const musicals = ref(null);

import State from '../../models/sort.enum';
const sortByPrice = ref(State.No);
const sortByDate = ref(State.No); 

const { data, pending } = useLazyAsyncData('musicalsAll', () => {
  return GqlMusicals({limit: 9999}, { accept: 'application/json' })
}, { server: false, initialCache: false });
watch(data, (value) => {
  musicals.value = value.musicals;
})

const handleSortByPrice = async (ids) =>{
  const ascending = Boolean(sortByPrice.value);
  const { sortMusicalsByPrice } = await GqlSortMusicalsByPrice({sortInput: {musicals: ids, ascending}}, { accept: 'application/json' })
  musicals.value = sortMusicalsByPrice;
};

const handleSortByDate = async (ids) =>{ 
  const ascending = Boolean(sortByDate.value);
  const { sortMusicalsByDate } = await GqlSortMusicalsByDate({sortInput: {musicals: ids, ascending}}, { accept: 'application/json' })
  musicals.value = sortMusicalsByDate;
};

const handleUnsorted = async () => {
  const { musicals: result } = await GqlMusicals({limit: 9999}, { accept: 'application/json' })
  musicals.value = result;
}

const handleSort = () => {
  const ids = musicals.value.map((m) => m.id);
  if (sortByPrice.value != State.No) return handleSortByPrice(ids);
  if (sortByDate.value != State.No) return handleSortByDate(ids);
  handleUnsorted();
}

definePageMeta({
  middleware: ['validate']
})

</script>
