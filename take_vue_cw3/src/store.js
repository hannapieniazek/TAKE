import { reactive } from 'vue';

const state = reactive({
  people: [],
  addPerson(newPerson) {
    state.people.push(newPerson);
  },
});

export default state;