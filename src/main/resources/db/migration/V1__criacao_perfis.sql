CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE perfis (
 id SMALLINT PRIMARY KEY AUTO_INCREMENT,
 descricao VARCHAR(255),
 nome VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE usuarios_perfis (
 usuarios_id INT NOT NULL,
 perfis_id SMALLINT NOT NULL,
 CONSTRAINT FK_perfil FOREIGN KEY (perfis_id) REFERENCES perfis(id),
 CONSTRAINT FK_usuario FOREIGN KEY (usuarios_id) REFERENCES usuarios(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


INSERT INTO usuarios (id, nome, email, senha) VALUES(1, 'David', 'david@loja.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO usuarios (id, nome, email, senha) VALUES(2, 'Jhonatan', 'jhonatan@gmail.com', '$2a$10$sFKmbxbG4ryhwPNx/l3pgOJSt.fW1z6YcUnuE2X8APA/Z3NI/oSpq');

INSERT INTO perfis (id, descricao, nome) VALUES(1,'perfil_loja', 'ROLE_LOJA');
INSERT INTO perfis (id, descricao, nome) VALUES(2,'perfil_cliente','ROLE_CLIENTE');

INSERT INTO usuarios_perfis (usuarios_id,perfis_id) VALUES(1,1);
INSERT INTO usuarios_perfis (usuarios_id,perfis_id) VALUES(2,2);