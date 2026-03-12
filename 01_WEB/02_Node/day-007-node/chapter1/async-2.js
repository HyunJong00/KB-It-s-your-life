const pizza = (bool) =>
  new Promise((resolve, reject) => {
    if (bool) resolve('order pizza');
    else reject(new Error('not order pizza'));
  });

pizza(false)
  .then((res) => console.log(res))
  .catch((rej) => console.log(rej));
