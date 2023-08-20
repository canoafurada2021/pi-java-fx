# Sistema Get That Auto
![image](https://github.com/canoafurada2021/projeto-integrador/assets/84353670/a5a2e867-2ec6-46bc-b96e-57575bcb2bb6)

![Em Desenvolvimento](https://img.shields.io/badge/Status-Em%20Desenvolvimento-blue) [![Java Development Kit (JDK)](https://img.shields.io/badge/License-JDK-blue)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) [![JavaFX](https://img.shields.io/badge/JavaFX-blue)](https://openjfx.io/) ![Progresso: 1%](https://img.shields.io/badge/Progresso-10%25-blue)

## 📚 DESCRIÇÃO DAS FUNCIONALIDADES DO SISTEMA</span>
Este é o repositório de códigos fonte base para desenvolvimendo do projeto integrador focado em um sistema desktop/mobile para uma empresa de venda de carros


## 🚙 INTRODUÇÃO</span>
  O presente projeto propõe o desenvolvimento de um software para o gerenciamento de atividades de uma locadora de veículos e seu respectivo controle de estoque. Tal sistema possuirá apenas uma aplicação para desktop com as visualizações de proprietário e funcionário. Em geral, no sistema poderão ser cadastrados, além de produtos, clientes, funcionários e fornecedores, também será possível realizar a reserva de um veículo. No momento de login, é possível visualizar o sistema a partir de duas interfaces específicas para manuseio, sendo elas a de funcionário e proprietário. Para o funcionário, será possível visualizar a aba de dashboard da empresa, o gerenciamento (CRUD) de produtos, gerenciamento (exclusão e alteração) de clientes, além de uma aba para a visualização dos veículos, seus status e as opções de reserva associadas a um cliente específico, e por fim, o funcionário pode alterar os dados de sua própria cota no sistema. Já o proprietário, que será pré-cadastrado no sistema, terá acesso a todo o sistema, podendo realizar o gerenciamento (CRUD) dos fornecedores, funcionários, clientes, atualizar seus próprios dados nas configurações, realizar reservas de veículos e, por fim, visualizar a análise de todas as locações e atividades de cada funcionário e dos veículos mais locados.

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

## 💠 Diagrama de casos de uso com atores identificados
 A imagem abaixo mostra o diagrama de casos de uso gerais do sistema, o qual possui dois atores e os quinze casos de uso identificados com suas respectivas descrições.

![DiagramaDeCasosDeUsoComAtoresIdentificados](https://github.com/canoafurada2021/pi-java-fx/blob/master/DiagramaDeCasosDeUsoComAtoresIdentificados.jpg?raw=true)


## 💠 Diagrama de Classes
  Para a aplicação do sistema de concessionária, foram desenvolvidas dez classes armazenadoras das informações necessárias para o funcionamento da aplicação. São elas, as classes Fornecedor, Endereco, Pessoa, Vendedor, Cliente, Produto, Categoria, Venda, EnumPagamento e AgendaVisita, abaixo:

![DiagramaDeClasses](https://github.com/canoafurada2021/pi-java-fx/blob/master/DiagramaDeClasses.png?raw=true)
