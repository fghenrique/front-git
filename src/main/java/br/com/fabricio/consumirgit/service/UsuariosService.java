package br.com.fabricio.consumirgit.service;

import br.com.fabricio.consumirgit.model.Usuarios;
import java.util.List;

public interface UsuariosService {
    List<Usuarios> findAll();
    Usuarios findById(Integer id);
    Usuarios findByUsername(String username);
    Usuarios save(Usuarios usuarios);
    void deleteById(Integer id);
}
