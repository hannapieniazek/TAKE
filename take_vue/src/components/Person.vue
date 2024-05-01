<template>
    <div>
      <h2>Dodaj nową osobę</h2>
      <form @submit.prevent="addPerson">
        <input v-model="firstName" type="text" placeholder="Imię">
        <input v-model="lastName" type="text" placeholder="Nazwisko">
        <button type="submit">Dodaj</button>
      </form>
      <h2>Lista osób</h2>
      <ul>
        <li v-for="(person, index) in people" :key="index">
          {{ person.firstName }} {{ person.lastName }}
        </li>
      </ul>
      <h2>Podsumowanie</h2>
    <p>Liczba osób: {{ numberOfPeople }}</p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        firstName: '',
        lastName: '',
      };
    },
    props: {
      people: {
        type: Array,
        default: () => [],
      },
    },
    methods: {
      addPerson() {
        if (this.firstName && this.lastName) {
          const newPerson = { firstName: this.firstName, lastName: this.lastName };
          this.$emit('add', newPerson);
          this.firstName = '';
          this.lastName = '';
        }
      },
    },
    computed: {
    numberOfPeople() {
      return this.people.length;
    },
  },
  };
  </script>
 