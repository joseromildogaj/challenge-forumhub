package br.com.jr.challenge_forumhub.service;

import br.com.jr.challenge_forumhub.dto.UsuarioForm;
import br.com.jr.challenge_forumhub.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario criarUsuario(UsuarioForm form);

    List<Usuario> listarUsuarios();

    Usuario buscarUsuarioPorId(Long id);

    void deletarUsuario(Long id);

    Usuario atualizarUsuario(Long id, UsuarioForm usuarioForm);

}
