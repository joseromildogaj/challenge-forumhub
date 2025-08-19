package br.com.jr.challenge_forumhub.service;

import br.com.jr.challenge_forumhub.dto.TopicoForm;
import br.com.jr.challenge_forumhub.exception.ResourceExisteException;
import br.com.jr.challenge_forumhub.exception.ResourceNotFoundException;
import br.com.jr.challenge_forumhub.model.Curso;
import br.com.jr.challenge_forumhub.model.Topico;
import br.com.jr.challenge_forumhub.model.Usuario;
import br.com.jr.challenge_forumhub.repository.CursoRepository;
import br.com.jr.challenge_forumhub.repository.TopicoRepository;
import br.com.jr.challenge_forumhub.repository.UsuarioRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoServiceImpl implements TopicoService {

    private final TopicoRepository topicoRepository;
    private final CursoRepository cursoRepository;
    private final UsuarioRepository usuarioRepository;

    public TopicoServiceImpl(TopicoRepository topicoRepository, CursoRepository cursoRepository, UsuarioRepository usuarioRepository) {
        this.topicoRepository = topicoRepository;
        this.cursoRepository = cursoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Topico criarTopico(String titulo, String mensagem, Long cursoId, Long usuarioId) {
        Optional<Topico> topicoOptional = topicoRepository.findByTituloAndMensagem(titulo, mensagem);
        if (topicoOptional.isPresent()) {
            throw new ResourceExisteException("Tópico já cadastrado");
        }
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com o ID: " + cursoId));
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com o ID: " + usuarioId));

        Topico novoTopico = new Topico();
        novoTopico.setTitulo(titulo);
        novoTopico.setMensagem(mensagem);
        novoTopico.setCurso(curso);
        novoTopico.setUsuario(usuario);
        novoTopico.setStatus("Aberto");
        novoTopico.setDataCriacao(LocalDateTime.now());
        return topicoRepository.save(novoTopico);
    }

    @Override
    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }

    @Override
    public Topico buscarTopicoPorId(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isEmpty()) {
            throw new ResourceNotFoundException("Tópico com id " + id + " não encontrado");
        }
        return topico.get();
    }

    @Override
    public Topico atualizarTopico(Long id, TopicoForm topicoForm) {
        Topico topicoExistente = buscarTopicoPorId(id);
        Curso cursoOriginal = topicoExistente.getCurso();
        topicoExistente.setTitulo(topicoForm.titulo());
        topicoExistente.setMensagem(topicoForm.mensagem());
        Topico topicoAtualizado = topicoRepository.save(topicoExistente);
        topicoAtualizado.setCurso(cursoOriginal);
        return topicoAtualizado;
    }

    @Override
    public List<Topico> listar10PrimeirosTopicos() {
        List<Topico> topicos = topicoRepository.findAll(Sort.by(Sort.Direction.ASC, "dataCriacao"));
        return topicos.stream().limit(10).collect(Collectors.toList());
    }

    @Override
    public void deletarTopico(Long id) {
        topicoRepository.delete(buscarTopicoPorId(id));
    }
}