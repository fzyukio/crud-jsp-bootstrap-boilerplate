DROP DATABASE IF EXISTS infotips;
CREATE DATABASE infotips;
USE infotips;

ALTER DATABASE infotips CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS user
(
    id       INTEGER AUTO_INCREMENT NOT NULL,
    PRIMARY KEY (id),
    username VARCHAR(50)            NOT NULL,
    password VARCHAR(50)            NOT NULL
);

insert into user (username, password) values ('superuser', 'kiwisuper;;');


ALTER DATABASE infotips CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS tip
(
    id      INTEGER AUTO_INCREMENT NOT NULL,
    PRIMARY KEY (id),
    content TEXT NOT NULL ,
    start   DATE NOT NULL ,
    end     DATE NOT NULL
);

insert into tip (content, start, end) values ('Hello, world', '2020-05-08', '2020-05-10');
