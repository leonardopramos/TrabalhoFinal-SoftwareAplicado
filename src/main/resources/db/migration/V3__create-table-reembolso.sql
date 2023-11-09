CREATE TABLE reembolso (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    valor DOUBLE NOT NULL,
    motivo VARCHAR(255),
    estado VARCHAR(255),
    data_reembolso DATE,
    id_funcionario BIGINT,
    FOREIGN KEY (id_funcionario) REFERENCES funcionario(id)
);
