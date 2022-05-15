<template>
  <div
    class="px-4 py-1.5 rounded-full overflow-hidden whitespace-nowrap text-ellipsis text-center"
    :class="[selected ? 'bg-purple-500 text-white' : 'bg-gray-100']"
    @click="emit('select')"
  >
    <slot />
  </div>
</template>

<script setup lang="ts">

const { selected = false } = defineProps<{
  selected?: boolean
}>();

const emit = defineEmits(['select'])
</script>
