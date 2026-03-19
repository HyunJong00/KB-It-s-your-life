// let msg = 'GLOBAL';
// function outer() {
//   let msg = 'OUTER';
//   console.log(msg);
//   if (true) {
//     let msg = 'BLOCK';
//     console.log(msg);
//   }
// }
// outer();
// // OUTER
// // BLOCK

// const p1 = { name: 'john', age: 20 };
// p1.age = 22;
// console.log(p1);
// p1 = { name: 'lee', age: 25 }; // const에 변수 재할당 시도 -> 에러
// // {name:'john, age:22}
