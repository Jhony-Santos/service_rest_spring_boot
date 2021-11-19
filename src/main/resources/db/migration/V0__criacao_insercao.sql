
CREATE TABLE client(
    cpf VARCHAR(20) UNIQUE NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(10) NOT NULL,
    email VARCHAR(25) NOT NULL,
    logradouro VARCHAR(20) NOT NULL,
    numero VARCHAR(8) NOT NULL,
    complemento VARCHAR(50) NOT NULL,
    bairro VARCHAR(30) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    cidade VARCHAR(20) NOT NULL,
    estado VARCHAR(20) NOT NULL
);


INSERT INTO client(cpf,nome, telefone,email,logradouro,numero,complemento,bairro,cep,cidade,estado) values
('1234','Jhonatan','999999999','jntd@gft.com','Rua Javazão','1990','sem complemento','Santa Felicidade','787878','Curitiba','Paraná');

INSERT INTO client (cpf, nome, telefone, email, logradouro,numero,complemento,bairro,cep,cidade,estado) values
('12345','Vinicius','888888888','david@gft.com','Rua Instrutor','2021','ao lado da Fármacia','Mossunguê','343434','Curitiba','Paraná');

INSERT INTO client (cpf, nome, telefone, email, logradouro,numero,complemento,bairro,cep,cidade,estado) values
('123456','Matheus','77777777','einstein@gft.com','Rua Gênio','195','ao lado da Museu nacional','Batel','356732','Curitiba','Paraná');

INSERT INTO client (cpf, nome, telefone, email, logradouro,numero,complemento,bairro,cep,cidade,estado) values
('1234567','David','77777777','einstein@gft.com','Rua Gênio','195','ao lado da Museu nacional','Batel','356732','Curitiba','Paraná');

INSERT INTO client (cpf, nome, telefone, email, logradouro,numero,complemento,bairro,cep,cidade,estado) values
('12345678','Joaquina','77777777','einstein@gft.com','Rua Gênio','195','ao lado da Museu nacional','Batel','356732','Curitiba','Paraná');



CREATE TABLE seller(
    cnpj VARCHAR(20)  NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    telefone VARCHAR(12) NOT NULL,
    email VARCHAR(30) NOT NULL,
    logradouro VARCHAR(20) NOT NULL,
    numero VARCHAR(8) NOT NULL,
    complemento VARCHAR(50) NOT NULL,
    bairro VARCHAR(20) NOT NULL,
    cep VARCHAR(20) NOT NULL,
    cidade VARCHAR(20) NOT NULL,
    estado VARCHAR(20) NOT NULL

);

INSERT INTO seller(cnpj,nome,telefone,email,logradouro,numero,complemento,bairro,cep,cidade,estado) VALUES
('12345','Nike','90909090','nike@gmail.com','Rua nike', '209','em frente ao posto Ipiranga','Rebouças','8909922','Curitiba','Paraná'),
('54321','Adidas','88909090','adidas@gmail.com','Rua Adidas','134','santa no quintal','Parolin','87728','São Paulo','São Paulo'),
('54322','Dell','919293949','dell@gmail.com','Rua Dell','144','sem complemento','Boqueirão','872233','Belo Horizonte','Minas Gerais'),
('54344','Condor Supermercados','919293977','condor@gmail.com','Rua Condor','1200','sem complemento','Centro','8722133','São Paulo','Osasco');


CREATE TABLE product(
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(30) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    unidade VARCHAR(20) NOT NULL
);

INSERT INTO product(nome,descricao,unidade) values
('Tênis nike Air Force','cor preta nº 41','1 PAR'),
('Notebook Dell','Inspirion 15','1 UNIDADE'),
('HD Portátil Western','4TB, 40 Gramas','1 UNIDADE'),
('Leite consensado','product para fazer bolo','250 GRAMAS');



CREATE TABLE stock (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    valor DOUBLE NOT NULL,
    quantidade int not null,
    codigo_produto BIGINT(20) NOT NULL,
    FOREIGN KEY (codigo_produto) REFERENCES product(codigo)
);

INSERT INTO stock(valor,quantidade,codigo_produto) VALUES
(300, 1,1),
(7.237, 2,2),
(849.99, 4,3),
(5.00,3,4);


CREATE TABLE buy(
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    seller VARCHAR(20) NOT NULL,
    FOREIGN KEY (seller) REFERENCES seller(cnpj)
);

INSERT INTO buy(seller) values ('12345'), ('54321'), ('54322');


CREATE TABLE items_compra(
    id  BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    codigo_produto BIGINT(20) NOT NULL,
    codigo_compra BIGINT(20) NOT NULL,
    quantidade INT NOT NULL,
    valor DOUBLE NOT NULL,
    FOREIGN KEY (codigo_produto) REFERENCES product(codigo),
    FOREIGN KEY (codigo_compra) REFERENCES buy(id)
);

INSERT INTO items_compra(codigo_produto,codigo_compra,quantidade,valor) values
(1,1, 1, 250.00),
(2,2,3,14.00);

CREATE TABLE sale(
     id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
     client VARCHAR(20) NOT NULL,
     status BOOLEAN NOT NULL,
     FOREIGN KEY (client) REFERENCES client(cpf)
);

INSERT INTO sale(client,status) values ('1234',0), ('12345',0),('123456',0);


CREATE TABLE items_venda(
    id  BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    codigo_produto BIGINT(20) NOT NULL,
    codigo_venda BIGINT(20) NOT NULL,
    quantidade INT NOT NULL,
    valor DOUBLE NOT NULL,
    FOREIGN KEY (codigo_produto) REFERENCES product(codigo),
    FOREIGN KEY (codigo_venda) REFERENCES sale(id)
);

INSERT INTO items_venda(codigo_produto,codigo_venda,quantidade,valor) VALUES
(2, 1, 1, 1700),
(3, 2, 1, 830);











