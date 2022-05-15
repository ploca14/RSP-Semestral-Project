<template>
  <div>
    <h1 class="text-2xl font-medium text-purple-800 mt-2 mb-3 flex items-center">
      <button
        type="button"
        class="text-md mr-3 inline-grid place-items-center"
        @click="router.go(-1)"
      >
        <arrow-left-icon class="h-6 w-6 inline" />
      </button>
      {{ musical.name }}
    </h1>
    
    <img :src="musical.imageSource" alt="Titulní obrázek" class="w-full aspect-video object-cover rounded-2xl mb-5">

    <p class="text-justify mb-6">
      Lorem, ipsum dolor sit amet consectetur adipisicing elit. Nobis accusamus excepturi laboriosam similique! Nam sint recusandae magnam sit est quam soluta temporibus neque, nostrum nihil.
    </p>

    <div class="mb-8 text-sm">
      <div>
        <h3 class="font-medium text-purple-800 inline mr-1">Hrají:</h3>
        <p class="inline">{{ actors }}</p>
      </div>
      <div>
        <h3 class="font-medium text-purple-800 inline mr-1">Producenti:</h3>
        <p class="inline">{{ producers }}</p>
      </div>
      <div>
        <h3 class="font-medium text-purple-800 inline mr-1">Režiséři:</h3>
        <p class="inline">{{ directors }}</p>
      </div>
      <div>
        <h3 class="font-medium text-purple-800 inline mr-1">Druh:</h3>
        <p class="inline">{{ types }}</p>
      </div>
      <div>
        <h3 class="font-medium text-purple-800 inline mr-1">Žánry:</h3>
        <p class="inline">{{ genres }}</p>
      </div>
      <div>
        <h3 class="font-medium text-purple-800 inline mr-1">Atmosféra:</h3>
        <p class="inline">{{ atmospheres }}</p>
      </div>
    </div>

    <NuxtLink
      :to="musical.theatre.webURL"
      target="_blank"
      class="bg-yellow-500 py-2.5 px-6 rounded font-medium inline-flex"
    >
      Koupit lístky 
    </NuxtLink>


    <h2 class="text-lg font-medium text-purple-800 mt-6">
      Nadcházející představení
    </h2>

    <div class="divide-y">
      <expandable-content
        v-for="{ date, tickets } in performances"
        :key="date"
      >
        <span class="mb-2">
          {{ musical.theatre.name }} {{ new Date(date).toLocaleDateString('cs-CZ') }}
          <p class="text-xs text-gray-500">Volných lístků: {{ availableTicketsCount(tickets) }}</p>
        </span>
        <template #content>
          <p
            v-for="ticket in tickets"
            :key="ticket"
            :class="{'text-gray-400': !ticket.seat.available}"
            class="py-1 flex"
          >
            <span>Řada {{ ticket.seat.row }} sedadlo {{ ticket.seat.number }}</span>
            <span class="ml-auto">{{ formatter.format(ticket.price) }}</span>
          </p>
        </template>
      </expandable-content>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ArrowLeftIcon } from "@heroicons/vue/outline";

const route = useRoute();
const id = route.params.id as string;

const { data } = await useAsyncData(id, () => GqlMusicalById({ id }, { accept: 'application/json' }));
const musical = data.value.musicalById;
const actors = musical.actors.map(({firstName, lastName}) => `${firstName} ${lastName}`).join(', ');
const producers = musical.producers.map(({firstName, lastName}) => `${firstName} ${lastName}`).join(', ');
const directors = musical.directors.map(({firstName, lastName}) => `${firstName} ${lastName}`).join(', ');
const typeMap = {
  BOOK: 'Kniha',
  REVUE: 'Kabaret',
  JUKEBOX: 'Jukebox',
  CONCEPT: 'Koncept',
  ROCK: 'Rock',
  POP: 'Pop',
  AUTOBIOGRAPHICAL: 'Autobiografické',
  NON_AUTOBIOGRAPHICAL: 'Neautobiografické',
  FILM: 'Film',
}
const types = musical.musicalTypes.map((type) => typeMap[type]).join(', ');
const genreMap = {
  COMEDY: 'Komedie',
  FANTASY: 'Fantasy',
  CRIMEDRAMA: 'Krimidrama',
  DOCUDRAMA: 'Dokudrama',
  HISTORICAL: 'Historické',
  HORROR: 'Horror',
  MELODRAMA: 'Melodrama',
  TRAGICOMEDY: 'Tragikomedie'
}
const genres = musical.musicalGenres.map((genre) => genreMap[genre]).join(', ');
const atmosphereMap = {
  DEPRESSED: 'Depresivní',
  ANXIOUS: 'Úzkostná',
  IRRITABLE: 'Dráždivá',
  EMPTY: 'Prázdná',
  SUNNY_HYPOMANIA: 'Slunečná hypománie',
  DARK_HYPOMANIA: 'Temná hypománie',
  MIXED: 'Smíšená'
}
const atmospheres = musical.musicalAtmospheres.map((atmosphere) => atmosphereMap[atmosphere]).join(', ')
const performances = musical.performances.sort((a,b)=> new Date(a.date).getTime() - new Date(b.date).getTime());
const availableTicketsCount = (tickets) => {
  return tickets.filter((ticket) => ticket.seat.available).length
}
const formatter = new Intl.NumberFormat('cs-CZ', { style: 'currency', currency: 'CZK' });

const router = useRouter();
</script>
