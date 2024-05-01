<template>
    <div>
      <h1>{{ pageTitle }}</h1>
      <ul>
        <li v-for="(person, index) in people" :key="index">
          {{ person.firstName }} {{ person.lastName }}
        </li>
      </ul>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import store from '../store.js';
  
  const pageTitle = ref('List of people');
  const people = ref(store.people);
  </script>