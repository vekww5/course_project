package ru.rgatu.entity;

import javax.persistence.*;

@Entity
@Table(name = "learner")
public class Learner extends People {
    @Id
    @SequenceGenerator(name = "learnerSeq", sequenceName = "learner_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "learnerSeq")
    private Long id_learner;
    private Long id_section;
    private Boolean enrolled;

    public Long getId_learner() {
        return id_learner;
    }

    public Long getId_section() {
        return id_section;
    }

    public void setId_section(Long id_section) {
        this.id_section = id_section;
    }

    public Boolean getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Boolean enrolled) {
        this.enrolled = enrolled;
    }

    public Learner() {
    }

}
