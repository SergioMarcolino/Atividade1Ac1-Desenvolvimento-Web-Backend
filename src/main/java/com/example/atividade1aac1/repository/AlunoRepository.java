package com.example.atividade1aac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.atividade1aac1.models.Aluno;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AlunoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional  
    public Aluno salvar(Aluno aluno) {
        return entityManager.merge(aluno);
    }

    public List<Aluno> listar() { 
        return entityManager.createQuery(
                "FROM Aluno p", Aluno.class).
                getResultList();
    }

    public Aluno atualizarAluno(Long id, Aluno dadosAtualizados) {
        Aluno aluno = buscarPorId(id);
        if (aluno != null) {
            aluno.setNome(dadosAtualizados.getNome());
            aluno.setAnoIngreso(dadosAtualizados.getAnoIngreso());
            aluno.setIdCurso(dadosAtualizados.getIdCurso());
            
            return entityManager.merge(aluno);
        }
        return null;
    }

    public Aluno buscarPorId(Long id) {
        return entityManager.find(Aluno.class, id);
    }
    public void excluir(Long id) {
        Aluno aluno =buscarPorId(id);
        if (aluno !=null) {
            entityManager.remove(aluno);
        }
    }
    
}

