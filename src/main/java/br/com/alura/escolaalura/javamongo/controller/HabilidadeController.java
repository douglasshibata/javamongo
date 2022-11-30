package br.com.alura.escolaalura.javamongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.alura.escolaalura.javamongo.models.Aluno;
import br.com.alura.escolaalura.javamongo.models.Habilidade;
import br.com.alura.escolaalura.javamongo.repositories.AlunoRepository;

@Controller
public class HabilidadeController {

    @Autowired
    private AlunoRepository repositorio;

    @GetMapping("habilidade/salvar/{id}")
    public String cadastrar(@PathVariable String id, Model model) {
        Aluno aluno = repositorio.obterAlunoPor(id);
        model.addAttribute("aluno", aluno);
        model.addAttribute("habilidade", new Habilidade());
        return "habilidade/cadastrar";
    }
}