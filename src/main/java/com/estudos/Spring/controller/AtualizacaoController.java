package com.estudos.Spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atualizacao")
public class AtualizacaoController {
    @GetMapping
    public String getRegistros() {
        return """
            [{
                "nome": "Rafael",
                "horario": "14:00:00",
                "imagem": "-"
             },
             {
                "nome": "Gislene",
                "horario": "14:00:00",
                "imagem": "-"
            }]
        """;
    }

}
