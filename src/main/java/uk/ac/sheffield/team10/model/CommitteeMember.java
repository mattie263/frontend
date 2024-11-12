package uk.ac.sheffield.team10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CommitteeMember")
public class CommitteeMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long committeeID;

    @OneToOne
    @JoinColumn(name = "memberID", referencedColumnName = "memberID")
    private AdultMember member;

    public CommitteeMember() {}

    public CommitteeMember(AdultMember adultMember) {
        this.member = adultMember;
    }

    public Long getId() {
        return committeeID;
    }

    public void setId(Long id) {
        this.committeeID = id;
    }

    public AdultMember getMember() {
        return member;
    }

    public void setMember(AdultMember adultMember) {
        this.member = adultMember;
    }
}
