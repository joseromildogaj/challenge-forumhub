package br.com.jr.challenge_forumhub.dto;

import br.com.jr.challenge_forumhub.model.Curso;

public record CursoResponseDto(
        Long id,
        String nome,
        String categoria
) {

    public CursoResponseDto(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}