package br.com.jr.challenge_forumhub.exception;

public class ResourceExisteException extends RuntimeException {
    public ResourceExisteException(String mensagem) {
        super(mensagem);
    }
}
