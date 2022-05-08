<template>
  <div>
    <h1 class="text-xl font-medium text-purple-800 mb-8">
      {{ musical.name }}
    </h1>
    <NuxtLink
      :to="musical.theatre.webURL"
      target="_blank"
      class="bg-yellow-500 py-2.5 px-6 rounded font-medium"
    >
      Koupit lístky 
    </NuxtLink>
  </div>
</template>

<script setup lang="ts">
const route = useRoute();
const id = route.params.id as string;

const { data } = await useAsyncData(id, () => GqlMusicalById({ id }, { accept: 'application/json' }));
const musical = data.value.musicalById;
</script>
