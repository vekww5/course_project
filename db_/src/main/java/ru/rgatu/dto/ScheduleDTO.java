package ru.rgatu.dto;

import java.sql.Date;
import java.sql.Time;

import lombok.Value;

@Value
public class ScheduleDTO {
    Long id_schedule;
    Long id_place;
    Long id_section;
    Long id_header_schedule;
    Date date;
    Time time_start;
    Time time_end;
    Boolean cancell;
    String note;
}
