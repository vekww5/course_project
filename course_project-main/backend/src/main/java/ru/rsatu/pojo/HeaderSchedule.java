package ru.rsatu.pojo;

import javax.persistence.*;

@Entity
@Table(name = "headerschedule")
public class HeaderSchedule {
    @Id
    @SequenceGenerator(name = "headerscheduleSeq", sequenceName = "headerschedule_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "headerscheduleSeq")
    private Long id_header_schedule;
    private String header_name;
    private Boolean approved;

    public Long getId_header_schedule() {
        return id_header_schedule;
    }

    public String getHeader_name() {
        return header_name;
    }

    public void setHeader_name(String header_name) {
        this.header_name = header_name;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public HeaderSchedule() {
    }


}
