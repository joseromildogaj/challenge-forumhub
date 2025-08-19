package br.com.jr.challenge_forumhub.repository;

import br.com.jr.challenge_forumhub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(Long id);
}
