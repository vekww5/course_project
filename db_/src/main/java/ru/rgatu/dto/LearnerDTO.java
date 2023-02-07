package ru.rgatu.dto;

import lombok.Value;

@Value
public class LearnerDTO extends PeopleDTO {
    Long id_learner;
    Long id_section;
    Boolean enrolled;
}
