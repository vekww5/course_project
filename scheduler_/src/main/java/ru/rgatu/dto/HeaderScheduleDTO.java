package ru.rgatu.dto;

import lombok.Value;

@Value
public class HeaderScheduleDTO {
    Long id_header_schedule;
    String header_name;
    Boolean approved;
}
