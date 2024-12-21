create schema loan_service;
create schema fraud_detection;


-- begin;

-- product db

-- drop database if exists productdb;
-- drop database if exists orderdb;
-- drop database if exists paymentdb;


-- create database productdb;
create schema loan_service;
-- create database  paymentdb;

\connect loan_service

CREATE TABLE loans
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    loanId       VARCHAR(36)    NOT NULL,
    customerName VARCHAR(255)   NOT NULL,
    customerId   INT            NOT NULL,
    amount       DECIMAL(10, 2) NOT NULL,
    loanStatus   VARCHAR(50)    NOT NULL
);

truncate table loans;
ALTER TABLE loans AUTO_INCREMENT = 1;
INSERT INTO loans (id, loanId, customerName, customerId, amount, loanStatus)
VALUES (1, UUID(), 'John', 101, 5000.00, 'APPROVED'),
       (2, UUID(), 'Sai', 102, 7500.00, 'APPROVED'),
       (3, UUID(), 'Alice', 103, 3000.00, 'REJECTED');


-- order db



\connect fraud_detection

CREATE TABLE fraud_records
(
    id            BIGINT      NOT NULL,
    fraudRecordId VARCHAR(36) NOT NULL,
    customerId    INT         NOT NULL,
    PRIMARY KEY (id)
);


truncate table fraud_records;
ALTER TABLE fraud_records
    AUTO_INCREMENT = 1;
INSERT INTO fraud_records (id, fraudRecordId, customerId)
VALUES (1, UUID(), 101),
       (3, UUID(), 103);

-- create sequence if not exists  category_seq increment by 1;
-- create sequence if not exists  product_seq increment by 1;
-- create sequence if not exists   customer_order_seq increment by 1;
-- create sequence if not exists   customer_line_seq increment by 1;
-- create sequence if not exists   payment_seq increment by 1;

-- payment db

-- \connect paymentdb

-- create table  payment (
--     id int8 primary key,
--     amount decimal(12,4) null,
--     payment_method varchar(255) null,
--     order_id int8 null,
--     created_date timestamp null,
--     last_modified_date timestamp null
-- );



-- grant permission to user

--  GRANT ALL PRIVILEGES ON DATABASE productdb TO postgres;
-- GRANT ALL PRIVILEGES ON DATABASE orderdb TO postgres;
--  GRANT ALL PRIVILEGES ON DATABASE paymentdb TO postgres;
-- GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres;
-- GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO postgres;

-- commit;
