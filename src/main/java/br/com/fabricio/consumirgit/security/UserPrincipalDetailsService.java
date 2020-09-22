package br.com.fabricio.consumirgit.security;

import br.com.fabricio.consumirgit.model.Usuarios;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import br.com.fabricio.consumirgit.DAO.UsuarioDAO;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    private UsuarioDAO usuarioDAO;

    public UserPrincipalDetailsService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuarios usuarios = this.usuarioDAO.findByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(usuarios);

        return userPrincipal;
    }
}
