package br.com.jr.challenge_forumhub.service;

import br.com.jr.challenge_forumhub.dto.UsuarioForm;
import br.com.jr.challenge_forumhub.exception.ResourceExisteException;
import br.com.jr.challenge_forumhub.exception.ResourceNotFoundException;
import br.com.jr.challenge_forumhub.model.Usuario;
import br.com.jr.challenge_forumhub.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements  UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario criarUsuario(UsuarioForm form) {
        if (usuarioRepository.existsByEmail(form.email())) {
            throw new ResourceExisteException("Usuário já cadastrado");
        }
        Usuario novoUsuario = new Usuario();
        novoUsuario.setEmail(form.email());
        String senhaCriptografada = passwordEncoder.encode(form.senha());
        novoUsuario.setSenha(senhaCriptografada);
        return usuarioRepository.save(novoUsuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário com o ID " + id + " não encontrado"));
    }

    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuário com o ID " + id + " não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizarUsuario(Long id, UsuarioForm usuarioForm) {
        if(!usuarioRepository.existsByEmail(usuarioForm.email())) {
            throw new ResourceNotFoundException("Usuário não cadastrado");
        }
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setEmail(usuarioForm.email());
        usuario.setSenha(passwordEncoder.encode(usuarioForm.senha()));
        return usuarioRepository.save(usuario);
    }
}