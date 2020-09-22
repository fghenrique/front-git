package br.com.fabricio.consumirgit.DAO;

import br.com.fabricio.consumirgit.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuarios, Integer> {
    Usuarios findByUsername(String username);
}
