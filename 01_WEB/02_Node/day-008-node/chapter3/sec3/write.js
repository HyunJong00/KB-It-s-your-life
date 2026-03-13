const fs = require('fs');
const path = require('path');

const filepath = path.join(__dirname, 'example.txt');
const data = fs.readFileSync(filepath, 'utf8');
const writepath = path.join(__dirname, 'example3.txt');

// // 동기 입력
// fs.writeFileSync(writepath, data);

// //비동기 입력
// fs.writeFile(filepath, 'data', (err) => {
//   if (err) console.log(err);
//   console.log('data savd');
// });
isFileExist = fs.existsSync(filepath);
if (fs.existsSync('./test')) {
  console.log('folder already exsits');
} else {
  fs.mkdir('./test', (err) => {
    if (err) return console.err(err);
  });
  console.log('folder create');
}
