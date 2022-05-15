<template>
  <component :is="icon" class="h-3 w-3" />
</template>

<script setup lang="ts">
import { SwitchVerticalIcon, ArrowSmUpIcon, ArrowSmDownIcon } from '@heroicons/vue/outline'
import State from '../models/sort.enum';

const props = defineProps<{
  state: State
}>();

const icon = computed(() => {
  const component = {
    0: ArrowSmDownIcon,
    1: ArrowSmUpIcon,
    2: SwitchVerticalIcon,
  };

  return component[props.state];
})
</script>
