-- Init script

-- DDL

create table IF NOT EXISTS test_user
(
    test_user_id  BIGINT not null,
    username   varchar(255) not null unique,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    primary key (test_user_id)
);

create table IF NOT EXISTS article
(
    article_id BIGINT not null,
    added_at  timestamp,
    content   varchar(255),
    headline  varchar(255),
    slug      varchar(255),
    title     varchar(255),
    author_id int8,
    primary key (article_id)
);

create table IF NOT EXISTS todo
(
    todo_id     BIGINT not null,
    description varchar(255),
    title       varchar(255),
    primary key (todo_id)
);

create table IF NOT EXISTS users
(
    user_id     BIGINT not null,
    description varchar(255),
    first_name   varchar(255),
    last_name    varchar(255),
    login       varchar(255),
    primary key (user_id)
);

CREATE SEQUENCE test_user_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE article_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE user_sequence START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE todo_sequence START WITH 1 INCREMENT BY 1;