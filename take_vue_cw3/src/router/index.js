import { createRouter, createWebHistory } from 'vue-router';
import NewPersonForm from '../views/NewPersonForm.vue';
import ListOfPeople from '../views/ListOfPeople.vue';

const routes = [
  {
    path: '/list',
    name: 'ListOfPeople',
    component: ListOfPeople,
  },
  {
    path: '/new-person',
    name: 'NewPersonForm',
    component: NewPersonForm,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
