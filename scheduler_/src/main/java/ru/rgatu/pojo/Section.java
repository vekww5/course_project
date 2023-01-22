package ru.rgatu.pojo;

import javax.persistence.*;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @SequenceGenerator(name = "sectionSeq", sequenceName = "section_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "sectionSeq")
    private Long id_section;
    private String section_name;
    private Long id_trainer;

    public Long getId_section() {
        return id_section;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Long getId_trainer() {
        return id_trainer;
    }

    public void setId_trainer(Long id_trainer) {
        this.id_trainer = id_trainer;
    }

    public Section() {
    }

}
