package br.com.alura.escolaalura.javamongo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeolocalizacaoController {

    @GetMapping("/geolocalizacao/iniciarpesquisa")
    public String inicializarPesquisa() {
        return "geolocalizacao/pesquisar";
    }

}