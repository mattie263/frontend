package uk.ac.sheffield.team10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Director")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long directorID;

    @OneToOne
    @JoinColumn(name = "committeeID", referencedColumnName = "committeeID")
    private CommitteeMember committeeMember;

    public Director() {}

    public Director(CommitteeMember member) {
        this.committeeMember = member;
    }
}
