package br.com.jr.challenge_forumhub.repository;

import br.com.jr.challenge_forumhub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
