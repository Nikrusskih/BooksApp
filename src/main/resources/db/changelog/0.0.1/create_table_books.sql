--liquibase formatted sql

CREATE TABLE IF NOT EXISTS Books
(
    id     INT GENERATED ALWAYS AS IDENTITY,
    author VARCHAR(255),
    title  VARCHAR(255)
);