package br.com.jr.challenge_forumhub.dto;

import br.com.jr.challenge_forumhub.model.Topico;

import java.time.LocalDateTime;

public record TopicoResponseDto(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String status,
        String nomeCurso,
        String emailAutor

) {

    public TopicoResponseDto(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                (topico.getCurso() != null) ? topico.getCurso().getNome() : null,
                topico.getUsuario().getEmail()
        );
    }
}
