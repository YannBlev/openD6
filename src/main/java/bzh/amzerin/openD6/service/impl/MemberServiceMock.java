package bzh.amzerin.openD6.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import bzh.amzerin.openD6.bo.Member;
import bzh.amzerin.openD6.dal.MemberDao;
import bzh.amzerin.openD6.service.MemberService;

@Service
@Profile("mock")
public class MemberServiceMock implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Member> getMembers() {
        return memberDao.getMembers();
    }

    @Override
    public Member getMemberById(int id) {
        return memberDao.getMemberById(id);
    }

    @Override
    public void createMember(Member member) {
        memberDao.createMember(member);
    }

    @Override
    public void deleteMemberById(int id) {
        memberDao.deleteMemberById(id);
    }

	@Override
	public Member getMemberByPseudo(String pseudo) {
		return memberDao.getMemberByPseudo(pseudo);
	}
}