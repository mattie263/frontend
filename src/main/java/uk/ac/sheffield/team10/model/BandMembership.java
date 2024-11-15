package uk.ac.sheffield.team10.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BandMembership")
public class BandMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bandMembershipId;

    @Column(name = "seniorBandID", nullable = true)
    private Long seniorBandId;

    @Column(name = "trainingBandID", nullable = true)
    private Long trainingBandId;

    @Column(name = "memberID", nullable = false)
    private Long memberId;

    public BandMembership() {}

    public BandMembership(Long bandMembershipId, Long seniorBandId, Long trainingBandId, Long memberId) {
        this.bandMembershipId = bandMembershipId;
        this.seniorBandId = seniorBandId;
        this.trainingBandId = trainingBandId;
        this.memberId = memberId;
    }

    public Long getBandMembershipId() {
        return bandMembershipId;
    }

    public void setBandMembershipId(Long bandMembershipId) {
        this.bandMembershipId = bandMembershipId;
    }

    public Long getSeniorBandId() {
        return seniorBandId;
    }

    public void setSeniorBandId(Long seniorBandId) {
        this.seniorBandId = seniorBandId;
    }

    public Long getTrainingBandId() {
        return trainingBandId;
    }

    public void setTrainingBandId(Long trainingBandId) {
        this.trainingBandId = trainingBandId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
