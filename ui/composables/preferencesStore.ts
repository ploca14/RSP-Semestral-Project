import { acceptHMRUpdate, defineStore } from 'pinia'
import { Musical } from '~~/models/musical.model';
import { Actor } from '~~/models/actor.model';

export type PreferencesState = {
  musicals: number[],
  actors: number[],
  withChildren: boolean,
}

export const usePreferencesStore = defineStore('preferences', () => {
  const preferences = ref({
    musicals: [],
    actors: [],
    withChildren: false,
  } as PreferencesState);
   
  const isOnboardingFinished = ref(false);

  const addMusical = (musical: Musical) => {
    preferences.value.musicals.push(Number(musical.id));
  };

  const removeMusical = (musical: Musical) => {
    preferences.value.musicals = preferences.value.musicals
      .filter(m => m !== Number(musical.id))
  };

  const addActor = (actor: Actor) => {
    preferences.value.actors.push(Number(actor.id));
  };

  const removeActor = (actor: Actor) => {
    preferences.value.actors = preferences.value.actors
      .filter(a => a !== Number(actor.id))
  };

  const setWithChildren = (value: boolean) => {
    preferences.value.withChildren = value;
  };

  const setIsOnboardingFinished = (value: boolean) => {
    isOnboardingFinished.value = value;
  };

  const resetPreferences = () => {
    preferences.value = {
      musicals: [],
      actors: [],
      withChildren: false,
    }

    isOnboardingFinished.value = false;
  }

  return {
    preferences,
    addMusical,
    removeMusical,
    addActor,
    removeActor,
    setWithChildren,
    isOnboardingFinished,
    setIsOnboardingFinished,
    resetPreferences,
  }
}, {
  persist: true,
})

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(usePreferencesStore, import.meta.hot))