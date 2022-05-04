<template>
  <div class="flex-grow flex flex-col">
    <div class="flex-grow">
      <NuxtPage />
    </div>
    <div
      class="pt-4 pb-6 flex gap-4 justify-evenly sticky bottom-0 -mb-4 bg-white z-50"
    >
      <NuxtLink
        v-for="(step, i) in steps"
        :key="i"
        :to="step.link"
        class="bg-purple-300 h-12 w-12 rounded-full grid place-items-center"
        exactActiveClass="!bg-yellow-500"
      >
        <component :is="step.icon" class="h-6 w-6"></component>
      </NuxtLink>
    </div>
  </div>
</template>

<script setup lang="ts">
import { StarIcon, UserGroupIcon } from "@heroicons/vue/outline";
import { useScroll } from "@vueuse/core";

const steps = ref([
  {
    link: "/onboarding/favourite-musicals",
    icon: StarIcon,
  },
  {
    link: "/onboarding/favourite-actors",
    icon: UserGroupIcon,
  },
  {
    link: null,
    icon: null,
  },
  {
    link: null,
    icon: null,
  },
  {
    link: null,
    icon: null,
  },
]);
</script>

<style scoped>
</style>