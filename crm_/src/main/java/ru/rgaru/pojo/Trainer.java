package ru.rgaru.pojo;

import javax.persistence.*;

@Entity
@Table(name = "trainer")
public class Trainer extends People{
    @Id
    @SequenceGenerator(name = "trainerSeq", sequenceName = "trainer_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "trainerSeq")
    private Long id_trainer;

    public Long getId_trainer() {
        return id_trainer;
    }

    public Trainer() {
    }

}
