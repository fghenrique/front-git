package br.com.fabricio.consumirgit.service;

import br.com.fabricio.consumirgit.model.Programadores;

import java.util.List;

public interface ProgramadoresService {
    List<Programadores> findAll();

    Programadores findById();
}
