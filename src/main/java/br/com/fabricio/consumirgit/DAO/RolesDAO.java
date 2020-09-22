package br.com.fabricio.consumirgit.DAO;

import br.com.fabricio.consumirgit.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDAO extends JpaRepository<Roles, Long> {}
