package br.com.fabricio.consumirgit.service.impl;

import br.com.fabricio.consumirgit.model.Programadores;
import br.com.fabricio.consumirgit.service.ProgramadoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ProgramadoresServiceImpl implements ProgramadoresService {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:7777";

    @Override
    public Programadores findAll() {
        Programadores programadores = restTemplate.getForObject(URL + "/list", Programadores.class);
        return programadores;
    }

    @Override
    public Programadores findById() {
        return null;
    }
}
