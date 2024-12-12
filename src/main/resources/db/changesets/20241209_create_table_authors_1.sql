-- author nikrusskikh
-- liquibase formatted sql

CREATE SEQUENCE IF NOT EXISTS author_id_seq
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS Authors
(
    id     INT NOT NULL DEFAULT nextval('author_id_seq'),
    author VARCHAR(255),
    PRIMARY KEY (id)
);
ALTER SEQUENCE author_id_seq OWNED BY Authors.id;