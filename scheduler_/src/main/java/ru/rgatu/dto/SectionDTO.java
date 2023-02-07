package ru.rgatu.dto;

import lombok.Value;

@Value
public class SectionDTO {
    Long id_section;
    String section_name;
    Long id_trainer;
}
