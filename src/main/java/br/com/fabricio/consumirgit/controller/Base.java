package br.com.fabricio.consumirgit.controller;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class Base<T> {

    protected String URL_LIST         = "list_perfil";
    protected String URL_FORM         = "form_perfil";
    protected String TITLE_LIST       = "Lista de Perfis";
    protected String TITLE_NEW        = "Novo Perfil";
    protected String TITLE_EDIT       = "Editar Perfil";
    protected String SINGLE_OBJECT    = "perfil";
    protected String FORM_OBJECT_NAME = "Perfil";
    protected String LIST_OBJECT      = "perfis";
    protected String SUCCESS_MESSAGE  = "perfis";
    protected String EDITABLE_MESSAGE = "perfis";

    protected ModelAndView listPage(List<T> list) {
        ModelAndView modelAndView = new ModelAndView(URL_LIST);
        modelAndView.addObject("FRM", TITLE_LIST);
        modelAndView.addObject("FORM_OBJECT_NAME", FORM_OBJECT_NAME);
        modelAndView.addObject(LIST_OBJECT, list);
        return modelAndView;
    }
    protected ModelAndView listPageSuccess(List<T> list, String message) {
        ModelAndView modelAndView = new ModelAndView(URL_LIST);
        modelAndView.addObject("FRM", TITLE_LIST);
        modelAndView.addObject("message", message);
        modelAndView.addObject("alertClass", "alert-success");
        modelAndView.addObject(LIST_OBJECT, list);
        return modelAndView;
    }
    protected ModelAndView newFormPage(T object) {
        ModelAndView modelAndView = new ModelAndView(URL_FORM);
        modelAndView.addObject("FRM", TITLE_NEW);
        modelAndView.addObject("FORM_OBJECT_NAME", FORM_OBJECT_NAME);
        modelAndView.addObject(SINGLE_OBJECT, object);
        return modelAndView;
    }
    protected ModelAndView editFormPage(T object) {
        ModelAndView modelAndView = new ModelAndView(URL_FORM);
        modelAndView.addObject("FRM", TITLE_EDIT);
        modelAndView.addObject("FORM_OBJECT_NAME", FORM_OBJECT_NAME);
        modelAndView.addObject(SINGLE_OBJECT, object);
        return modelAndView;
    }
}