--liquibase formatted sql

--changeset Ivan:1
CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(32)        NOT NULL,
    last_name  VARCHAR(32)        NOT NULL,
    email      VARCHAR(32) UNIQUE NOT NULL,
    password   VARCHAR(62)        NOT NULL,
    role       VARCHAR(16)        
);
--rollback DROP TABLE users;

--changeset Ivan:2
CREATE TABLE IF NOT EXISTS lesson
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(32)  NOT NULL,
    file_url    VARCHAR(64)  NOT NULL UNIQUE,
    description VARCHAR(256) NOT NULL
);
--rollback DROP TABLE lesson;

--changeset Ivan:3
CREATE TABLE IF NOT EXISTS course
(
    id          SERIAL PRIMARY KEY,
    course_name VARCHAR(32)  NOT NULL,
    description VARCHAR(64)  NOT NULL,
    image_url   VARCHAR(256) NOT NULL UNIQUE,
    created_at  TIMESTAMP    NOT NULL,
    updated_at  TIMESTAMP    NOT NULL
);
--rollback DROP TABLE course;

--changeset Ivan:4
CREATE TABLE IF NOT EXISTS course_lesson
(
    id        SERIAL PRIMARY KEY,
    course_id INT REFERENCES course(id),
    lesson_id INT REFERENCES lesson(id)
);
--rollback DROP TABLE course_lesson;

