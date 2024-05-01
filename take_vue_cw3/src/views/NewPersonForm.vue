<template>
  <div>
    <h1>{{ pageTitle }}</h1>
    <form @submit.prevent="addPerson">
      <input v-model="firstName" type="text" placeholder="First name">
      <input v-model="lastName" type="text" placeholder="Last name">
      <button type="submit">Add</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import store from '../store.js';

const pageTitle = ref('New person');
const firstName = ref('');
const lastName = ref('');
const router = useRouter();

const addPerson = () => {
  if (firstName.value && lastName.value) {
    const newPerson = { firstName: firstName.value, lastName: lastName.value };
    store.addPerson(newPerson);
    router.push({ name: 'ListOfPeople' });
    firstName.value = '';
    lastName.value = '';
  }
};
</script>