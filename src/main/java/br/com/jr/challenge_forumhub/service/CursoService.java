package br.com.jr.challenge_forumhub.service;

import br.com.jr.challenge_forumhub.model.Curso;
import java.util.List;

public interface CursoService {

    Curso criarCurso(Curso curso);

    List<Curso> listarCursos();

    Curso buscarCursoPorId(Long id);

    Curso atualizarCurso(Long id, Curso cursoAtualizado);

    void removerCurso(Long id);
}

