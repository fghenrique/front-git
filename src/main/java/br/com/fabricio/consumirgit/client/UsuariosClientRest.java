package br.com.fabricio.consumirgit.client;


import br.com.fabricio.consumirgit.model.Usuarios;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "api.git", url = "localhost:7777/user")
public interface UsuariosClientRest {

    @GetMapping("/list")
    List<Usuarios> list();

    @GetMapping("/{id}")
    Usuarios user(@PathVariable("id") Integer id);

    @GetMapping("/username/{username}")
    Usuarios username(@PathVariable("username") String username);

    @PostMapping("/save")
    Usuarios save(@RequestBody Usuarios usuarios);

    @GetMapping("/delete/{id}")
    void deleteById(@PathVariable("id") Integer id);
}
