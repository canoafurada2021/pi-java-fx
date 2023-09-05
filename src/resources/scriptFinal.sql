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
  `sobrenome` VARCHAR(45) NOT NULL,
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
  `tel_contato` LONG NOT NULL,
  `pais_residencia` VARCHAR(45) NOT NULL,
  `cnh` LONG NOT NULL,
  `validade_carteira` DATE NOT NULL,
  `num_identificacao_carteira` LONG NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  `cargo` ENUM('MASTER', 'FUNCIONARIO', 'CLIENTE') NOT NULL, -- Coluna para o cargo diretamente
  `img_Base64Locador` VARCHAR(555) NOT NULL DEFAULT "",
  PRIMARY KEY (`pessoas_cpf`)
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
  `cnpj` BIGINT NOT NULL,
  `enderecos_id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` LONG NOT NULL,
  `atividades` VARCHAR(90) NOT NULL,
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
  `fornecedores_cnpj` BIGINT  NOT NULL,
  PRIMARY KEY (`id_veiculo`, `fornecedores_cnpj`),
  FOREIGN KEY (`categoria_id_categoria`) REFERENCES `categoria` (`id_categoria`),
  FOREIGN KEY (`fornecedores_cnpj`) REFERENCES `fornecedores` (`cnpj`) ON DELETE CASCADE
);



-- -----------------------------------------------------
-- INSERTSSSSSSSSSSSSSSSSSSSSSSSSS
-- -----------------------------------------------------

-- insert EMPRESA (É UMA SÓ)
insert into empresa (razao_social, telefone, cnpj, nome_fantasia, porte_empresa, cargo) values ('O objetivo da empresa é deixar as pessoas felizes andando de gol', '+55 47 992178827', '12.345.678/0001-99', 'Pope Francis Master', 'grande', "MASTER");


-- inserts CLIENTES
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) values ('212213454', 47988989827, 'BRASIL', 89111042, '2023-08-20', 012344, 'Carl', 'Johnson', "CLIENTE", 'https://static.wikia.nocookie.net/gta/images/d/d4/CJ-GTASA-230px.png/revision/latest?cb=20141212032649&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) values ('123456789', 47992117973, 'BRASIL', 32165498, '2025-08-30', 987654, 'Frank', 'Tenpenny', "CLIENTE", 'https://static.wikia.nocookie.net/gta/images/0/02/GTASA_Tenpenny.jpg/revision/latest?cb=20090630163333&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) values ('321654987', 47991853907, 'BRASIL', 12457869, '2024-11-24', 457869, 'Salvatore', 'Leone', "CLIENTE", 'https://static.wikia.nocookie.net/gta/images/6/6f/LeoneGTASA.jpg/revision/latest?cb=20091207011919&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) values ('987654321', 47991737302, 'BRASIL', 32659847, '2025-09-19', 124578, 'Mike', 'Toreno', "CLIENTE", 'https://static.wikia.nocookie.net/gta/images/9/90/Mike.jpg/revision/latest?cb=20100517210533&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) values ('123789456', 47992178827, 'BRASIL', 98653214, '2026-09-27', 362514, 'Catalina', 'Farrel', "CLIENTE", 'https://static.wikia.nocookie.net/gta/images/8/8a/Catalina1992.jpg/revision/latest?cb=20200416151431&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) values ('321987654', 47984241802, 'BRASIL', 14253678, '2030-12-03', 142532, 'Madd', 'Dogg', "CLIENTE", 'https://static.wikia.nocookie.net/gta/images/a/a4/MaddDogg.jpg/revision/latest?cb=20110131231921&path-prefix=pt');
insert into locador (pessoas_cpf, tel_contato, pais_residencia, cnh,validade_carteira, num_identificacao_carteira, nome, sobrenome, cargo, img_Base64Locador) values ('654789321', 47995687402, 'BRASIL', 36251498, '2035-06-08', 321654, 'Ken', 'Rosenberg', "CLIENTE", 'https://static.wikia.nocookie.net/gta/images/f/fe/KenEmSa.jpg/revision/latest?cb=20091129221320&path-prefix=pt');


-- inserts ENDERECOS
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('89111042', '1', 'Rua Florianópolis', 'Bela Vista', 'Gaspar', 'Santa Catarina');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('891110826', '2', 'Rua João José Schmitz', 'Bela Vista', 'Gaspar', 'Santa Catarina');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('89025420', '3', 'Rua Juiz de Fora', 'Glória', 'Blumenau', 'Santa Catarina');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('88420000', '4', 'Estrada Geral Pitangueira', 'Estrada Geral', 'Agrolândia', 'Santa Catarina');


-- inserts VENDEDORES
INSERT INTO vendedor (id_vendedor, salario, nome, sobrenome,  cargo) VALUES (1, 2574.89, 'Patricia', 'Cordeiro',  'FUNCIONARIO');
INSERT INTO vendedor (id_vendedor, salario, nome, sobrenome, cargo) VALUES (3, 3452.90, 'Andrieli', 'Mendes', 'FUNCIONARIO');


-- inserts CATEGORIAS
insert into categoria (id_categoria, categoria) values ('1', 'felis');
insert into categoria (id_categoria, categoria) values ('2', 'justo');
insert into categoria (id_categoria, categoria) values ('23', 'in lectus');
insert into categoria (id_categoria, categoria) values ('24', 'sapien');
insert into categoria (id_categoria, categoria) values ('25', 'semper');


-- inserts FORNECEDORES
insert into fornecedores (cnpj,  enderecos_id, nome, atividades, telefone) values (82, 1, 'Emily Joanna Alves', 'HB20 all black', 47984273688); 
insert into fornecedores (cnpj,  enderecos_id, nome, atividades, telefone) values (83, 2, 'Maria Eduarda Mendes','Gol Bolinha 2014',  47997212305); 


-- inserts PRODUTOS
-- FAZER PRE CADASTRADOS CARROS GTA - EMILY ALVES
insert into veiculo (id_veiculo, quant_assento, tipo_cambio, quant_portas, espaco_porta_malas, marca, nome, cor, ano, nota_avaliacao, preco_por_dia, img_base64, unidade_em_estoque, categoria_id_categoria, fornecedores_cnpj) values (1, 5, 'Automático', 4, '4', 'Volkswagem', 'Gol', 'Vermelho', '2018', 5.0, 300, 'https://quatrorodas.abril.com.br/wp-content/uploads/2021/02/volkswagen_gol_5-door_25.jpeg?quality=70&strip=info', 5, 23, 82);


-- inserts ALUGUELREGISTROS
insert into aluguelRegistros (id_venda, forma_pagamento, data_inicio, quant_dias, valor, vendedor_id_vendedor, locador_pessoas_cpf) values (12, 'Cartão de Crédito em 5 vezes', '2005-10-24', 3, 300, 1, 212213454);


-- inserts LOGIN
insert into login (id, cpf, senha) values (1, '13093824923', '24102005' ), (2, '04807428985', '19101984' );




-- -----------------------------------------------------
-- SELECTSSSSSSSSSSSSSSSSSSSSSSSSS
-- -----------------------------------------------------
SELECT * FROM login;
SELECT * FROM categoria;
SELECT * FROM aluguelRegistros;
SELECT * FROM vendedor;
SELECT * FROM fornecedores;
SELECT * FROM enderecos;
SELECT * FROM empresa;
SELECT * FROM locador;

