package bzh.amzerin.openD6.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bzh.amzerin.openD6.bo.Member;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UtilisateurSpringSecurity implements UserDetails {

    private Member member;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (member.isAdmin()) {
            return List.of(new SimpleGrantedAuthority("ROLE_admin"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_user"));
        }
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getPseudo();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}