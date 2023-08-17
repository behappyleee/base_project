CREATE TABLE users
(
    username varchar_ignorecase(50) NOT NULL PRIMARY KEY,
    password varchar(2048)          NOT NULL,
    enabled  boolean                NOT NULL
);

CREATE TABLE authorities
(
    username  varchar_ignorecase(50) NOT NULL,
    authority varchar_ignorecase(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

CREATE UNIQUE INDEX idx_auth_username ON authorities (username, authority);