export default defineNuxtRouteMiddleware((to, from) => {
  if (process.client) {
    const { preferences } = usePreferencesStore();
    if (preferences.musicals.length < 3) return navigateTo('/onboarding/favourite-musicals');
    if (preferences.actors.length < 3) return navigateTo('/onboarding/favourite-actors');
  }
  return true;
})