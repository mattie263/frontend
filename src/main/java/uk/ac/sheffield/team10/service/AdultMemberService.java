package uk.ac.sheffield.team10.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import uk.ac.sheffield.team10.model.AdultMember;
import uk.ac.sheffield.team10.repository.AdultMemberRepository;

@Service
public class AdultMemberService {
    private final AdultMemberRepository adultMemberRepository;

    public AdultMemberService(AdultMemberRepository adultMemberRepository) {
        this.adultMemberRepository = adultMemberRepository;
    }

    public List<AdultMember> getAllAdultMembers() {
        return adultMemberRepository.findAll();
    }

    public Optional<AdultMember> findAdultMemberById(Long id) {
        return adultMemberRepository.findById(id);
    }

    public AdultMember saveAdultMember(AdultMember adultMember) {
        return adultMemberRepository.save(adultMember);
    }

    public AdultMember updateAdultMember(Long id, AdultMember updatedAdultMember) {
        Optional<AdultMember> adultMemberOptional = adultMemberRepository.findById(id);
        if (adultMemberOptional.isPresent()) {
            AdultMember adultMember = adultMemberOptional.get();
            adultMember.setFirstName(updatedAdultMember.getFirstName());
            adultMember.setLastName(updatedAdultMember.getLastName());
            adultMember.setEmail(updatedAdultMember.getEmail());
            adultMember.setPhoneNumber(updatedAdultMember.getPhoneNumber());
            adultMember.setPassword(updatedAdultMember.getPassword());
            return adultMemberRepository.save(adultMember);
        } else {
            throw new RuntimeException("Adult Member Not Found");
        }
    }

    public void deleteAdultMember(Long id) {
        adultMemberRepository.deleteById(id);
    }
}
