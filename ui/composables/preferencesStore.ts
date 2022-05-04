import { acceptHMRUpdate, defineStore } from 'pinia'
import { Musical } from '~~/models/musical.model';
import { Actor } from '~~/models/actor.model';

export type PreferencesState = {
  favourite: Musical[],
  actors: Actor[],
}

export const usePreferencesStore = defineStore('preferences', () => {
  const preferences = useState('preferences', () => ({
      favourite: [],
      actors: [],
    } as PreferencesState));

  const addFavourite = (musical: Musical) => {
    preferences.value.favourite.push(musical);
  }

  const removeFavourite = (musical: Musical) => {
    preferences.value.favourite = preferences.value.favourite
      .filter(m => m.id !== musical.id)
  }

  const addActor = (actor: Actor) => {
    preferences.value.actors.push(actor);
  }

  const removeActor = (actor: Actor) => {
    preferences.value.actors = preferences.value.actors
      .filter(a => a.id !== actor.id)
  }

  return {
    preferences,
    addFavourite,
    removeFavourite,
    addActor,
    removeActor,
  }
}, {
  persist: true,
})

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(usePreferencesStore, import.meta.hot))