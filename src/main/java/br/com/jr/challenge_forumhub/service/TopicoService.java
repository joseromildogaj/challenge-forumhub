package br.com.jr.challenge_forumhub.service;

import br.com.jr.challenge_forumhub.dto.TopicoForm;
import br.com.jr.challenge_forumhub.model.Topico;

import java.util.List;

public interface TopicoService {

    Topico criarTopico(String titulo, String mensagem, Long cursoId, Long usuarioId);

    List<Topico> listarTopicos();

    Topico buscarTopicoPorId(Long id);

    Topico atualizarTopico(Long id, TopicoForm topicoForm);

    List<Topico> listar10PrimeirosTopicos();

    void deletarTopico(Long id);

}
