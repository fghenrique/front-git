package br.com.fabricio.consumirgit.controller;

import br.com.fabricio.consumirgit.model.Programador;
import br.com.fabricio.consumirgit.service.ProgramadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("programadores")
public class GitController extends Base<Programador> {

    public GitController() {
        this.URL_LIST = "git/list/list_programadores";
        this.URL_FORM = "git/form/form_programadores";
        this.TITLE_LIST = "Lista de programadores";
        this.TITLE_NEW = "Novo programadores";
        this.TITLE_EDIT = "Editar programadores";
        this.SINGLE_OBJECT = "programador";
        this.FORM_OBJECT_NAME = "Programadores";
        this.LIST_OBJECT = "programadores";
        this.SUCCESS_MESSAGE = "Programadores cadastrada com sucesso!";
        this.EDITABLE_MESSAGE = "Programadores alterado com sucesso!";
    }

    @Autowired
    private ProgramadoresService prsService;

    private List<Programador> listaProgramador = null;

    @GetMapping("/list")
    public ModelAndView listar() {
        if (Objects.isNull(listaProgramador))
            listaProgramador = prsService.findAll().getItems();
        return listPage(listaProgramador);
    }
}