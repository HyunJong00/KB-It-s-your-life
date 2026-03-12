export let goodbye = (name) => {
  console.log(`${name} 님, 안녕히 가세요.`);
};

export function hi(name) {
  console.log(`${name} 님, 안녕하세요?`);
}

const hi2 = (name) => {
  console.log(`${name}님, 안녕하세요?`);
};
const goodbye2 = (name) => {
  console.log(`${name}님, 안녕히 가세요.`);
};

export default { hi2, goodbye2 };
