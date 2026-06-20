package bzh.amzerin.openD6.dal.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import bzh.amzerin.openD6.bo.Member;
import bzh.amzerin.openD6.dal.MemberDao;

@Repository
@AllArgsConstructor
public class MemberDaoMock implements MemberDao {

    private static List<Member> members = new ArrayList<>();
    private static int indexMember = 1;
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (members.isEmpty()) {

            Member alpha = new Member(
                    indexMember++,
                    "alpha",
                    passwordEncoder.encode("123")
            );

            Member beta = new Member(
                    indexMember++,
                    "beta",
                    passwordEncoder.encode("123")
            );

            Member charlie = new Member(
                    indexMember++,
                    "charlie",
                    passwordEncoder.encode("123")
            );

            Member admin = new Member(
                    indexMember++,
                    "admin",
                    passwordEncoder.encode("admin123")
            );
            admin.setAdmin(true);

            members.add(alpha);
            members.add(beta);
            members.add(charlie);
            members.add(admin);
        }
    }

    @Override
    public List<Member> getMembers() {
        return members;
    }

    @Override
    public Member getMemberById(int id) {
        return members.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void createMember(Member member) {
        member.setId(indexMember++);
        members.add(member);
    }

    @Override
    public void deleteMemberById(int id) {
        members.removeIf(m -> m.getId() == id);
    }

    @Override
    public Member getMemberByPseudo(String pseudo) {
        if (pseudo == null) {
            return null;
        }

        String normalized = pseudo.trim();

        return members.stream()
                .filter(m -> normalized.equalsIgnoreCase(m.getPseudo()))
                .findFirst()
                .orElse(null);
    }
}