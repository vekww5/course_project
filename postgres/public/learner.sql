create table learner
(
    id_learner  bigint not null
        primary key,
    birthday    date,
    first_name  varchar(255),
    last_name   varchar(255),
    middle_name varchar(255),
    phone       varchar(255),
    enrolled    boolean,
    id_section  bigint
);

alter table learner
    owner to postgres;

