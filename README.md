# Sistema Get That Auto

![Sistema Get That Auto](https://github.com/canoafurada2021/projeto-integrador/assets/84353670/a5a2e867-2ec6-46bc-b96e-57575bcb2bb6)

![Em Desenvolvimento](https://img.shields.io/badge/Status-Em%20Desenvolvimento-blue)
[![Java Development Kit (JDK)](https://img.shields.io/badge/License-JDK-blue)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![JavaFX](https://img.shields.io/badge/JavaFX-blue)](https://openjfx.io/)
![Progresso: 10%](https://img.shields.io/badge/Progresso-10%25-blue)

## 📚 Descrição das Funcionalidades do Sistema

Este repositório contém o código-fonte base para o desenvolvimento do projeto integrador focado em um sistema desktop para uma empresa de locação de carros.

## 🚘 Introdução

O projeto "Get That Auto" tem como objetivo o desenvolvimento de um software para o gerenciamento de atividades de uma locadora de veículos, incluindo controle de estoque e gestão de clientes. O sistema é projetado para operar em um ambiente desktop e móvel, proporcionando diferentes níveis de acesso para funcionários e proprietários. Algumas das principais funcionalidades incluem:

- Cadastro e gerenciamento de veículos
- Cadastro e gerenciamento de clientes
- Controle de estoque de veículos
- Reserva de veículos
- Análise de locações e atividades

## 🚗 Casos de Uso
| **Número** | **Caso de Uso**                                | **Descrição**                                        |
|--------|--------------------------------------------|--------------------------------------------------|
| 1      | Cadastrar um veículo - UC01               | Cadastro de produtos novos, por vendedor e gerente|
| 2      | Excluir um veículo - UC02                 | Exclusão um produto dos registros do sistema, por vendedor e gerente.|
| 3      | Alterar informações de um veículo - UC03  | Alteração dos dados de um produto registrado, por vendedor e gerente |
| 4      | Alterar informações perfil de vendedor - UC04 | Alteração dos dados de um vendedor registrado, por vendedor e gerente.|
| 5      | Cadastrar vendedores - UC05               | Registro de um ou mais vendedores, por gerente. |
| 6      | Excluir vendedores - UC06                 | Exclusão de um vendedor do sistema, por gerente.  |
| 7      | Cadastrar um fornecedor - UC07            | Cadastro de um novo fornecedor no sistema, por gerente. |
| 8      | Atualizar um fornecedor - UC08            | Alteração dos dados de um fornecedor, por gerente.|
| 9      | Excluir um fornecedor - UC09              | Exclusão do registro de um fornecedor do sistema, por gerente. |
| 10     | Cadastrar um cliente - UC10              | Cadastro de um novo cliente no sistema, por gerente. |
| 11     | Excluir um cliente - UC11                | Exclusão de um cliente dos registros do sistema, por vendedor e gerente |
| 12     | Alterar um cliente - UC12                | Alteração dos dados de um cliente, por vendedor e gerente.|
| 13     | Cadastrar uma locação - UC13             | Cadastro de uma nova locação no sistema, por vendedor e gerente. |
| 14     | Alterar dados de uma locação - UC14      | Alteração dos dados de uma locação no sistema, por vendedor e gerente.|
| 15     | Remover uma locação - UC15               | Exclusão do registro de uma locação do sistema, por vendedor e gerente. |


## ⛽ Diagramas

<div style="text-align: center;">
  <h4>Diagrama de casos de uso com atores identificados</h3>h3>
  <p>A imagem abaixo mostra o diagrama de casos de uso gerais do sistema, o qual possui dois atores e os quinze casos de uso identificados com suas respectivas descrições:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/blob/master/DiagramaDeCasosDeUsoComAtoresIdentificados.jpg?raw=true" alt="Diagrama de Casos de Uso">
</div>

<div style="text-align: center;">
  <h4>Diagrama de Classes</h3>
  <p>Para estabelecer uma sincronização entre o sistema e o banco de dados, deve-se usar um mapeamento do Diagrama de Classes para o Diagrama Entidade-Relacionamento, conforme mostrado abaixo:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/blob/master/DiagramaDeClasses.png?raw=true" alt="Diagrama de Classes">
</div>

<div style="text-align: center;">
  <h4>Diagrama de Entidade e Relacionamento</h3>
  <p>Para a aplicação do sistema de concessionária, foram desenvolvidas dez classes armazenadoras das informações necessárias para o funcionamento da aplicação. São elas, as classes Fornecedor, Endereco, Pessoa, Vendedor, Cliente, Produto, Categoria, Venda, EnumPagamento e AgendaVisita, abaixo:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/assets/95760996/299da800-d62c-4fea-9178-26340f579f12.png" alt="Diagrama de Entidade e Relacionamento">
</div>
