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

1. **Cadastro Completo**: Permitir o cadastro detalhado de produtos, clientes, funcionários e fornecedores.
2. **Personalização da Empresa**: Facilitar a personalização dos dados da empresa.
3. **Gestão de Usuários**: Permitir aos funcionários e clientes alterar suas informações pessoais.
4. **Interfaces Distintas**: Oferecer diferentes interfaces de manuseio para funcionários e proprietário.
5. **Controle de Estoque**: Manter um controle rigoroso do estoque de produtos, com atualizações em tempo real.
6. **Reservas de Veículos**: Possibilitar o cadastro e gerenciamento de locações de veículos associadas a clientes específicos.
7. **Análise de Desempenho**: Permitir ao proprietário visualizar informações sobre os melhores vendedores e os veículos mais locados.
8. **Filtros de Pesquisa**: Facilitar a busca e listagem dos produtos disponíveis em estoque.


### 🖱️ Telas do Projeto

1. **Tela de Login**:
<img src="https://lh3.googleusercontent.com/keep-bbsk/AG3SVnC6WRysDu-N94NHHAYaRBuKKrXZn06EeIbvDHP3oivyxUxvh7jVc-LqHDCwEKHXY_o2UUS9qUmwDNi1j53qj-e4SYwxTXyGgDsyFJiDN--JXVxf=s947" alt="Tela de Login">

2. **Tela de Dashboard**:
<img src="https://lh3.googleusercontent.com/keep-bbsk/AG3SVnBa9Sk8zMYSCCwRFnAz1sMNh75bXJhmP5b9PYFSKYz3onD6oE32-sx8Nk6OsW_kZwjcRZPI07tlYrN4Wc8irGwg6Qg0kJTNnyli4eFiLNawCzDG=s1334" alt="Tela de Dashboard">

4. **Tela de Listagem de Fornecedores**:
<img src="https://lh3.googleusercontent.com/keep-bbsk/AG3SVnBqGosliVw8CLu5QcYsv_HKU-ROilGtKZSU0divfSjfEWBca_5n9DXBMhbGPkfoifeblX6_XHZ7h_2dVyPNqnywrPTOGgCtv0JbF4EzRAfKIoAz=s1516" alt="Tela de Listagem de Fornecedores">

5. **Tela de Cadastro de Fornecedores**:
<img src="https://lh3.googleusercontent.com/keep-bbsk/AG3SVnAKmGyExqu0s-AJ61wKk7CEEjlvgHrqROD-Hlx4TgMowpTI0nf0t6kcwa9CMaHDDA2SDLxaxpZUyNSl1cGfkdRwwvM6Y0i3mD1hVXCGtlcmp6om=s1515" alt="Tela de Cadastro de Fornecedores">

6. **PopUp de Edição de Fornecedores**:
<img src="https://lh3.googleusercontent.com/keep-bbsk/AG3SVnAGuVVUYvZ4cv2AOcgz0j30G_P6MJkDdlandBCGz4sOd90kXr0W1SB2-iY5qnfipx2cxByWimozw0P2MQ0whZUWwLQLAOzLc6XufuPOJl_4-5yX=s711" alt="PopUp de Edição de Forneceores">


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
  <h3>Diagrama de casos de uso com atores identificados</h3>
  <p>A imagem abaixo mostra o diagrama de casos de uso gerais do sistema, o qual possui dois atores e os quinze casos de uso identificados com suas respectivas descrições:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/blob/master/DiagramaDeCasosDeUsoComAtoresIdentificados.jpg?raw=true" alt="Diagrama de Casos de Uso">
</div>

<div style="text-align: center;">
  <h3>Diagrama de Classes</h3>
  <p>Para estabelecer uma sincronização entre o sistema e o banco de dados, deve-se usar um mapeamento do Diagrama de Classes para o Diagrama Entidade-Relacionamento, conforme mostrado abaixo:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/blob/master/DiagramaDeClasses.png?raw=true" alt="Diagrama de Classes">
</div>

<div style="text-align: center;">
  <h3>Diagrama de Entidade e Relacionamento</h3>
  <p>Para a aplicação do sistema de concessionária, foram desenvolvidas dez classes armazenadoras das informações necessárias para o funcionamento da aplicação. São elas, as classes Fornecedor, Endereco, Pessoa, Vendedor, Cliente, Produto, Categoria, Venda, EnumPagamento e AgendaVisita, abaixo:</p>
  <img src="https://github.com/canoafurada2021/pi-java-fx/assets/95760996/299da800-d62c-4fea-9178-26340f579f12.png" alt="Diagrama de Entidade e Relacionamento">
</div>
