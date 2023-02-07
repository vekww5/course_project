package ru.rgaru.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Value;

import java.sql.Date;

@Value
public class LearnerDTO {
    Long id_learner;
    Long id_section;
    Boolean enrolled;
    String last_name;
    String first_name;
    String middle_name;
    String phone;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date birthday;
}
