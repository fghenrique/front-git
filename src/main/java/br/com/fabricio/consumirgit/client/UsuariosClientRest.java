package br.com.fabricio.consumirgit.client;


import br.com.fabricio.consumirgit.model.Usuarios;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api.git", url = "localhost:7777/user")
public interface UsuariosClientRest {

    @GetMapping("/list")
    List<Usuarios> list();

    @GetMapping("/{id}")
    public Usuarios user(@PathVariable("id") Integer id);

    @GetMapping("/username/{username}")
    public Usuarios username(@PathVariable("username") String username);
}
