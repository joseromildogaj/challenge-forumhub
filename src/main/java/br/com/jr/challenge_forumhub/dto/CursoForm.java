package br.com.jr.challenge_forumhub.dto;

import br.com.jr.challenge_forumhub.model.Curso;
import jakarta.validation.constraints.NotBlank;

public record CursoForm(
        @NotBlank(message = "O nome do curso não pode estar em branco")
        String nome,

        @NotBlank(message = "A categoria do curso não pode estar em branco")
        String categoria
) {

    public Curso toCurso() {
        Curso curso = new Curso();
        curso.setNome(this.nome);
        curso.setCategoria(this.categoria);
        return curso;
    }
}
