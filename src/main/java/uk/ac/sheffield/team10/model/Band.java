package uk.ac.sheffield.team10.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bandId;

    @Column(name = "name", nullable = false)
    private String name;

    public Band() {}

    public Band(Long bandId, String name) {
        this.bandId = bandId;
        this.name = name;
    }

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
