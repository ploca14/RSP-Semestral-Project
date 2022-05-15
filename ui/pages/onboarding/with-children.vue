<template>
  <div class="max-w-screen-xl mx-auto">
    <img src="~/assets/child.svg" alt="" class="my-28">
    <h1 class="text-xl font-medium text-purple-800 sticky top-20 py-4 -mt-4 bg-white z-20">
      Chodíte na muzikály s dětmi?
    </h1>
    <div class="grid grid-cols-2 gap-8 mb-8">
      <toggle-pill
        :selected="preferences.withChildren"
        @select="handleYes"
      >
        Ano
      </toggle-pill>
      <toggle-pill
        :selected="!preferences.withChildren"
        @select="handleNo"
      >
        Ne
      </toggle-pill>
    </div>
    <div class="flex justify-end mb-4">
      <NuxtLink
        to="/onboarding/favourite-actors"
        class="py-2.5 px-6 font-medium"
      >
        Zpět
      </NuxtLink>
      <NuxtLink
        to="/musicals"
        class="bg-yellow-500 py-2.5 px-6 rounded font-medium"
        @click.native="handleClick"
      >
        Dokončit
      </NuxtLink>
    </div>
  </div>
</template>

<script setup lang="ts">
const { preferences, setWithChildren, setIsOnboardingFinished } = usePreferencesStore();

const handleYes = () => {
  setWithChildren(true);
};


const handleNo = () => {
  setWithChildren(false);
};

const handleClick = () => {
  setIsOnboardingFinished(true);
};
</script>