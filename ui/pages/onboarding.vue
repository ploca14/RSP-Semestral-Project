<template>
  <div class="flex-grow flex flex-col">
    <div class="flex-grow">
      <NuxtPage />
    </div>
    <div
      class="pt-4 pb-6 flex gap-4 justify-evenly sticky bottom-0 -mb-4 bg-white z-50"
    >
      <div
        v-for="(step, i) in steps"
        :key="i"
        class="h-12 w-12 rounded-full grid place-items-center"
        :class="[isCurrent(step.name) ? 'bg-yellow-500' : 'bg-purple-300']"
      >
        <component :is="step.icon" class="h-6 w-6" />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { EmojiHappyIcon, StarIcon, UserGroupIcon } from "@heroicons/vue/outline";
import { useScroll } from "@vueuse/core";

const route = useRoute()

const steps = ref([
  {
    link: "/onboarding/favourite-musicals",
    icon: StarIcon,
    name: "onboarding-favourite-musicals"
  },
  {
    link: "/onboarding/favourite-actors",
    icon: UserGroupIcon,
    name: "onboarding-favourite-actors"
  },
  {
    link: "/onboarding/with-children",
    icon: EmojiHappyIcon,
    name: "onboarding-with-children"
  },
]);

const isCurrent = (routeName) => {
  return routeName === route.name;
}
</script>

<style scoped>
</style>