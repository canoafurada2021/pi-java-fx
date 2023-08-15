DROP DATABASE IF EXISTS get_that_auto;

CREATE DATABASE IF NOT EXISTS get_that_auto;
-- Usa o banco de dados get_that_auto
USE get_that_auto;

CREATE TABLE IF NOT EXISTS `roles`(
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` ENUM('MASTER', 'FUNCIONARIO', 'CLIENTE') NOT NULL,
  PRIMARY KEY (`id`)
);
-- -----------------------------------------------------
-- Table .`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(45) NOT NULL, 
  `senha` VARCHAR(255) NOT NULL, 
  `role_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_usuario` (`cpf`),
  FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);

-- -----------------------------------------------------
-- Table .`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa` (
  `idempresa` INT NOT NULL AUTO_INCREMENT,
  `razaosocial` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `nomefantasia` VARCHAR(100) NOT NULL,
  `role_id` INT NOT NULL,
  `porteEmpresa` ENUM('pequena', 'média', 'grande') NOT NULL,
  
  PRIMARY KEY (`idempresa`),
    FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) -- Adicione a relação com a tabela roleUsuario

);




-- -----------------------------------------------------
-- Table .`vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendedores` (
  `idvendedores` INT NOT NULL,
  `salario` DOUBLE NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `role_id` INT NOT NULL, -- Adicione uma coluna para a chave estrangeira role_id
  PRIMARY KEY (`idvendedores`),
  FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) -- Adicione a relação com a tabela roleUsuario
);


-- -----------------------------------------------------
-- Table .`enderecos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enderecos` (
  `cep` INT NOT NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);

-- -----------------------------------------------------
-- Table .`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `locador` (
  `pessoas_cpf` INT NOT NULL,
  `telContato` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `enderecos_id` INT NOT NULL,
  `role_id` INT NOT NULL, -- Adicione uma coluna para a chave estrangeira role_id
  PRIMARY KEY (`pessoas_cpf`),
  FOREIGN KEY (`enderecos_id`) REFERENCES `enderecos` (`id`),
  FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) -- Adicione a relação com a tabela roleUsuario
);
-- -----------------------------------------------------
-- Table .`vendaRegistros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluguelRegistros` (
  `idvenda` INT NOT NULL,
  `formaPagamento` VARCHAR(45) NOT NULL,
  `dataInicio` DATETIME NOT NULL,
  `quantDias` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `vendedores_idvendedores` INT NOT NULL,
  `locador_pessoas_cpf` INT NOT NULL,
  PRIMARY KEY (
    `idvenda`,
    `vendedores_idvendedores`,
    `locador_pessoas_cpf`
  ),
  FOREIGN KEY (`vendedores_idvendedores`) REFERENCES `vendedores` (`idvendedores`),
  FOREIGN KEY (`locador_pessoas_cpf`) REFERENCES `locador` (`pessoas_cpf`)
);

-- -----------------------------------------------------
-- Table .`fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fornecedores` (
  `cnpj` INT NOT NULL,
  `enderecos_id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` INT NOT NULL,
  PRIMARY KEY (`cnpj`),
  FOREIGN KEY (`enderecos_id`) REFERENCES `enderecos` (`id`)
);
-- -----------------------------------------------------
-- Table .`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categorias` (
  `idcategorias` INT NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcategorias`)
);


-- -----------------------------------------------------
-- Table .`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veiculo`(
  `idVeiculo` INT NOT NULL,
  `quantAssento` INT NOT NULL,
  `tipoCambio` VARCHAR(45) NOT NULL,
  `quantPortas` INT NOT NULL,
  `espacoPortaMalas` INT NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `ano` INT NOT NULL,
  `notaAvaliacao` INT NOT NULL,
  `precoPorDia` INT NOT NULL,
  `imgBase64` VARCHAR(555) NOT NULL DEFAULT "",
  `unidadeEmEstoque` INT NOT NULL,
  `categorias_idcategorias` INT NOT NULL,
  `fornecedores_cnpj` INT NOT NULL,
  PRIMARY KEY (`idVeiculo`, `fornecedores_cnpj`),
  FOREIGN KEY (`categorias_idcategorias`) REFERENCES `categorias` (`idcategorias`),
  FOREIGN KEY (`fornecedores_cnpj`) REFERENCES `fornecedores` (`cnpj`)
);


insert into roles( nome) values('MASTER' );
insert into roles( nome) values('FUNCIONARIO' );
insert into roles( nome) values('CLIENTE' );


SELECT * FROM roles;
-- INSERTSSSSSSSSSSSSS -----------------------------------------------------------------------------------------
-- -------------------------------

-- INSERT TESSTE DE EMPRESA PRE CADASTRADA ------------------------------------------------------
-- -------------------------------------------------------------------------------------------------
insert into empresa (razaosocial, telefone, cnpj, nomefantasia, porteEmpresa, role_id) values ('O objetivo da empresa é deixar as pessoas felizes andando de gol', '+55 47 992178827', '12.345.678/0001-99', 'Pope Francis Master', 'grande', 1);
-- ------------------------------------------------------------------------------------------------------

-- inserts ENDERECOS
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('95560', '1', 'PO Box 26708', '9th Floor', 'PO Box 59776', '7th Floor');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('95590', '2', 'PO Box 74593', 'Suite 85', 'Apt 359', 'Room 630');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('9899', '3', 'Apt 1550', 'Apt 1844', 'Suite 82', 'Suite 87');

-- inserts CATEGORIAS
insert into categorias (idcategorias, categoria) values ('1', 'felis');
insert into categorias (idcategorias, categoria) values ('2', 'justo');
insert into categorias (idcategorias, categoria) values ('23', 'in lectus');
insert into categorias (idcategorias, categoria) values ('24', 'sapien');
insert into categorias (idcategorias, categoria) values ('25', 'semper');

-- inserts FORNECEDORES
insert into fornecedores (cnpj,  enderecos_id, nome, telefone) values (82, 1, 'João',  34244624); 
insert into fornecedores (cnpj,  enderecos_id, nome, telefone) values (83, 2, 'Bruno',  25152528); 

-- inserts VENDEDORES
INSERT INTO vendedores (idvendedores, salario, nome, sobrenome, role_id) VALUES (1, 2574.89, 'Patricia', 'Cordeiro', 2);
insert into vendedores (idVendedores, salario, nome, sobrenome,  role_id) values (2, 1883.12, 'Emily', 'Joanna Alves',2 );
insert into vendedores (idVendedores, salario, nome, sobrenome ,  role_id ) values (3,1883.16,'Andrieli','Mendes', 2);
insert into vendedores (idVendedores, salario, nome, sobrenome,  role_id) values (4, 1844.79, 'Emily', 'Neves', 2);

-- inserts LOCADOR
insert into locador (pessoas_cpf, telContato, nome,  sobrenome, enderecos_id, role_id) values ('212213454', '47988', 'Joanna', 'oldey',  1, 3);
insert into locador (pessoas_cpf,telContato, nome, sobrenome, enderecos_id, role_id) values ('768541784', '4798688', 'Miguela', 'Gettens', 3, 3);
insert into locador (pessoas_cpf,telContato, nome, sobrenome, enderecos_id, role_id) values ('103966036', '47984273', 'Olivia', 'Benedito', 2, 3);

-- inserts PRODUTOS
-- TESTE DE PRODUTO PRE CADASTRADO -------------------------------------------------
insert into veiculo (idVeiculo, quantAssento, tipoCambio, quantPortas, espacoPortaMalas, marca, nome, cor, ano, notaAvaliacao, precoPorDia, imgBase64, unidadeEmEstoque, categorias_idcategorias, fornecedores_cnpj) values (1, 5, 'Automático', 4, '4', 'Volkswagem', 'Gol', 'Vermelho', '2018', 5.0, 300, 'https://quatrorodas.abril.com.br/wp-content/uploads/2021/02/volkswagen_gol_5-door_25.jpeg?quality=70&strip=info', 5, 23, 82);
insert into veiculo (idVeiculo, quantAssento, tipoCambio, quantPortas, espacoPortaMalas, marca, nome, cor, ano, notaAvaliacao, precoPorDia, imgBase64, unidadeEmEstoque, categorias_idcategorias, fornecedores_cnpj) values (2, 5, 'Automático', 4, '3', 'Audi', 'A4', 'Prata', '2020', 4.0, 500, 'https://1.bp.blogspot.com/-wgZ8qbKzd3U/VmNo03r8GoI/AAAAAAACRI8/sxy7TjYLgYU/s640/Audi-S4-2016%2B%252812%2529.jpg', 2, 24, 83);
insert into veiculo (idVeiculo, quantAssento, tipoCambio, quantPortas, espacoPortaMalas, marca, nome, cor, ano, notaAvaliacao, precoPorDia, imgBase64, unidadeEmEstoque, categorias_idcategorias, fornecedores_cnpj) values (3, 5, 'Manual', 4, '4', 'Mercedes', 'Benz GLA', 'Preto', '2017', 4.5, 450, 'https://fotos-jornaldocarro-estadao.nyc3.cdn.digitaloceanspaces.com/uploads/2019/12/06111009/40918744-1160x773.jpg', 10, 25, 83);
insert into veiculo (idVeiculo, quantAssento, tipoCambio, quantPortas, espacoPortaMalas, marca, nome, cor, ano, notaAvaliacao, precoPorDia, imgBase64, unidadeEmEstoque, categorias_idcategorias, fornecedores_cnpj) values (4, 5, 'Manual', 4, '3', 'BMW', 'X1', 'Branco', '2019', 3.0, 250, 'https://cdn.autopapo.com.br/box/uploads/2022/06/07164434/bmw-x1-branca-estrada-frente-732x488.jpg', 20, 1, 82);
insert into veiculo (idVeiculo, quantAssento, tipoCambio, quantPortas, espacoPortaMalas, marca, nome, cor, ano, notaAvaliacao, precoPorDia, imgBase64, unidadeEmEstoque, categorias_idcategorias, fornecedores_cnpj) values (5, 5, 'Manual', 4, '3', 'Toyota', 'Corolla', 'Azul', '2022', 5.0, 700, 'https://www.agoramotor.com.br/wp-content/uploads/2021/07/Thiago-Carros.jpg', 1, 2, 82);

-- inserts ALUGUELREGISTROS
-- TESTE DE LOCAÇÃO PRE CADASTRADA -------------------------------------------------
insert into aluguelRegistros (idvenda, formaPagamento, dataInicio, quantDias, valor, vendedores_idvendedores, locador_pessoas_cpf) values (12, 'Cartão de Crédito em 5 vezes', '2005-10-24', 3, 300, 1, 212213454);

-- inserts LOGIN
-- TESTE DE POPE FRANCIS MASTER E 1 VENDEDOR PRE CADASTRADOS -------------------------------------------------
insert into login (id, cpf, senha,  role_id) values (1, '13093824923', '24102005', 1), (2, '04807428985', '19101984',2 );

-- --- CRIAR INSERTS PARA CRIACAO DE VEICULO NO SISTEMA 

SELECT * FROM login;
SELECT * FROM aluguelRegistros;
SELECT * FROM vendedores;
SELECT * FROM fornecedores;
SELECT * FROM enderecos;
SELECT * FROM empresa;
-- SELECTSSSSSSSSSSSSSSSSSS -----------------------------------------------------------------------------------------
-- -------------------------------


-- SELECT P LISTAGEM

