<template>
  <div class="flex gap-4">
    <div @click="handleClick('price')" class="flex gap-1 items-center">
      Cena
      <sort-icon :state="price" />
    </div>
    <div @click="handleClick('date')" class="flex gap-1 items-center">
      Datum
      <sort-icon :state="date" />
    </div>
  </div>
</template>

<script setup lang="ts">
import State from '../models/sort.enum';

const props = defineProps<{
  price: State
  date: State
}>();

const emit = defineEmits([
  'update:price', 'update:date',
  'sort',
]);

const handleClick = (value) => {
  if (value == 'price') {
    emit('update:price', (props.price + 1) % 3)
    emit('update:date', 2)
    emit('sort')
  }
  if (value == 'date') {
    emit('update:date', (props.date + 1) % 3)
    emit('update:price', 2)
    emit('sort');
  }
};

</script>
