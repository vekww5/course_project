package ru.rgatu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

@MappedSuperclass
public class PeopleDTO {
    String last_name;
    String first_name;
    String middle_name;
    String phone;
    @JsonFormat(pattern="yyyy-MM-dd")
    Date birthday;
}
