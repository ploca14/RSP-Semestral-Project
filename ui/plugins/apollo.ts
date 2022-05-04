import { createApolloProvider } from '@vue/apollo-option';
import { ApolloClient, InMemoryCache } from '@apollo/client/core'

const cache = new InMemoryCache()

const apolloClient = new ApolloClient({
  cache,
  uri: 'http://localhost:8080/musicals/graphql',
})

const apolloProvider = createApolloProvider({
  defaultClient: apolloClient,
});

export default defineNuxtPlugin(nuxtApp => {
    nuxtApp.vueApp.use(apolloProvider);
});