package br.com.jr.challenge_forumhub.controller;

import br.com.jr.challenge_forumhub.dto.TopicoForm;
import br.com.jr.challenge_forumhub.dto.TopicoResponseDto;
import br.com.jr.challenge_forumhub.model.Topico;
import br.com.jr.challenge_forumhub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    public ResponseEntity<TopicoResponseDto> criarTopico(@RequestBody @Valid TopicoForm topicoForm) {
        Topico novoTopico = topicoService.criarTopico(
                topicoForm.titulo(),
                topicoForm.mensagem(),
                topicoForm.cursoId(),
                topicoForm.usuarioId()
        );
        return new ResponseEntity<>(new TopicoResponseDto(novoTopico), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<TopicoResponseDto>> buscarTopicos() {
        List<Topico> topicos = topicoService.listarTopicos();
        List<TopicoResponseDto> responseDtos = topicos.stream()
                .map(TopicoResponseDto::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDto> buscarTopicoPorId(@PathVariable Long id) {
        Topico topico = topicoService.buscarTopicoPorId(id);
        return new ResponseEntity<>(new TopicoResponseDto(topico), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponseDto> atualizarTopico(@PathVariable Long id,
                                                             @RequestBody @Valid TopicoForm topicoForm) {
        Topico topicoAtualizado = topicoService.atualizarTopico(id, topicoForm);
        return new ResponseEntity<>(new TopicoResponseDto(topicoAtualizado), HttpStatus.OK);
    }

    @GetMapping("/top10")
    public ResponseEntity<List<TopicoResponseDto>> listarTop10() {
        List<Topico> topicos = topicoService.listar10PrimeirosTopicos();
        return ResponseEntity.ok().body(topicos.stream().map(TopicoResponseDto::new)
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTopico(@PathVariable Long id) {
        topicoService.deletarTopico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
