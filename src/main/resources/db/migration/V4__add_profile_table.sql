create table profiles
(
    id             bigint auto_increment,
    bio            varchar(255)  not null,
    phone_number   varchar(15)   not null,
    date_of_birth  date          null,
    loyalty_points int default 0 null,
    user_id        bigint        not null,
    constraint profiles_pk
        primary key (id),
    constraint profiles_users_id_fk
        foreign key (user_id) references users (id)
);

create table tags
(
    id   bigint auto_increment,
    name varchar(255) null,
    constraint tags_pk
        primary key (id)
);

create table user_tags
(
    user_id bigint not null,
    tag_id bigint not null,

    constraint user_tags_user_id_fk
        foreign key (user_id) references users (id),
    constraint user_tags_tag_id_fk
        foreign key (tag_id) references tags (id)
)