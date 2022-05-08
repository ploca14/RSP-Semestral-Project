<template>
  <section class="bg-gray-100 rounded mt-12 py-8">
    <swiper
      :modules="[Pagination]"
      :pagination="{ clickable: true, el: '#pagination' }"
      :space-between="50"
    >
      <swiper-slide class="p-4">
        <h1 class="text-xl font-medium text-purple-700 mb-4">
          Nevíte na co se podívat?
        </h1>
        <p class="mb-4">
          Vyplňte náš dotazník a nechte si doporučit nejlepší muzikály pro Vás.
        </p>
      <div class="flex justify-end mb-8">
          <NuxtLink
            to="/onboarding"
            class="py-2.5 px-6 bg-yellow-500 rounded font-medium"
          >
            Spustit
          </NuxtLink>
        </div>
        <img src="~/assets/press_play.svg" alt="">
      </swiper-slide>
      <swiper-slide class="p-4">
        <h1 class="text-xl font-medium text-purple-700 mb-4">
          Nepotřebuji poradit.
        </h1>
        <p class="mb-4">
          Zobrazte si celou nabídku muzikálů ve Vašem okolí.
        </p>
        <div class="flex justify-end mb-8">
          <NuxtLink
            to="/"
            class="py-2.5 px-6 bg-yellow-500 rounded font-medium"
          >
            Zobrazit
          </NuxtLink>
        </div>
        <img src="~/assets/searching.svg" alt="">
      </swiper-slide>
    </swiper>
    <div class="flex justify-center mt-4">
      <div>
        <div id="pagination"></div>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">
import { Pagination } from 'swiper';
import { Swiper, SwiperSlide } from 'swiper/vue';
import { defineComponent } from 'vue';

import 'swiper/css';
import 'swiper/css/pagination';
</script>

<style scoped>
section {
  --swiper-pagination-bullet-size: 12px
}
</style>