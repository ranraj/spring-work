DROP TABLE account_wallet;
DROP TABLE account;

CREATE TABLE account (ID BIGINT NOT NULL, mobile_number VARCHAR(255) NOT NULL, name VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE account_wallet (ID BIGINT NOT NULL, account_id BIGINT NOT NULL, amount DECIMAL(38) NOT NULL, PRIMARY KEY (ID));

INSERT INTO account(id,name,mobile_number) VALUES(101,'ranj','912391232');
INSERT INTO account(id,name,mobile_number) VALUES(102,'raj','912391235');

INSERT INTO account_wallet(id,amount,account_id) VALUES(1,50,101);
INSERT INTO account_wallet(id,amount,account_id) VALUES(2,30,102);

