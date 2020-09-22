package br.com.fabricio.consumirgit.DAO;

import br.com.fabricio.consumirgit.model.Roles;
import br.com.fabricio.consumirgit.model.Usuarios;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private UsuarioDAO usuarioDAO;
    private RolesDAO rolesDAO;
    private PasswordEncoder passwordEncoder;

    public DbInit(UsuarioDAO usuarioDAO, RolesDAO rolesDA, PasswordEncoder passwordEncoder) {
        this.usuarioDAO = usuarioDAO;
        this.rolesDAO = rolesDA;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.usuarioDAO.deleteAll();
        this.rolesDAO.deleteAll();

        Roles role = new Roles("ROLE_USER");
        Roles role2 = new Roles("ROLE_ADMIN");
        Roles role3 = new Roles("ROLE_MANAGER");

        List<Roles> roles = Arrays.asList(role, role2, role3);
        this.rolesDAO.saveAll(roles);

        Usuarios dan = new Usuarios("dan", passwordEncoder.encode("dan123"), roles);
        Usuarios admin = new Usuarios("admin", passwordEncoder.encode("admin123"), roles);
        Usuarios manager = new Usuarios("manager", passwordEncoder.encode("manager123"), roles);

        List<Usuarios> usuarios = Arrays.asList(dan, admin, manager);

        this.usuarioDAO.saveAll(usuarios);
    }
}
