
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
  `tipo_usuario` ENUM('vendedor', 'master') NOT NULL, 
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_usuario` (`cpf`)
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
  `porteEmpresa` ENUM('pequena', 'média', 'grande') NOT NULL,
  PRIMARY KEY (`idempresa`)
);




-- -----------------------------------------------------
-- Table .`vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `vendedores` (
  `idvendedores` INT NOT NULL,
  `salario` DOUBLE NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idvendedores`)
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
  PRIMARY KEY (`pessoas_cpf`),
  FOREIGN KEY (`enderecos_id`) REFERENCES `enderecos` (`id`)
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


-- INSERTSSSSSSSSSSSSS -----------------------------------------------------------------------------------------
-- -------------------------------

-- INSERT TESSTE DE EMPRESA PRE CADASTRADA ------------------------------------------------------
-- -------------------------------------------------------------------------------------------------
insert into empresa (razaosocial, telefone, cnpj, nomefantasia, porteEmpresa) values ('O objetivo da empresa é deixar as pessoas felizes andando de gol', '+55 47 992178827', '12.345.678/0001-99', 'Pope Francis Master', 'grande');
-- ------------------------------------------------------------------------------------------------------

-- inserts ENDERECOS
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('95560', '1', 'PO Box 26708', '9th Floor', 'PO Box 59776', '7th Floor');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('95590', '2', 'PO Box 74593', 'Suite 85', 'Apt 359', 'Room 630');
insert into enderecos (cep, id, rua, bairro, cidade, estado) values ('9899', '3', 'Apt 1550', 'Apt 1844', 'Suite 82', 'Suite 87');

-- inserts CATEGORIAS
insert into categorias (idcategorias, categoria) values ('1', 'felis');
insert into categorias (idcategorias, categoria) values ('2', 'justo');
insert into categorias (idcategorias, categoria) values ('23', 'in lectus');
insert into categorias (idcategorias, categoria) values ('24', 'sapien ');
insert into categorias (idcategorias, categoria) values ('25', 'semper');

-- inserts FORNECEDORES
insert into fornecedores (cnpj,  enderecos_id, nome, telefone) values (82, 1, 'João',  34244624); 
insert into fornecedores (cnpj,  enderecos_id, nome, telefone) values (83, 2, 'Bruno',  25152528); 

-- inserts VENDEDORES
insert into vendedores (idVendedores, salario, nome, sobrenome) values (1, 2574.89, 'Garreth', 'Espinoy'  );
insert into vendedores (idVendedores, salario, nome, sobrenome) values (2, 1883.12, 'Jess', 'McMichan' );
insert into vendedores (idVendedores, salario, nome, sobrenome  ) values (3,1883.16,'José','carols');
insert into vendedores (idVendedores, salario, nome, sobrenome ) values (4, 1844.79, 'Brigg', 'McNeill');
insert into vendedores (idVendedores, salario, nome, sobrenome) values (7, 1386.02, 'Sol', 'Winspur');
insert into vendedores (idVendedores, salario, nome, sobrenome ) values (8, 2896.38, 'Caressa', 'Clair');

-- inserts LOCADOR
insert into locador (pessoas_cpf, telContato, nome,  sobrenome, enderecos_id) values ('212213454', '47988', 'Joanna', 'oldey',  1);
insert into locador (pessoas_cpf,telContato, nome, sobrenome, enderecos_id) values ('768541784', '4798688', 'Miguela', 'Gettens', 3);
insert into locador (pessoas_cpf,telContato, nome, sobrenome, enderecos_id) values ('103966036', '47984273', 'Olivia', 'Benedito', 2);

-- inserts PRODUTOS
-- TESTE DE PRODUTO PRE CADASTRADO -------------------------------------------------
-- insert into veiculo (idVeiculo, quantAssento, tipoCambio, quantPortas, espacoPortaMalas, marca, nome, cor, ano, notaAvaliacao, precoPorDia, imgBase64, unidadeEmEstoque, categorias_idcategorias, fornecedores_cnpj) values (1, 5, 'Automático', 4, '4', 'Volkswagem', 'Gol', 'Vermelho', '2018', 5.0, 300, 'data:image/jpeg;base64,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', 5, 23, 82);

-- inserts ALUGUELREGISTROS
-- TESTE DE LOCAÇÃO PRE CADASTRADA -------------------------------------------------
insert into aluguelRegistros (idvenda, formaPagamento, dataInicio, quantDias, valor, vendedores_idvendedores, locador_pessoas_cpf) values (12, 'Cartão de Crédito em 5 vezes', '2005-10-24', 3, 300, 1, 212213454);

-- inserts LOGIN
-- TESTE DE POPE FRANCIS MASTER E 1 VENDEDOR PRE CADASTRADOS -------------------------------------------------
insert into login (id, cpf, senha, tipo_usuario) values (1, '13093824923', '24102005', 'master'), (2, '04807428985', '19101984', 'vendedor');


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

