// db선택 및 문서 저장
use tutorial;
db.users.insert({username: "smith"});
db.users.insert({username: "jones"});
// 문서 출력
db.users.find();
db.users.findOne();
db.users.find({username:"jones"});
db.users.find({$or:[{username:"jones"},{username:"smith"}]});
//문서 수정
db.users.update({username:"smith"}, {$set:{country:"Canada"}});
db.users.find({username:"smith"});
db.users.replaceOne({username:"smith"}, {country:"Canada"})
db.users.find({country:"Canada"});
db.users.replaceOne({country: "Canada"}, {username: "smith", country: "Canada"});
db.users.find({username:"smith"});
db.users.update({username:"smith"},{$unset:{country:1}})
db.users.find({username:"smith"});
//상태 보기
show dbs;
show collections;
db.stats();
db.users.stats();
//삭제
db.users.remove({username:"smith"});
db.users.find({username:"smith"});
db.users.deleteMany({});
db.users.find();
db.users.drop()
//대용량 컬렉션 생성
use test;
for(let i=0;i<20000;i++){
    db.product.insertOne({num:i, name:"스마트폰"+i});
}
db.product.count();
//쿼리
db.product.find().sort({num:-1}).pretty();
db.product.find().sort({num:-1}).limit(10).pretty();
db.product.find().sort({num:-1}).skip(50).limit(10).pretty();
db.product.find({$or:[{num:{$lt:15}},{num:{$gt:19995}}]})
db.product.find({name: {$in:["스마트폰10", "스마트폰100", "스마트폰1000"]}})
db.product.find({num:{$lt:5}},{name:1,_id:0})
db.product.find();