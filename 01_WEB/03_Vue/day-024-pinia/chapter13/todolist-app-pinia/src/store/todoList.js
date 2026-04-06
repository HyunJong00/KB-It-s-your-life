import { defineStore } from 'pinia';
import { reactive, computed } from 'vue';

export const useTodoListStore = defineStore('todoList', () => {
  const state = reactive({
    todoList: [
      { id: 1, todo: 'ES6학습', desc: '설명1', done: false },
      { id: 2, todo: 'React학습', desc: '설명2', done: false },
      { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
      { id: 4, todo: '야구경기 관람', desc: '설명4', done: false },
    ],
  });

  const addTodo = ({ todo, desc }) => {
    state.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
  };
  const deleteTodo = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList.splice(index, 1);
  };
  const toggleDone = (id) => {
    console.log('click toggledone');
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList[index].done = !state.todoList[index].done;
  };

  const doneCount = computed(() => {
    return state.todoList.filter((todoItem) => todoItem.done === true).length;
  });
  const todoList = computed(() => state.todoList);
  return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
});
