<template>
  <div class="min-h-screen flex flex-col">
    <header class="sticky top-0 z-50">
      <nav class="h-20 bg-purple-500 p-4 flex items-center">
        <NuxtLink to="/">
          <img src="~/assets/logo.png" alt="Tickets4Tonight" class="h-14">
          <!-- <div class="flex uppercase items-center text-yellow-400 font-medium gap-1">
            <span class="text-3xl">Tickets</span>
            <span class="leading-4 text-sm">
              For<br>
              Tonight
            </span>
          </div> -->
        </NuxtLink>
      </nav>
    </header>
    <main class="flex-grow px-8 py-4 flex flex-col">
      <slot />
    </main>
  </div>
</template>

<script>
export default {
  setup() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
</style>