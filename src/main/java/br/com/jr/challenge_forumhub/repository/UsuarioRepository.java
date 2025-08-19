package br.com.jr.challenge_forumhub.repository;

import br.com.jr.challenge_forumhub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
