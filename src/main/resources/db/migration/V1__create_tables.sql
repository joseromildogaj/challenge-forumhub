CREATE TABLE cursos
(
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    nome      VARCHAR(255) NOT NULL UNIQUE,
    categoria VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE usuarios
(
    id    BIGINT       NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE topicos
(
    id           BIGINT       NOT NULL AUTO_INCREMENT,
    titulo       VARCHAR(255) NOT NULL,
    mensagem     VARCHAR(255) NOT NULL,
    data_criacao DATETIME     NOT NULL,
    status       VARCHAR(255) NOT NULL,
    curso_id     BIGINT,
    usuario_id   BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (curso_id) REFERENCES cursos (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios (id)
);