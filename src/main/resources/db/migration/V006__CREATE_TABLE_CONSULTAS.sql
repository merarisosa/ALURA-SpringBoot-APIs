CREATE TABLE consulta (
    id BIGSERIAL PRIMARY KEY,
    medico_id BIGINT NOT NULL,
    paciente_id BIGINT NOT NULL,
    data TIMESTAMP NOT NULL,

    CONSTRAINT fk_medico FOREIGN KEY (medico_id) REFERENCES medico(id),
    CONSTRAINT fk_paciente FOREIGN KEY (paciente_id) REFERENCES paciente(id)
);