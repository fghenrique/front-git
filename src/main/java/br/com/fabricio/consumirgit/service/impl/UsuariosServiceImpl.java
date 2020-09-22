package br.com.fabricio.consumirgit.service.impl;

import br.com.fabricio.consumirgit.client.UsuariosClientRest;
import br.com.fabricio.consumirgit.model.Usuarios;
import br.com.fabricio.consumirgit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosClientRest usrRest;

    @Override
    public List<Usuarios> findAll() {
        return (List<Usuarios>) usrRest.list();
    }

    @Override
    public Usuarios findById(Integer id) {
        return usrRest.user(id);
    }

    @Override
    public Usuarios findByUsername(String username) {
        return usrRest.username(username);
    }

    @Override
    public Usuarios save(Usuarios usuarios) {return usrRest.save(usuarios);}

    @Override
    public void deleteById(Integer id) {
        usrRest.deleteById(id);
    }
}