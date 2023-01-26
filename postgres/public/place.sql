create table place
(
    id_place   bigint not null
        primary key,
    place_name varchar(255)
);

alter table place
    owner to postgres;

