package ru.rgatu.entity;

import javax.persistence.*;

@Entity
@Table(name = "place")
public class Place {
    @Id
    @SequenceGenerator(name = "placeSeq", sequenceName = "place_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "placeSeq")
    private Long id_place;
    private String place_name;

    public Long getId_place() {
        return id_place;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public Place() {
    }

}
