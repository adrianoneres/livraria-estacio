-- Cria tabela usuarios
CREATE TABLE usuarios(
    id SERIAL,
    nome VARCHAR(250),
    login VARCHAR(250),
    senha VARCHAR(100),
    PRIMARY KEY(id)
);

-- Insere um usuario
INSERT INTO usuarios(nome, login, senha) VALUES ('Tiao da Silva', 'tiao', 'e10adc3949ba59abbe56e057f20f883e'); -- senha: 123456

-- Cria tabela autores
CREATE TABLE autores(
    id SERIAL,
    nome VARCHAR(250),
    PRIMARY KEY(id)
);

-- Insere alguns autores
INSERT INTO autores(nome) VALUES ('Agatha Christie');
INSERT INTO autores(nome) VALUES ('Arthur Conan Doyle');
INSERT INTO autores(nome) VALUES ('J. K. Rowling');
INSERT INTO autores(nome) VALUES ('J. R. R. Tolkien');

-- Cria tabela produtos
CREATE TABLE produtos(
    id SERIAL,
    nome VARCHAR(250),
    tipo VARCHAR(15),
    descricao VARCHAR(500),
    preco NUMERIC(6, 2),
    data_vencimento DATE,
    id_autor INT,
    PRIMARY KEY(id)
);

ALTER TABLE produtos ADD CONSTRAINT produto_autor FOREIGN KEY (id_autor) REFERENCES autores (id);

-- Insere alguns produtos duraveis
INSERT INTO produtos(nome, tipo, descricao, preco) VALUES ('Régua transparente 30cm', 'DURAVEL', 'A melhor régua transparente de 30cm do mercado', 9.99);
INSERT INTO produtos(nome, tipo, descricao, preco) VALUES ('Grampeador', 'DURAVEL', 'Grampeador preto super-resistente', 19.99);
INSERT INTO produtos(nome, tipo, descricao, preco) VALUES ('Furador de papel', 'DURAVEL', 'Furador de papel simples: fure até 20 folhas simultâneas', 25.50);
INSERT INTO produtos(nome, tipo, descricao, preco) VALUES ('Pasta de elástico', 'DURAVEL', 'Organize seus papéis com esta excelente pasta de elástico', 1.99);

-- Insere alguns produtos nao duraveis
INSERT INTO produtos(nome, tipo, descricao, preco, data_vencimento) VALUES ('Marca-texto', 'NAO_DURAVEL', 'Cores vibrantes para a melhor marcação', 5.99, '2021-12-31');
INSERT INTO produtos(nome, tipo, descricao, preco, data_vencimento) VALUES ('Tinta guache', 'NAO_DURAVEL', 'Muita diversão para você e seus filhos', 8.99, '2021-01-01');
INSERT INTO produtos(nome, tipo, descricao, preco, data_vencimento) VALUES ('Chiclete Bolão', 'NAO_DURAVEL', 'Faça a maior bola de chiclete e impressione seus amigos', 0.25, '2020-10-31');
INSERT INTO produtos(nome, tipo, descricao, preco, data_vencimento) VALUES ('Refrigerante Polly', 'NAO_DURAVEL', 'Mate a sua sede com o melhor refrigerante', 3.55, '2020-08-15');

-- Insere alguns livros
INSERT INTO produtos(nome, tipo, descricao, preco, id_autor) VALUES ('Assassinato no Expresso do Oriente', 'LIVRO', 'Uma investigação empolgante', 11.99, 1);
INSERT INTO produtos(nome, tipo, descricao, preco, id_autor) VALUES ('Sherlock Holmes - Um estudo em vermelho', 'LIVRO', 'Acompanho o melhor detetive de Londres em mais uma aventura', 19.60, 2);
INSERT INTO produtos(nome, tipo, descricao, preco, id_autor) VALUES ('Harry Potter e a Pedra Filosofal', 'LIVRO', 'O início de uma aventura inesquecível', 27.99, 3);
INSERT INTO produtos(nome, tipo, descricao, preco, id_autor) VALUES ('O Senhor dos Anéis - A Sociedade do Anel', 'LIVRO', 'Uma história de aventura, magia e muita ação', 18.99, 4);