CREATE TABLE usuario (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(300) NOT NULL
);
