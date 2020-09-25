package br.com.fabricio.consumirgit.security;

import br.com.fabricio.consumirgit.model.Usuarios;
import br.com.fabricio.consumirgit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    @Autowired
    private UsuariosService usrService ;

    public UserPrincipalDetailsService(UsuariosService usrService) {
        this.usrService = usrService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       if(!s.equals("")){
           Usuarios usuarios = this.usrService.findByUsername(s);
           if(Objects.isNull(usuarios))
               throw new UsernameNotFoundException("Usuário não encontrado");
           UserPrincipal userPrincipal = new UserPrincipal(usuarios);
           if(Objects.isNull(userPrincipal))
               throw new UsernameNotFoundException("Usuário não encontrado");
           else
           return userPrincipal;
       }else
           throw new UsernameNotFoundException("Usuário não encontrado");
    }
}
