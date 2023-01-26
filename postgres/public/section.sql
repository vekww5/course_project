create table section
(
    id_section   bigint not null
        primary key,
    id_trainer   bigint,
    section_name varchar(255)
);

alter table section
    owner to postgres;

