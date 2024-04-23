CREATE TABLE IF NOT EXISTS USERS(
    username VARCHAR(50) NOT NULL primary key,
    password VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL
);

INSERT INTO USERS(username, password, enabled) VALUES('loliveirap', 'c2XpY3VyaW9zb2Vt', true);

CREATE TABLE IF NOT EXISTS AUTHORITIES(
   username VARCHAR(50) NOT NULL,
   authority VARCHAR(50) NOT NULL,
   CONSTRAINT FK_AUTHORITIES_USERS FOREIGN KEY (username) REFERENCES USERS(username),
   CONSTRAINT USERNAME_AUTHORITY UNIQUE(username, authority)
);

INSERT INTO AUTHORITIES(username, authority) VALUES('loliveirap', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES(username, authority) VALUES('loliveirap', 'ROLE_USER');