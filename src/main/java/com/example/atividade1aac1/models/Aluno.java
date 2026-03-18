package com.example.atividade1aac1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tbl_alunos") 
public class Aluno {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoIngreso;
    @Transient
    private Integer idCurso;
    
    @ManyToOne
    @JoinColumn(name="id_curso")
    private Curso curso;
    
    public Aluno(Long id, String nome, Integer anoIngreso, Integer idCurso) {
        this.id = id;
        this.nome = nome;
        this.anoIngreso = anoIngreso;
        this.idCurso = idCurso;
    }
    public Aluno() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getAnoIngreso() {
        return anoIngreso;
    }
    public void setAnoIngreso(Integer anoIngreso) {
        this.anoIngreso = anoIngreso;
    }
    public Integer getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }
    @Override
    public String toString() {
        return "Aluno [id=" + id + ", nome=" + nome + ", anoIngreso=" + anoIngreso + ", idCurso=" + idCurso + ", curso="
                + curso + "]";
    }
    
    
}
