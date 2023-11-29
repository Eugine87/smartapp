--liquibase formatted sql

--changeset Ivan:1
INSERT INTO users(first_name, last_name, email, password, role)
VALUES ('Admin', 'Admin', 'admin@test.test', '12345678', 'ADMIN'),
       ('User', 'User', 'user@test.test', '12345678', 'USER');


