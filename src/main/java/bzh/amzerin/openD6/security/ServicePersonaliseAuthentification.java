package bzh.amzerin.openD6.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import bzh.amzerin.openD6.bo.Member;
import bzh.amzerin.openD6.service.MemberService;

@Service
public class ServicePersonaliseAuthentification implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {

        Member member = memberService.getMemberByPseudo(username);

        if (member == null) {
            throw new UsernameNotFoundException("Utilisateur introuvable");
        }

        return new UtilisateurSpringSecurity(member);
    }
}