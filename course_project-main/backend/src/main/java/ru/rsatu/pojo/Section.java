package ru.rsatu.pojo;

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


/*package ru.rsatu.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "section")
public class Section {
    @Id
    @SequenceGenerator(name = "sectionSeq", sequenceName = "section_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "sectionSeq")
    private Long id_section;
    private String section_name;
   // @ManyToOne
   // @JsonIgnore
   // private Trainer id_trainer;
   private Long id_trainer;

    @ManyToMany(mappedBy = "sections")
    @JsonIgnore
    private Collection<Learner> learners;

    public Long getId_section() {
        return id_section;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

  //  public Trainer getId_trainer() {
  //      return id_trainer;
  //  }
  public Long getId_trainer() {
      return id_trainer;
  }

    public void setId_trainer(Long id_trainer) {
        this.id_trainer = id_trainer;
    }

  //  public void setId_trainer(Trainer id_trainer) {
  //      this.id_trainer = id_trainer;
  //  }

    public Collection<Learner> getLearners() {
        return learners;
    }

    public void setLearners(Collection<Learner> learners) {
        this.learners = learners;
    }

    public Section() {
    }
}*/
