package br.com.jr.challenge_forumhub.dto;

import br.com.jr.challenge_forumhub.model.Usuario;

public record UsuarioResponseDto(
        Long id,
        String email
) {
    public UsuarioResponseDto(Usuario usuario) {
        this(usuario.getId(), usuario.getEmail());
    }
}
