create table headerschedule
(
    id_header_schedule bigint not null
        primary key,
    approved           boolean,
    header_name        varchar(255)
);

alter table headerschedule
    owner to postgres;

