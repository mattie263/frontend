package uk.ac.sheffield.team10.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import uk.ac.sheffield.team10.model.ChildMember;
import uk.ac.sheffield.team10.repository.ChildMemberRepository;

@Service
public class ChildMemberService {
    private final ChildMemberRepository childMemberRepository;

    public ChildMemberService(ChildMemberRepository childMemberRepository) {
        this.childMemberRepository = childMemberRepository;
    }

    public List<ChildMember> getAllChildMembers() {
        return childMemberRepository.findAll();
    }

    public Optional<ChildMember> getChildMemberById(Long id) {
        return childMemberRepository.findById(id);
    }

    public ChildMember saveChildMember(ChildMember childMember) {
        return childMemberRepository.save(childMember);
    }

    public ChildMember updateChildMember(Long id, ChildMember updatedChildMember) {
        Optional<ChildMember> childMemberOptional = childMemberRepository.findById(id);
        if (childMemberOptional.isPresent()) {
            ChildMember childMember = childMemberOptional.get();
            childMember.setFirstName(updatedChildMember.getFirstName());
            childMember.setLastName(updatedChildMember.getLastName());
            childMember.setParentId(updatedChildMember.getParentId());
            return childMemberRepository.save(childMember);
        } else {
            throw new RuntimeException("Child Member Not Found -> id=" + id);
        }
    }

    public void deleteChildMember(Long id) {
        childMemberRepository.deleteById(id);
    }
}
