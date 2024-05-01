<template>
  <div id="app">
    <nav>
      <router-link to="/new-person">Add person</router-link>
      <router-link to="/list">List of people</router-link>
    </nav>
    <router-view />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import store from './store.js';
</script>
