<template>
    <div>
      <h2>Dodaj nową osobę (Composition API)</h2>
      <form @submit.prevent="addPerson">
        <input v-model="firstName" type="text" placeholder="Imię">
        <input v-model="lastName" type="text" placeholder="Nazwisko">
        <button type="submit">Dodaj</button>
      </form>
      <h2>Lista osób (Composition API)</h2>
      <ul>
        <li v-for="(person, index) in people" :key="index">
          {{ person.firstName }} {{ person.lastName }}
        </li>
      </ul>
      <h2>Podsumowanie (Composition API)</h2>
      <p>Liczba osób: {{ numberOfPeople }}</p>
    </div>
  </template>
  
  <script setup>
  import { ref, computed } from 'vue';
  
  const firstName = ref('');
  const lastName = ref('');
  
  const people = ref([]);
  
  const addPerson = () => {
    if (firstName.value && lastName.value) {
      const newPerson = { firstName: firstName.value, lastName: lastName.value };
      people.value.push(newPerson);
      firstName.value = '';
      lastName.value = '';
    }
  };
  
  const numberOfPeople = computed(() => {
    return people.value.length;
  });
  </script>
  