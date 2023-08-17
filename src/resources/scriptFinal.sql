DROP DATABASE IF EXISTS get_that_auto;

CREATE DATABASE IF NOT EXISTS get_that_auto;
-- Usa o banco de dados get_that_auto
USE get_that_auto;


-- -----------------------------------------------------
-- Table .`login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `login` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(45) NOT NULL, 
  `senha` VARCHAR(255) NOT NULL, 
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_usuario` (`cpf`),
  `cargo` ENUM('MASTER', 'FUNCIONARIO', 'CLIENTE') NOT NULL -- Coluna para o cargo diretamente
);

-- -----------------------------------------------------
-- Table .`empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa` (
  `id_empresa` INT NOT NULL AUTO_INCREMENT,
  `razao_social` VARCHAR(100) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `nome_fantasia` VARCHAR(100) NOT NULL,
  `cargo` ENUM('MASTER', 'FUNCIONARIO', 'CLIENTE') NOT NULL, -- Coluna para o cargo diretamente
  `porte_empresa` ENUM('pequena', 'média', 'grande') NOT NULL,
  
  PRIMARY KEY (`id_empresa`)

);




-- -----------------------------------------------------
-- Table .`vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendedor` (
  `id_vendedor` INT NOT NULL,
  `salario` DOUBLE NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cargo` ENUM('MASTER', 'FUNCIONARIO', 'CLIENTE') NOT NULL, -- Coluna para o cargo diretamente
  PRIMARY KEY (`id_vendedor`)
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
  `tel_contato` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `cpf` INT NOT NULL,
  `enderecos_id` INT NOT NULL,
  `cargo` ENUM('MASTER', 'FUNCIONARIO', 'CLIENTE') NOT NULL, -- Coluna para o cargo diretamente
  PRIMARY KEY (`pessoas_cpf`),
  FOREIGN KEY (`enderecos_id`) REFERENCES `enderecos` (`id`)
);
-- -----------------------------------------------------
-- Table .`vendaRegistros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluguelRegistros` (
  `id_venda` INT NOT NULL,
  `forma_pagamento` VARCHAR(45) NOT NULL,
  `data_inicio` DATETIME NOT NULL,
  `quant_dias` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `vendedor_id_vendedor` INT NOT NULL,
  `locador_pessoas_cpf` INT NOT NULL,
  PRIMARY KEY (
    `id_venda`,
    `vendedor_id_vendedor`,
    `locador_pessoas_cpf`
  ),
  FOREIGN KEY (`vendedor_id_vendedor`) REFERENCES `vendedor` (`id_vendedor`),
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
  `pecaFonecida` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cnpj`),
  FOREIGN KEY (`enderecos_id`) REFERENCES `enderecos` (`id`)
);
-- -----------------------------------------------------
-- Table .`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` INT NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_categoria`)
);


-- -----------------------------------------------------
-- Table .`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veiculo`(
  `id_veiculo` INT NOT NULL,
  `quant_assento` INT NOT NULL,
  `tipo_cambio` VARCHAR(45) NOT NULL,
  `quant_portas` INT NOT NULL,
  `espaco_porta_malas` INT NOT NULL,
  `marca` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `ano` INT NOT NULL,
  `nota_avaliacao` INT NOT NULL,
  `preco_por_dia` INT NOT NULL,
  `img_Base64` VARCHAR(555) NOT NULL DEFAULT "",
  `unidade_em_estoque` INT NOT NULL,
  `categoria_id_categoria` INT NOT NULL,
  `fornecedores_cnpj` INT NOT NULL,
  PRIMARY KEY (`id_veiculo`, `fornecedores_cnpj`),
  FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`),
  FOREIGN KEY (`fornecedores_cnpj`) REFERENCES `fornecedores` (`cnpj`)
);




-- INSERT TESSTE DE EMPRESA PRE CADASTRADA ------------------------------------------------------
-- -------------------------------------------------------------------------------------------------
insert into empresa (razao_social, telefone, cnpj, nome_fantasia, porte_empresa, cargo) values ('O objetivo da empresa é deixar as pessoas felizes andando de gol', '+55 47 992178827', '12.345.678/0001-99', 'Pope Francis Master', 'grande', "MASTER");
-- ------------------------------------------------------------------------------------------------------

insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('95560', '1', 'PO Box 26708', '9th Floor', 'PO Box 59776', '7th Floor');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('95590', '2', 'PO Box 74593', 'Suite 85', 'Apt 359', 'Room 630');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('9899', '3', 'Apt 1550', 'Apt 1844', 'Suite 82', 'Suite 87');


INSERT INTO vendedor (id_vendedor, salario, nome,  cargo) VALUES (1, 2574.89, 'Patricia Cordeiro', 'FUNCIONARIO');


insert into locador (pessoas_cpf, tel_contato, nome, sobrenome, cpf, enderecos_id, cargo) values ('212213454', '47988', 'Emily Joanna',"Alves", 123456, 1, "CLIENTE");




-- inserts ENDERECOS

-- inserts CATEGORIAS
insert into categoria (id_categoria, categoria) values ('1', 'felis');
insert into categoria (id_categoria, categoria) values ('2', 'justo');
insert into categoria (id_categoria, categoria) values ('23', 'in lectus');
insert into categoria (id_categoria, categoria) values ('24', 'sapien');
insert into categoria (id_categoria, categoria) values ('25', 'semper');

-- inserts FORNECEDORES
insert into fornecedores (cnpj,  enderecos_id, nome, telefone) values (82, 1, 'João',  34244624); 
insert into fornecedores (cnpj,  enderecos_id, nome, telefone) values (83, 2, 'Bruno',  25152528); 



-- inserts PRODUTOS
-- TESTE DE PRODUTO PRE CADASTRADO -------------------------------------------------
insert into veiculo (id_veiculo, quant_assento, tipo_cambio, quant_portas, espaco_porta_malas, marca, nome, cor, ano, nota_avaliacao, preco_por_dia, img_base64, unidade_em_estoque, categoria_id_categoria, fornecedores_cnpj) values (1, 5, 'Automático', 4, '4', 'Volkswagem', 'Gol', 'Vermelho', '2018', 5.0, 300, 'https://quatrorodas.abril.com.br/wp-content/uploads/2021/02/volkswagen_gol_5-door_25.jpeg?quality=70&strip=info', 5, 23, 82);

-- inserts ALUGUELREGISTROS
-- TESTE DE LOCAÇÃO PRE CADASTRADA -------------------------------------------------
insert into aluguelRegistros (id_venda, forma_pagamento, data_inicio, quant_dias, valor, vendedor_id_vendedor, locador_pessoas_cpf) values (12, 'Cartão de Crédito em 5 vezes', '2005-10-24', 3, 300, 1, 212213454);

-- inserts LOGIN
-- TESTE DE POPE FRANCIS MASTER E 1 VENDEDOR PRE CADASTRADOS -------------------------------------------------
insert into login (id, cpf, senha) values (1, '13093824923', '24102005' ), (2, '04807428985', '19101984' );

-- --- CRIAR INSERTS PARA CRIACAO DE VEICULO NO SISTEMA 

SELECT * FROM login;
SELECT * FROM categoria;
SELECT * FROM aluguelRegistros;
SELECT * FROM vendedor;
SELECT * FROM fornecedores;
SELECT * FROM enderecos;
SELECT * FROM empresa;
-- SELECTSSSSSSSSSSSSSSSSSS -----------------------------------------------------------------------------------------
-- -------------------------------


-- SELECT P LISTAGEM

