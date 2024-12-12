-- author nikrusskikh
-- liquibase formatted sql

CREATE SEQUENCE IF NOT EXISTS book_id_seq
START WITH 1
INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS Books
(
    id     INT NOT NULL DEFAULT nextval('book_id_seq'),
    author_id INT,
    title  VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (author_id) REFERENCES Authors (id)
);
ALTER SEQUENCE book_id_seq OWNED BY Books.id;