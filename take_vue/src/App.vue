<template>
  <div id="app">
    <div>
      <Person :people="people" @add="addPerson" />
    </div>
    <div>
      <PersonComposition :people="people" @add="addPerson" />
    </div>
  </div>
</template>

<script>
import Person from './components/Person.vue';
import PersonComposition from './components/PersonComposition.vue';

export default {
  name: 'App',
  components: {
    Person,
    PersonComposition
  },
  data() {
    return {
      people: [],
    };
  },
  methods: {
    addPerson(newPerson) {
      this.people.push(newPerson);
    },
  },
};
</script>
