package br.com.fabricio.consumirgit.security;

import br.com.fabricio.consumirgit.model.Usuarios;
import br.com.fabricio.consumirgit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UsuariosService usrService ;

    public UserPrincipalDetailsService(UsuariosService usrService) {
        this.usrService = usrService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuarios usuarios = this.usrService.findByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(usuarios);

        return userPrincipal;
    }
}
