package uk.ac.sheffield.team10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ChildMember")
public class ChildMember extends Member {

    @ManyToOne
    @JoinColumn(name = "parentID", nullable = false)
    private AdultMember parent;

    public ChildMember() {}

    public ChildMember(Long memberID, String firstName, String lastName, AdultMember parent) {
        super(memberID, firstName, lastName);
        this.parent = parent;
    }

    public AdultMember getParent() {
        return parent;
    }

    public void setParent(AdultMember parent) {
        this.parent = parent;
    }
}
