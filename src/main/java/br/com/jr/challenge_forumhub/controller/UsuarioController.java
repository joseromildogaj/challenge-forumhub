package br.com.jr.challenge_forumhub.controller;

import br.com.jr.challenge_forumhub.dto.UsuarioForm;
import br.com.jr.challenge_forumhub.dto.UsuarioResponseDto;
import br.com.jr.challenge_forumhub.model.Usuario;
import br.com.jr.challenge_forumhub.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> criarUsuario(@RequestBody @Valid UsuarioForm usuarioForm) {
        //Usuario usuario = usuarioForm.toUsuario();
        Usuario novoUsuario = usuarioService.criarUsuario(usuarioForm);
        return new ResponseEntity<>(new UsuarioResponseDto(novoUsuario), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        List<UsuarioResponseDto> responseDtos = usuarios.stream()
                .map(UsuarioResponseDto::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responseDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        return new ResponseEntity<>(new UsuarioResponseDto(usuario), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioForm usuarioForm) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, usuarioForm);
        return new ResponseEntity<>(new UsuarioResponseDto(usuarioAtualizado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
