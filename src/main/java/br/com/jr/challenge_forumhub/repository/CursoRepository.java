package br.com.jr.challenge_forumhub.repository;

import br.com.jr.challenge_forumhub.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}