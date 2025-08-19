package br.com.jr.challenge_forumhub.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String string) {
        super(string);
    }
}
