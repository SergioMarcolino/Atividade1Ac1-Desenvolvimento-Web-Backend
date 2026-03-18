package com.example.atividade1aac1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atividade1aac1.models.Curso;
import com.example.atividade1aac1.repository.CursoRepository;

import jakarta.persistence.EntityManager;

@RestController
@RequestMapping("/api")
public class CursoController {
    @Autowired
    private EntityManager entityManager;

    @Autowired
        private CursoRepository cursoRepository;

    @PostMapping("/inserirCurso")
    @Transactional
    public Curso salvar(@RequestBody Curso curso) {  
        return cursoRepository.salvar(curso);
    }

    @GetMapping("/listarCurso")  
    public List<Curso> mostrarTodos() {
        return entityManager.createQuery(
                "FROM Curso c", Curso.class)  
                .getResultList();
    }

}
