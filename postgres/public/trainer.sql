create table trainer
(
    id_trainer  bigint not null
        primary key,
    birthday    date,
    first_name  varchar(255),
    last_name   varchar(255),
    middle_name varchar(255),
    phone       varchar(255)
);

alter table trainer
    owner to postgres;

