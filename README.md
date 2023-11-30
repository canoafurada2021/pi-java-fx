# Sistema Get That Auto

![Sistema Get That Auto](https://github.com/canoafurada2021/projeto-integrador/assets/84353670/a5a2e867-2ec6-46bc-b96e-57575bcb2bb6)

![Em Desenvolvimento](https://img.shields.io/badge/Status-Em%20Desenvolvimento-blue)
[![Java Development Kit (JDK)](https://img.shields.io/badge/License-JDK-blue)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
[![JavaFX](https://img.shields.io/badge/JavaFX-blue)](https://openjfx.io/)
![Progresso: 30%](https://img.shields.io/badge/Progresso-90%25-blue)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-Usando-Blue)


## 📚 Descrição das Funcionalidades do Sistema

Este repositório contém o código-fonte base para o desenvolvimento do projeto integrador focado em um sistema desktop para uma empresa de locação de carros.

## 🚘 Introdução

  O projeto propõe a criação de um software para gerenciar uma locadora de veículos e seu estoque. O sistema terá uma aplicação de desktop com duas interfaces, uma para funcionários e outra para o proprietário. Funcionários poderão fazer o gerenciamento de produtos, clientes e reservas de veículos, além de alterar seus próprios dados. O proprietário terá controle total, podendo gerenciar fornecedores, funcionários, clientes, fazer reservas e analisar atividades dos funcionários e veículos mais locados.


### 🎯 Objetivos do Projeto

1. **Cadastro Completo**: Permitir o cadastro detalhado de produtos, funcionários, categorias e fornecedores.
2. **Interfaces Distintas**: Oferecer diferentes interfaces de manuseio para funcionários e proprietário.
3. **Controle de Estoque**: Manter um controle rigoroso do estoque de produtos, com atualizações em tempo real.
4. **Reservas de Veículos**: Possibilitar o cadastro e gerenciamento de locações de veículos associadas a clientes específicos.
5. **Filtros de Pesquisa**: Facilitar a busca e listagem dos produtos disponíveis em estoque.


### 🖱️ Telas do Projeto

1. **Tela de Login**:
![login](https://github.com/canoafurada2021/pi-java-fx/assets/88635006/4600fce9-a6d2-4b14-a34e-792a1d28e54c)

2. **Tela de Dashboard**:
![dashboard](https://github.com/canoafurada2021/pi-java-fx/assets/88635006/ee6dde26-48eb-4350-820b-609257d1e9c2)

4. **Tela de Listagem de Fornecedores**:
![Captura de tela 2023-11-30 112045](https://github.com/canoafurada2021/pi-java-fx/assets/88635006/5c43f1b8-8c9e-4461-9dc2-dd170698b4df)

5. **Tela de Cadastro de Fornecedores**:
![Captura de tela 2023-11-30 112206](https://github.com/canoafurada2021/pi-java-fx/assets/88635006/5722b6fe-93a9-4a72-a777-f148e5f34b7a)

6. **PopUp de Edição de Fornecedores**:

![Captura de tela 2023-11-30 112309](https://github.com/canoafurada2021/pi-java-fx/assets/88635006/8eb39c7f-ff4a-48c1-954f-f9d5efe288da)

7. **PDF de Relatório de Locação**:

![Captura de tela 2023-11-30 112559](https://github.com/canoafurada2021/pi-java-fx/assets/88635006/60fdc584-076f-4130-905a-9f88f2a6b6c0)



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
| 14     | Visualizar relatório de uma locação - UC14      | Visualização de relatório em PDF de uma locação no sistema, por vendedor e gerente.|
| 15     | Remover uma locação - UC15               | Exclusão do registro de uma locação do sistema, por vendedor e gerente. |


## ⛽ Diagramas

<div style="text-align: center;">
  <h3>Diagrama de casos de uso com atores identificados</h3>
  <p>A imagem abaixo mostra o diagrama de casos de uso gerais do sistema, o qual possui dois atores e os quinze casos de uso identificados com suas respectivas descrições:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/assets/88635006/ca0564e8-f293-42fa-933f-d9ee94086628" alt="Diagrama de Casos de Uso">
</div>

<div style="text-align: center;">
  <h3>Diagrama de Classes</h3>
  <p>Para estabelecer uma sincronização entre o sistema e o banco de dados, deve-se usar um mapeamento do Diagrama de Classes para o Diagrama Entidade-Relacionamento, conforme mostrado abaixo:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/blob/master/DiagramaDeClasses.png?raw=true" alt="Diagrama de Classes">
</div>

<div style="text-align: center;">
  <h3>Diagrama de Entidade e Relacionamento</h3>
  <p>Para a aplicação do sistema de concessionária, foram desenvolvidas dez classes armazenadoras das informações necessárias para o funcionamento da aplicação. São elas, as classes Fornecedor, Endereco, Pessoa, Vendedor, Cliente, Produto, Categoria, Venda, EnumPagamento e AgendaVisita, abaixo:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/assets/88635006/7575c8e9-2db3-46e8-89fc-c64d4b2fedaa" alt="Diagrama de Entidade e Relacionamento">
</div>
