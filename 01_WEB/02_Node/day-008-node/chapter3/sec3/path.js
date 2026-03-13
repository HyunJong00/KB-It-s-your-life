path = require('path');

exPath = path.join('some', 'work', 'ex.txt');
// console.log(exPath);

// console.log(__dirname, __filename);
// console.log(__filename.replace(__dirname, ''));
// console.log(path.basename(__filename, '.js'));
// console.log(path.extname(__filename));

const parsedPath = path.parse(__filename);
console.log(parsedPath);
