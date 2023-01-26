create table schedule
(
    id_schedule        bigint not null
        primary key,
    cancell            boolean,
    date               date,
    id_header_schedule bigint,
    id_place           bigint,
    id_section         bigint,
    note               varchar(255),
    time_end           time,
    time_start         time
);

alter table schedule
    owner to postgres;

