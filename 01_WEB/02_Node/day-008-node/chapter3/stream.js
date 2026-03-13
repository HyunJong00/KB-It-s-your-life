const fs = require('fs');
const path = require('path');

const readStream = fs.createReadStream(path.join(__dirname, 'readMe.txt'));
const writeStream = fs.createWriteStream(path.join(__dirname, 'writeMe.txt'));

readStream.on('end', () => {
  console.log('finished reading data');
});

readStream.on('data', (chunk) => {
  console.log('new chunk received:');
  console.log(chunk);
});

readStream.on('error', (err) => {
  console.error(err);
});

readStream.pipe(writeStream);
