-- Drop all tables
DROP TABLE if EXISTS details;
DROP TABLE if EXISTS transaction_data;

DROP TABLE if EXISTS frequently_shop;
DROP TABLE if EXISTS transaction_type;
DROP TABLE if EXISTS account_data;
DROP TABLE if EXISTS details_type;

DROP TABLE if EXISTS user_data;

-- Create Tables
-- user
CREATE TABLE user_data (
	user_id smallint NOT NULL,
	PRIMARY KEY (user_id)
);

-- list
CREATE TABLE frequently_shop (
	user_id smallint  NOT NULL,
	frequently_shop_no smallint  NOT NULL,
	frequently_shop_name VARCHAR (255) NOT NULL,
	PRIMARY KEY (user_id, frequently_shop_no),
	FOREIGN KEY (user_id) REFERENCES user_data (user_id)
); -- PARTITION BY RANGE (user_id);

CREATE TABLE transaction_type (
	user_id smallint  NOT NULL,
	transaction_type_no smallint  NOT NULL,
	transaction_type_name VARCHAR (255) NOT NULL,
	PRIMARY KEY (user_id, transaction_type_no),
	FOREIGN KEY (user_id) REFERENCES user_data (user_id)
); -- PARTITION BY RANGE (user_id);

CREATE TABLE account_data (
	user_id smallint NOT NULL,
	account_no smallint NOT NULL,
	account_name VARCHAR (255) NOT NULL,
	PRIMARY KEY (user_id, account_no),
	FOREIGN KEY (user_id) REFERENCES user_data (user_id)
); -- PARTITION BY RANGE (user_id);

CREATE TABLE details_type (
	user_id smallint NOT NULL,
	details_type_no smallint NOT NULL,
	details_type_name VARCHAR (255) NOT NULL,
	add_subtract_term CHAR (1) NOT NULL,
	PRIMARY KEY (user_id, details_type_no),
	FOREIGN KEY (user_id) REFERENCES user_data (user_id)
); -- PARTITION BY RANGE (user_id);

--transaction
CREATE TABLE transaction_data (
	user_id smallint NOT NULL,
	transaction_date date NOT NULL,
	transaction_seqno smallint NOT NULL,
	frequently_shop_no smallint NOT NULL,
	shop_name VARCHAR (255),
	transaction_type_no smallint NOT NULL,
	transaction_name VARCHAR (255) NOT NULL,
	outgoing_account_no smallint,
	outgoing_account_state boolean,
	outgoing_accounted_date date,
	incoming_account_no smallint,
	incoming_account_state boolean,
	incoming_accounted_date date,
	PRIMARY KEY (user_id, transaction_date, transaction_seqno),
	FOREIGN KEY (user_id) REFERENCES user_data (user_id),
	FOREIGN KEY (user_id, frequently_shop_no) REFERENCES frequently_shop (user_id, frequently_shop_no),
	FOREIGN KEY (user_id, transaction_type_no) REFERENCES transaction_type (user_id, transaction_type_no),
	FOREIGN KEY (user_id, outgoing_account_no) REFERENCES account_data (user_id, account_no),
	FOREIGN KEY (user_id, incoming_account_no) REFERENCES account_data (user_id, account_no)
); -- PARTITION BY RANGE (user_id);

CREATE TABLE details (
	user_id smallint NOT NULL,
	transaction_date date NOT NULL,
	transaction_seqno smallint NOT NULL,
	details_seqno smallint NOT NULL,
	details_name VARCHAR (255) NOT NULL,
	details_type_no smallint NOT NULL,
	amount decimal(14, 2) NOT NULL,
	rate decimal(10, 5),
	PRIMARY KEY (user_id, transaction_date, transaction_seqno, details_seqno),
	FOREIGN KEY (user_id) REFERENCES user_data (user_id),
	FOREIGN KEY (user_id, transaction_date, transaction_seqno) REFERENCES transaction_data(user_id, transaction_date, transaction_seqno),
	FOREIGN KEY (user_id, details_type_no) REFERENCES details_type (user_id, details_type_no)
); -- PARTITION BY RANGE (user_id);

-- Grant to acc_ap
GRANT SELECT, INSERT, UPDATE, DELETE ON user_data TO acc_ap;
--
GRANT SELECT, INSERT, UPDATE, DELETE ON frequently_shop TO acc_ap;
GRANT SELECT, INSERT, UPDATE, DELETE ON transaction_type TO acc_ap;
GRANT SELECT, INSERT, UPDATE, DELETE ON account_data TO acc_ap;
GRANT SELECT, INSERT, UPDATE, DELETE ON details_type TO acc_ap;
---
GRANT SELECT, INSERT, UPDATE, DELETE ON transaction_data TO acc_ap;
GRANT SELECT, INSERT, UPDATE, DELETE ON details TO acc_ap;

-- insert into frequently_shop values (0, 'non frequently shop');
