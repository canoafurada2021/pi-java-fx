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
  `TipoAcessoLogin` INT NOT NULL -- Coluna para o TipoAcessoLogin diretamente
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
 `TipoAcessoLogin` INT NOT NULL, -- Coluna para o TipoAcessoLogin diretamente
  `porte_empresa` ENUM('pequena', 'média', 'grande') NOT NULL,
  
  PRIMARY KEY (`id_empresa`)

);




-- -----------------------------------------------------
-- Table .`vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendedor` (
  `id_vendedor` INT NOT NULL AUTO_INCREMENT,
  `salario` DOUBLE NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `cpf` BIGINT NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `TipoAcessoLogin` INT NOT NULL, -- Coluna para o TipoAcessoLogin diretamente
  PRIMARY KEY (`id_vendedor`)
);


-- -----------------------------------------------------
-- Table .`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `endereco` (
  `cep` INT NOT NULL  ,
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
  `pessoas_cpf` VARCHAR(45),
  `tel_contato` LONG NOT NULL,
  `pais_residencia` VARCHAR(45) NOT NULL,
  `cnh` LONG NOT NULL,
  `validade_carteira` DATE NOT NULL,
  `num_identificacao_carteira` LONG NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `TipoAcessoLogin` INT NOT NULL, -- Coluna para o tipo de acesso de usuário
  `img_Base64Locador` BLOB,
  PRIMARY KEY (`pessoas_cpf`)
);

-- -----------------------------------------------------
-- Table .`vendaRegistros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aluguelRegistro` (
  `id_venda` INT NOT NULL  AUTO_INCREMENT,
  `forma_pagamento` VARCHAR(45) NOT NULL,
  `data_inicio` VARCHAR(45) NOT NULL,
  `quant_dias` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `vendedor_id_vendedor` INT NOT NULL,
  `locador_pessoas_cpf` VARCHAR(45),
  PRIMARY KEY (
    `id_venda`,
    `vendedor_id_vendedor`,
    `locador_pessoas_cpf`
  ),
  FOREIGN KEY (`vendedor_id_vendedor`) REFERENCES `vendedor` (`id_vendedor`),
  FOREIGN KEY (`locador_pessoas_cpf`) REFERENCES `locador` (`pessoas_cpf`)
);

-- -----------------------------------------------------
-- Table .`fornecedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fornecedor` (
  `cnpj` BIGINT NOT NULL,
  `endereco_id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` LONG NOT NULL,
  `atividades` VARCHAR(90) NOT NULL,
  PRIMARY KEY (`cnpj`),
  FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`)
);

-- -----------------------------------------------------
-- Table .`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` BIGINT NOT NULL  AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_categoria`)
);

-- -----------------------------------------------------
-- Table .`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `veiculo`(
  `id_veiculo` INT NOT NULL AUTO_INCREMENT,
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
  `unidade_em_estoque` INT NOT NULL,
  `categoria_id_categoria` BIGINT NOT NULL,
  `fornecedor_cnpj` BIGINT  NOT NULL,
  PRIMARY KEY (`id_veiculo`, `fornecedor_cnpj`),
  FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`),
  FOREIGN KEY (`fornecedor_cnpj`) REFERENCES `fornecedor` (`cnpj`) ON DELETE CASCADE
);


DELIMITER $$
CREATE TRIGGER criar_login_vendedor
AFTER INSERT ON vendedor
FOR EACH ROW
BEGIN
    INSERT INTO login (cpf, senha, TipoAcessoLogin)
    VALUES (NEW.cpf, NEW.senha, NEW.TipoAcessoLogin);
END;
$$
DELIMITER ;
-- -----------------------------------------------------
-- INSERTS
-- -----------------------------------------------------

-- insert EMPRESA (É UMA SÓ)
insert into empresa (razao_social, telefone, cnpj, nome_fantasia, porte_empresa, TipoAcessoLogin) values ('O objetivo da empresa é deixar as pessoas felizes andando de gol', '+5547992178827', '12345678000199', 'Pope Francis Master', 'grande', 1);










-- inserts CLIENTES
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, TipoAcessoLogin, img_Base64Locador) values (
'13093824923',
 47988989827,
 'BRASIL',
 89111042,
 '2023-08-20',
 012344,
 'Carl',
 'Johnson',
 2,
"
8BC49EA76D9B42E3ED38CC0C7BA30297DBF135C95DBCD5583B8F20E223E618EECC4FEC36F3ED5BFD71F63EC0C1922079594306A367EBB7D2FE7F9F9C4ACDC60D58B277FA7FBE3DC7D8248239835E3F63EDFB6088E1E506ABB0DE3E63E7F4DF1EE3EC750E65CF523C1BB0BDFCAD7E86B1F63EC7D8228152A27FFD9
");

insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, TipoAcessoLogin, img_Base64Locador) values ('24102005', 47992117973, 'BRASIL', 32165498, '2025-08-30', 987654, 'Frank', 'Tenpenny', 3, 'https://static.wikia.nocookie.net/gta/images/0/02/GTASA_Tenpenny.jpg/revision/latest?cb=20090630163333&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, TipoAcessoLogin, img_Base64Locador) values ('321654987', 47991853907, 'BRASIL', 12457869, '2024-11-24', 457869, 'Salvatore', 'Leone', 3, 'https://static.wikia.nocookie.net/gta/images/6/6f/LeoneGTASA.jpg/revision/latest?cb=20091207011919&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, TipoAcessoLogin, img_Base64Locador) values ('987654321', 47991737302, 'BRASIL', 32659847, '2025-09-19', 124578, 'Mike', 'Toreno', 3, 'https://static.wikia.nocookie.net/gta/images/9/90/Mike.jpg/revision/latest?cb=20100517210533&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, TipoAcessoLogin, img_Base64Locador) values ('123789456', 47992178827, 'BRASIL', 98653214, '2026-09-27', 362514, 'Catalina', 'Farrel', 3, 'https://static.wikia.nocookie.net/gta/images/8/8a/Catalina1992.jpg/revision/latest?cb=20200416151431&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, TipoAcessoLogin, img_Base64Locador) values ('321987654', 47984241802, 'BRASIL', 14253678, '2030-12-03', 142532, 'Madd', 'Dogg', 3, 'https://static.wikia.nocookie.net/gta/images/a/a4/MaddDogg.jpg/revision/latest?cb=20110131231921&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, TipoAcessoLogin, img_Base64Locador) values ('654789321', 47995687402, 'BRASIL', 36251498, '2035-06-08', 321654, 'Ken', 'Rosenberg', 3, 'https://static.wikia.nocookie.net/gta/images/f/fe/KenEmSa.jpg/revision/latest?cb=20091129221320&path-prefix=pt');


-- inserts endereco
insert into endereco (cep, id, rua, bairro, cidade, estado) values ('89111042', '1', 'Rua Florianópolis', 'Bela Vista', 'Gaspar', 'Santa Catarina');
insert into endereco (cep, id, rua, bairro, cidade, estado) values ('891110826', '2', 'Rua João José Schmitz', 'Bela Vista', 'Gaspar', 'Santa Catarina');
insert into endereco (cep, id, rua, bairro, cidade, estado) values ('89025420', '3', 'Rua Juiz de Fora', 'Glória', 'Blumenau', 'Santa Catarina');
insert into endereco (cep, id, rua, bairro, cidade, estado) values ('88420000', '4', 'Estrada Geral Pitangueira', 'Estrada Geral', 'Agrolândia', 'Santa Catarina');


-- inserts VENDEDORES
INSERT INTO vendedor ( salario, nome, sobrenome, cpf, senha, TipoAcessoLogin) VALUES ( 2574.89, 'Patricia', 'Cordeiro', 12348, 'patinha',  2);
INSERT INTO vendedor ( salario, nome, sobrenome, cpf, senha, TipoAcessoLogin) VALUES ( 3452.90, 'Andrieli', 'Mendes', 4321, 'andrinha', 2);


-- inserts CATEGORIAS
insert into categoria ( categoria) values ( 'felis');
insert into categoria ( categoria) values ( 'justo');
insert into categoria ( categoria) values ( 'in lectus');
insert into categoria ( categoria) values ('sapien');
insert into categoria ( categoria) values ( 'semper');


-- inserts fornecedor
insert into fornecedor (cnpj,  endereco_id, nome, atividades, telefone) values (82, 1, 'Emily Joanna Alves', 'HB20 all black', 47984273688);
insert into fornecedor (cnpj,  endereco_id, nome, atividades, telefone) values (83, 2, 'Maria Eduarda Mendes','Gol Bolinha 2014',  47997212305);


-- inserts PRODUTOS
-- FAZER PRE CADASTRADOS CARROS GTA - EMILY ALVES
-- insert into veiculo (id_veiculo, quant_assento, tipo_cambio, quant_portas, espaco_porta_malas, marca, nome, cor, ano, nota_avaliacao, preco_por_dia, unidade_em_estoque, categoria_id_categoria, fornecedor_cnpj) values (1, 5, 'Automático', 4, '4', 'Volkswagem', 'Gol', 'Vermelho', '2018', 5.0, 300,  5, 23, 82);
INSERT INTO veiculo (quant_assento, tipo_cambio, quant_portas, espaco_porta_malas, marca, nome, cor, ano, nota_avaliacao, preco_por_dia, unidade_em_estoque, categoria_id_categoria, fornecedor_cnpj)
VALUES (5, 'Automático', 4, 400, 'Volkswagen', 'Golf', 'Prata', 2020, 4.5, 200.0, 10, 1, 82);


-- inserts aluguelRegistro
insert into aluguelRegistro (id_venda, forma_pagamento, data_inicio, quant_dias, valor, vendedor_id_vendedor, locador_pessoas_cpf) values (12, 'Cartão de Crédito em 5 vezes', '2005-10-24', 3, 300, 1, 24102005);
insert into aluguelRegistro (id_venda, forma_pagamento, data_inicio, quant_dias, valor, vendedor_id_vendedor, locador_pessoas_cpf) values (16, 'DINHEIRO', '2023-10-24', 5, 256, 2, 654789321);






-- -----------------------------------------------------
-- SELECTSSSSSSSSSSSSSSSSSSSSSSSSS
-- -----------------------------------------------------
SELECT * FROM login;
SELECT * FROM categoria;
SELECT * FROM aluguelRegistro;
SELECT * FROM vendedor;
SELECT * FROM fornecedor;
SELECT * FROM endereco;


SELECT * FROM empresa;
SELECT * FROM locador;
SELECT * FROM veiculo;

