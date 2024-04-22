CREATE TABLE IF NOT EXISTS Users(
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL
);

INSERT INTO USERS(username, password, enabled) VALUES('loliveirap', 'c2XpY3VyaW9zb2Vt', true);