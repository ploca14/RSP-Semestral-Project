<template>
  <div class="py-4">
    <div
      class="flex items-center"
      @click="toggle"
    >
      <slot/>
      <chevron-up-icon v-if="isExpanded" class="h-6 w-6 ml-auto text-gray-500" />
      <chevron-down-icon v-else class="h-6 w-6 ml-auto text-gray-500" />
    </div>
    <div
      :class="{'hidden': !isExpanded}"
    >
      <slot name="content" />
    </div>
  </div>
</template>

<script setup>
import { useToggle } from "@vueuse/shared";
import { ChevronDownIcon, ChevronUpIcon } from "@heroicons/vue/outline";

const [isExpanded, toggle] = useToggle(false)
</script>
