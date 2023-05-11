DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS post;

CREATE TABLE users
(
    id         INT PRIMARY KEY,
    FIRST_NAME VARCHAR(250) NOT NULL,
    LAST_NAME  VARCHAR(250) NOT NULL,
    EMAIL      VARCHAR(250) NOT NULL
);

CREATE TABLE post
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(255) NOT NULL,
    content    VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

INSERT INTO users (ID, FIRST_NAME, LAST_NAME, EMAIL)
VALUES (1, 'first', 'last 1', 'abc1@gmail.com'),
       (2, 'first', 'last 2', 'abc2@gmail.com'),
       (3, 'first', 'last 3', 'abc3@gmail.com');

INSERT INTO post (title, content, created_at, updated_at)
VALUES ('First post', 'This is the first post', '2023-05-04 12:00:00', '2023-05-04 12:00:00'),
       ('Second post', 'This is the second post', '2023-05-04 13:30:00', '2023-05-04 13:30:00'),
       ('Third post', 'This is the third post', '2023-05-04 15:00:00', '2023-05-04 15:00:00');