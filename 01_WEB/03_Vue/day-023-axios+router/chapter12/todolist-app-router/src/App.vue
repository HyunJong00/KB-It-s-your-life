<template>
  <div class="container">
    <Header />
    <router-view />
    <Loading v-if="states.isLoading" />
  </div>
</template>

<script setup>
import { computed, provide, reactive } from 'vue';
import axios from 'axios';
const BASEURL = 'api/todos';
const states = reactive({ todoList: [], isLoading: false });
import Header from '@/components/Header.vue';
import Loading from '@/components/Loading.vue';

const fetchTodoList = async () => {
  states.isLoading = true;
  try {
    const response = await axios.get(BASEURL);
    if (response.status === 200) {
      states.todoList = response.data;
    } else {
      alert('데이터 조회 실패');
    }
  } catch (error) {
    alert('에러 발생: ' + error``);
  } finally {
    states.isLoading = false;
  }
};

const addTodo = async ({ todo, desc }, successCallback) => {
  states.isLoading = true;
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURL, payload);
    if (response.status === 200) {
      states.todoList.push({ ...response.data, done: false });
      successCallback();
    } else {
      alert('todo 추가 실패');
    }
  } catch (error) {
    alert('에러 발생: ', error);
  } finally {
    states.isLoading = states.isLoading = false;
  }
};

// updateTodo({ id: 1, todo: 'vue 학습', desc: 'vue는 중요해요', done: false });
const updateTodo = async ({ id, todo, desc, done }) => {
  states.isLoading = true;
  try {
    const payload = { id, todo, desc, done };
    const response = await axios.put(BASEURL + `/${id}`, payload);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      //FIXME: 이건 전개연산자 필요 없네
      states.todoList[index] = payload;
    }
  } catch (error) {
    alert('error: ' + error);
  } finally {
    states.isLoading = false;
  }
};
const deleteTodo = async (id) => {
  states.isLoading = true;
  try {
    const response = await axios.delete(BASEURL + `${id}`);
    console.log(response.status, response.data);
    if (response.status === 200) {
      let index = status.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert('Todo 삭제 실패');
    }
  } catch (err) {
    alert('error: ' + err);
  } finally {
    states.isLoading = false;
  }
};

const toggleDone = async (id) => {
  states.isLoading = true;
  try {
    let todo = status.todoList.find((todo) => todo.id === id);
    let payload = { ...todo, tone: !todo.done };
    const response = await axios.put(BASEURL + `/${id}`, payload);
    if (response.status === 200) {
      todo.done = payload.done;
    }
  } catch (err) {
    alert('error: ' + err);
  } finally {
    states.isLoading = false;
  }
};
// todoList는 읽기 전용으로 전달하므로 함수를 전달하여 호출 가능하도록 함
provide(
  'todoList',
  computed(() => states.todoList),
);
provide('action', {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});
fetchTodoList();
</script>
