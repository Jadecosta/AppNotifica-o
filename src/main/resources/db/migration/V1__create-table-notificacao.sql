CREATE TABLE notificacoes(
    id bigserial PRIMARY KEY,
    titulo VARCHAR(125) NOT NULL,
    mensagem VARCHAR(500) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_envio TIMESTAMP NOT NULL,
    enviado BOOLEAN DEFAULT FALSE,
    envio_cancelado BOOLEAN DEFAULT FALSE
);