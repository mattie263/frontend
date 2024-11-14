package uk.ac.sheffield.team10.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AdultMember")
public class AdultMember extends Member {

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phoneNumber", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "isDirector")
    private boolean isDirector;

    @Column(name = "isCommittee")
    private boolean isCommittee;

    @OneToMany(mappedBy = "parentId")
    private Set<ChildMember> childAccounts = new HashSet<>();

    public AdultMember() {}

    public AdultMember(
        Long memberId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String password) {

        super(memberId, firstName, lastName);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<ChildMember> getChildAccounts() {
        return childAccounts;
    }

    public void setChildAccounts(Set<ChildMember> childAccounts) {
        this.childAccounts = childAccounts;
    }

    public boolean isDirector() {
        return isDirector;
    }

    public void setDirector(boolean isDirector) {
        this.isDirector = isDirector;
    }

    public boolean isCommittee() {
        return isCommittee;
    }

    public void setCommittee(boolean isCommittee) {
        this.isCommittee = isCommittee;
    }
}
