package br.com.fabricio.consumirgit.controller;

import br.com.fabricio.consumirgit.model.Roles;
import br.com.fabricio.consumirgit.model.Usuarios;
import br.com.fabricio.consumirgit.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("usuario")
public class UsuariosController extends Base<Usuarios> {

    public UsuariosController() {
        this.URL_LIST = "public/list/list_usuario";
        this.URL_FORM = "public/form/form_usuario";
        this.TITLE_LIST = "Lista de usuários";
        this.TITLE_NEW = "Novo usuário";
        this.TITLE_EDIT = "Editar usuário";
        this.SINGLE_OBJECT = "usuario";
        this.FORM_OBJECT_NAME = "Usuário";
        this.LIST_OBJECT = "usuarios";
        this.SUCCESS_MESSAGE = "Usuário cadastrada com sucesso!";
        this.EDITABLE_MESSAGE = "Usuário alterado com sucesso!";
    }

    @Autowired
    private UsuariosService ursService;

    private List<Usuarios> listaUsuarios = null;

    @GetMapping(value = "/novo")
    public ModelAndView Novo() {
        Usuarios usuario = new Usuarios();
        return newFormPage(usuario);
    }

    @PostMapping(value = "/novo")
    public ModelAndView Novo(Usuarios usuario) {
        Roles role = new  Roles("ROLE_USER");
        List<Roles> roles = Arrays.asList(role);
        usuario.setRoles(roles);
        reiniciarVariaveisDeClasseESalvarUsuarios(usuario);
        return listPageSuccess(ursService.findAll(), SUCCESS_MESSAGE);
    }

    @GetMapping("/list")
    public ModelAndView listar() {
        if (Objects.isNull(listaUsuarios))
            listaUsuarios = ursService.findAll();
        return listPage(listaUsuarios);
    }

    @GetMapping("editar")
    public ModelAndView editar(@RequestParam("id") Integer id) {
        Usuarios usuario = ursService.findById(id);
        if (!Objects.isNull(usuario)) {
            usuario.setPersistido(true);
            return editFormPage(usuario);
        }
        if (Objects.isNull(listaUsuarios))
            listaUsuarios = ursService.findAll();
        return listPageSuccess(listaUsuarios, "Não foi possível editar esse item");
    }

    @PostMapping("editar")
    public ModelAndView editar(Usuarios usuario) {
        reiniciarVariaveisDeClasseESalvarUsuarios(usuario);
        listaUsuarios = ursService.findAll();
        return listPageSuccess(listaUsuarios, EDITABLE_MESSAGE);
    }

    @GetMapping("remover")
    public ModelAndView remover(@RequestParam("id") Integer id) {
        ursService.deleteById(id);
        listaUsuarios = ursService.findAll();
        return listPage(listaUsuarios);
    }

    public void reiniciarVariaveisDeClasseESalvarUsuarios(Usuarios usuario) {
        ursService.save(usuario);
        this.listaUsuarios = null;
    }
}
