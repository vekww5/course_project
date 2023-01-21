package ru.rsatu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;

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

/*package ru.rsatu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "learner")
public class Learner extends People {
    @Id
    @SequenceGenerator(name = "learnerSeq", sequenceName = "learner_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "learnerSeq")
    private Long id_learner;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "section_learner",
            joinColumns = @JoinColumn(name = "id_learner"),
            inverseJoinColumns = @JoinColumn(name = "id_section")
    )
    public Collection<Section> sections;

    private Boolean enrolled;

    public Long getId_learner() {
        return id_learner;
    }

    public Collection<Section> getSections() {
        return sections;
    }

    public void setSections(Collection<Section> sections) {
        this.sections = sections;
    }

    public Boolean getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(Boolean enrolled) {
        this.enrolled = enrolled;
    }

    public Learner() {
    }

}*/
