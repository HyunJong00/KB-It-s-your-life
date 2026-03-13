const fs = require('fs');
// const path = require('path')
// filepath = path.join(__dirname,)

basepath = __dirname;
const rs = fs.createReadStream(basepath + '/example.txt');
rs.on('data', (chunk) => {
  console.log('new chunk received:');
  console.log(chunk.length, chunk);
})
  .on('end', () => {
    console.log('finished reading data');
  })
  .on('error', (err) => {
    console.error(`Error reading the file: ${err}`);
  });
