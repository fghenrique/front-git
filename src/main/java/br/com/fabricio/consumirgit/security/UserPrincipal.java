package br.com.fabricio.consumirgit.security;

import br.com.fabricio.consumirgit.model.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
    private Logger log = LoggerFactory.getLogger(UserPrincipal.class);
    private Usuarios usuarios;

    public UserPrincipal(Usuarios usuarios){
        this.usuarios = usuarios;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        List<GrantedAuthority> autorities = usuarios.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getNome()))
                .peek(autority -> log.info("Role: " + autority))
                .collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.usuarios.getPassword();
    }

    @Override
    public String getUsername() {
        return this.usuarios.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
