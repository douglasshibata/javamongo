package br.com.alura.escolaalura.javamongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.alura.escolaalura.javamongo.models.Aluno;
import br.com.alura.escolaalura.javamongo.repositories.AlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository repositorio;

    @GetMapping("/aluno/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/cadastrar";
    }

    @PostMapping("/aluno/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        repositorio.salvar(aluno); // salvando o aluno
        return "redirect: /";
    }
}
