<template>
  <!-- <div class="container">
    <Header />
    <router-view />
  </div> -->
  <div>
    <h2>TodoList 테스트(Composition API)</h2>
    <hr />
    할일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span @click="toggleDone(todoItem.id)" style="cursor: pointer"
          >{{ todoItem.todo }}{{ todoItem.done ? '(완료)' : '' }}</span
        >
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>

<script setup>
import { ref, reactive, computed, provide } from 'vue';
import { useTodoListStore } from './store/todoList';

const todo = ref('');
const todoListStore = useTodoListStore();
//참조 타입에 대해서는 분해할당 가능
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;
const doneCount = computed(() => todoListStore.doneCount); // 기본 타입에 대해서는 계산된 속성을 다시 작성

const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};
</script>
