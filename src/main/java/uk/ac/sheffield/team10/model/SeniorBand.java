package uk.ac.sheffield.team10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SeniorBand")
public class SeniorBand extends Band {

    @OneToMany(mappedBy = "seniorBandId")
    private Set<BandMembership> bandMemberships = new HashSet<>();

    public SeniorBand() {}

    public SeniorBand(Long bandId, String name) {
        super(bandId, name);
    }

    public Set<BandMembership> getBandMemberships() {
        return bandMemberships;
    }

    public void setBandMemberships(Set<BandMembership> bandMemberships) {
        this.bandMemberships = bandMemberships;
    }
}
