package br.com.jr.challenge_forumhub.dto;

import br.com.jr.challenge_forumhub.model.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TopicoForm(
        @NotBlank(message = "O título não pode estar em branco")
        @Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres")
        String titulo,

        @NotBlank(message = "A mensagem não pode estar em branco")
        String mensagem,

        @NotNull(message = "O ID do curso é obrigatório")
        Long cursoId,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long usuarioId
) {

    public Topico toTopico() {
        Topico topico = new Topico();
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        topico.setStatus("ABERTO");
        topico.setId(this.cursoId);
        return topico;
    }
}