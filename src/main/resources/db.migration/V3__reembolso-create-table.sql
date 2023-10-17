CREATE TABLE Reembolso (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           valor DOUBLE NOT NULL,
                           motivo VARCHAR(255),
                           estado VARCHAR(255),
                           dataReembolso DATE,
                           id_funcionario INT,
                           FOREIGN KEY (id_funcionario) REFERENCES Funcionario(id)
);
