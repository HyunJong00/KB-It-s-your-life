function outer() {
  let count = 0;
  function inner() {
    count++;
    console.log('ineer', count);
  }
  console.log('outer: ', count);
  return inner;
}

const counter = outer();
const counte = outer;

counte;
counter();
counter();
counter();
