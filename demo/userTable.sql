CREATE TABLE users 
	(
		uid VARCHAR(15) PRIMARY KEY NOT NULL,
		name VARCHAR(30),
		birthday Date,
		email VARCHAR(50)
	);

INSERT INTO 
	users (uid, name, birthday, email) 
	values ("2009050001", "testname", Date "2020-09-05", "testemail@gmail.com");

DESC users;

SELECT * FROM users;