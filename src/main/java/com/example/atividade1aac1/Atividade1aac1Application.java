package com.example.atividade1aac1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.atividade1aac1.models.Aluno;
import com.example.atividade1aac1.models.Curso;
import com.example.atividade1aac1.repository.AlunoRepository;
import com.example.atividade1aac1.repository.CursoRepository;

@SpringBootApplication	
public class Atividade1aac1Application {

    @Bean
    public CommandLineRunner init(@Autowired AlunoRepository alunoRepository, 
                                  @Autowired CursoRepository cursoRepository) {
        return args -> {
            Curso c1 = cursoRepository.salvar(new Curso(null, "ADS"));
            Curso c2 = cursoRepository.salvar(new Curso(null, "Engenharia"));

            alunoRepository.salvar(new Aluno(null, "João", 2010, c1.getId().intValue()));
            alunoRepository.salvar(new Aluno(null, "Cleber", 2011, c2.getId().intValue()));

            List<Aluno> listaAluno = alunoRepository.listar();
            listaAluno.forEach(System.out::println);

            List<Curso> listaCurso = cursoRepository.mostrarTodos();
            listaCurso.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Atividade1aac1Application.class, args);
    }
}
