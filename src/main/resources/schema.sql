DROP TABLE if Exists book;
DROP sequence if Exists book_sequence;

CREATE TABLE book (
    id NUMERIC PRIMARY KEY,
    title text,
    genre text,
    published boolean
);

CREATE SEQUENCE book_sequence START 101;





