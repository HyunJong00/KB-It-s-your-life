function addContact(
  name,
  mobile,
  home = '없음',
  adress = '없음',
  email = '없음',
) {
  console.log(
    `name ${name}, mobile=${mobile}, home=${home}, adress= ${adress}`,
  );
}
addContact('홍길동', '010-222-3331');
addContact('이몽룡', '010-222-3331', '02-3422-9900', '서울시');
