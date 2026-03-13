fs = require('fs');
path = require('path');

filepath = path.join(__dirname, 'example.txt');
fs.readFile(filepath, 'utf8', (err, data) => {
  if (err) {
    console.log(err);
  }
  fs.writeFile(filepath + '2', data, (err) => {
    if (err) {
      console.log(err);
    }
    console.log('exaple.txt2 is saved!');
  });
});
