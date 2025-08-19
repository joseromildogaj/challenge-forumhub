package br.com.jr.challenge_forumhub.controller;

import br.com.jr.challenge_forumhub.dto.CursoForm;
import br.com.jr.challenge_forumhub.dto.CursoResponseDto;
import br.com.jr.challenge_forumhub.model.Curso;
import br.com.jr.challenge_forumhub.service.CursoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoServiceImpl cursoServiceImpl;

    public CursoController(CursoServiceImpl cursoServiceImpl) {
        this.cursoServiceImpl = cursoServiceImpl;
    }

    @PostMapping
    public ResponseEntity<CursoResponseDto> criarCurso(@RequestBody @Valid CursoForm cursoForm) {
        Curso curso = cursoServiceImpl.criarCurso(cursoForm.toCurso());
        return new ResponseEntity<>(new CursoResponseDto(curso), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> listarCursos() {
        List<Curso> cursos = cursoServiceImpl.listarCursos();
        List<CursoResponseDto> responseDtos = cursos.stream()
                .map(CursoResponseDto::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDto> buscarCursoPorId(@PathVariable Long id) {
        Curso curso = cursoServiceImpl.buscarCursoPorId(id);
        return new ResponseEntity<>(new CursoResponseDto(curso), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> atualizarTopico(@PathVariable Long id, @RequestBody CursoForm cursoForm) {
        Curso curso = cursoServiceImpl.atualizarCurso(id, cursoForm.toCurso());
        return new ResponseEntity<>(new CursoResponseDto(curso), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCurso(@PathVariable Long id) {
        cursoServiceImpl.removerCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
