create table categories
(
    id   tinyint auto_increment,
    name varchar(255) not null,
    constraint categories_pk
        primary key (id)
);