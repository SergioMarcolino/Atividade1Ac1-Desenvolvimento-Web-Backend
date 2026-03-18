package com.example.atividade1aac1.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;  
import org.springframework.transaction.annotation.Transactional;  
import com.example.atividade1aac1.models.Curso;
import jakarta.persistence.EntityManager;

@Repository  
public class CursoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso salvar(Curso curso) {
        return entityManager.merge(curso);
    }

    public List<Curso> mostrarTodos() {  
        return entityManager.createQuery("FROM Curso c", Curso.class)  
                .getResultList();
    }

    @Transactional
    public Curso atualizarCurso(Long id, Curso dadosAtualizados) {
        Curso curso = buscarPorId(id);
        if (curso != null) {
            curso.setNome(dadosAtualizados.getNome());
            return entityManager.merge(curso);
        }
        return null;
    }

    public Curso buscarPorId(Long id) {
        return entityManager.find(Curso.class, id);
    }

    @Transactional
    public void excluir(Long id) {
        Curso curso = buscarPorId(id);
        if (curso != null) {  
            entityManager.remove(curso);
        }
    }
}
