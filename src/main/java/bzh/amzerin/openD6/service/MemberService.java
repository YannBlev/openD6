package bzh.amzerin.openD6.service;

import java.util.List;
import bzh.amzerin.openD6.bo.Member;

public interface MemberService {
	List<Member> getMembers();
	Member getMemberById(int id);
	void createMember(Member member);
	void deleteMemberById(int id);
	Member getMemberByPseudo(String pseudo);
}
