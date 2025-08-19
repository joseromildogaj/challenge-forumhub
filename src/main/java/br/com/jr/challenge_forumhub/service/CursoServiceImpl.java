package br.com.jr.challenge_forumhub.service;

import br.com.jr.challenge_forumhub.exception.ResourceNotFoundException;
import br.com.jr.challenge_forumhub.model.Curso;
import br.com.jr.challenge_forumhub.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements  CursoService {

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarCursoPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isEmpty()) {
            throw new ResourceNotFoundException("Curso com ID " + id + " nao encontrado");
        }
        return curso.get();
    }

    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {
        Curso curso = buscarCursoPorId(id);
        curso.setNome(cursoAtualizado.getNome());
        curso.setCategoria(cursoAtualizado.getCategoria());
        return cursoRepository.save(curso);
    }

    public void removerCurso(Long id) {
        Curso curso = buscarCursoPorId(id);
        cursoRepository.delete(curso);
    }

}