-- 사용자 별 구매 이력
SELECT * FROM usertbl
	INNER JOIN buytbl
		on usertbl.userID = buytbl.userID;

-- userID가 'JYP'인 사용자의 구매이력
SELECT * FROM usertbl
	INNER JOIN buytbl
		on usertbl.userID = buytbl.userID
WHERE usertbl.userID = 'JYP';

-- 구매이력 유뮤와 상관 없이 사용자 별 구매이력(오름차순)
SELECT U.userID, U.name, B.prodName, U.addr, CONCAT(U.mobile1,U.mobile2) AS '연락처'
FROM usertbl U
	LEFT OUTER JOIN buytbl B
		ON B.userID = U.userID
ORDER BY userID;

-- 전화가 없는 사람은 제외한 모든 사용자
SELECT * 
FROM usertbl
WHERE mobile1 IS NOT NULL;

-- 전화기가 없는 사용자
SELECT * 
FROM usertbl
WHERE mobile1 IS NULL;