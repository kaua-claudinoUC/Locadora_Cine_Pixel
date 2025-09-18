# Projeto: Cine Pixel - Sistema de Locadora

## Índice
1. [Objetivo do Projeto](#1-objetivo-do-projeto)
2. [Funcionalidades](#2-funcionalidades)
3. [Conceitos de POO Aplicados](#3-conceitos-de-poo-aplicados)
4. [Tecnologias Utilizadas](#4-tecnologias-utilizadas)
5. [Como Executar](#5-como-executar)
6. [Membros da Equipe](#6-membros-da-equipe)

---

### 1. Objetivo do Projeto

Desenvolver um sistema de gerenciamento para uma locadora de filmes em Java, operado via console. O projeto foi criado com o objetivo de aplicar e demonstrar os conceitos fundamentais de **Programação Orientada a Objetos (POO)**, como Encapsulamento, Herança, Polimorfismo e o uso de Coleções.

Este software foi desenvolvido como parte da avaliação A3 da Unidade Curricular de Programação de Soluções Computacionais.

### 2. Funcionalidades

O sistema "Cine Pixel" simula as operações básicas de uma locadora, permitindo que funcionários gerenciem o catálogo de filmes e seus próprios cadastros.

* **Autenticação de Funcionários:**
  - Cadastro de novos funcionários (Gerentes ou Colaboradores).
  - Sistema de login seguro para acesso às funcionalidades internas.

* **Gerenciamento de Filmes:**
  - Cadastro de novos filmes no catálogo.
  - Listagem de todos os filmes, exibindo seu título, gênero e status (Disponível ou Alugado).
  - Remoção de filmes do catálogo.

* **Sistema de Aluguel:**
  - Funcionalidade para "Reservar" um filme, mudando seu status para "Alugado".
  - Funcionalidade para "Devolver" um filme, mudando seu status de volta para "Disponível".

* **Controle de Permissões:**
  - O sistema diferencia os tipos de funcionários. Funções críticas como cadastrar ou excluir filmes são restritas a usuários com cargo de `Gerente`.

### 3. Conceitos de POO Aplicados

Este projeto foi estruturado para atender a todos os critérios de POO exigidos na avaliação:

- **Classes e Objetos:** O sistema é modularizado em várias classes que representam entidades do mundo real (`Filme`, `Funcionario`) e serviços (`Locadora`). A classe `Main` orquestra a criação e interação desses objetos.

- **Encapsulamento:** Todos os atributos das classes de modelo (`Filme`, `Funcionario`, etc.) são declarados como `private`, com acesso controlado por meio de métodos `getters` e `setters`.

- **Herança:** Foi criada uma hierarquia de classes para os funcionários. As classes `Gerente` e `Colaborador` herdam (`extends`) da classe base `Funcionario`, reutilizando código e especializando o comportamento.

- **Polimorfismo:** O método `apresentar()` da classe `Funcionario` é sobrescrito (`@Override`) nas classes filhas (`Gerente`, `Colaborador`), permitindo que cada tipo de funcionário se "apresente" de forma diferente.

- **Coleções:** A classe `Locadora` utiliza `ArrayList` do Java Collections Framework para armazenar em memória a lista de funcionários cadastrados e o catálogo de filmes.

- **Tratamento de Erros:** A classe `Main` utiliza blocos `try-catch` para lidar com `InputMismatchException`, garantindo que o programa não encerre abruptamente caso o usuário digite um texto em um menu que espera um número.

### 4. Tecnologias Utilizadas

* **Linguagem:** Java
* **IDE:** IntelliJ IDEA
* **Controle de Versão:** Git & GitHub

### 5. Como Executar

Para compilar e executar o projeto, siga os passos abaixo:

**Pré-requisitos:**
* Ter o **Java Development Kit (JDK)** versão 17 ou superior instalado e configurado nas variáveis de ambiente.

**Passos:**

1.  **Clone o Repositório**
    Abra o terminal ou Git Bash e clone o projeto para o seu computador
    
2.  **Navegue até a Pasta do Projeto**
    ```bash
    cd [NOME-DA-PASTA-DO-PROJETO]
    ```

3.  **Compile o Código-Fonte**
    Execute o seguinte comando a partir da pasta raiz do projeto para compilar todas as classes:
    ```bash
    javac -d out src/br/com/cinepixel/ui/*.java src/br/com/cinepixel/service/*.java src/br/com/cinepixel/modelos/*.java
    ```
    *Este comando compila todos os arquivos `.java` e organiza os arquivos `.class` gerados dentro de uma pasta `out`, respeitando a estrutura de pacotes.*

4.  **Execute o Programa**
    Use o comando abaixo para iniciar a aplicação:
    ```bash
    java -cp out br.com.cinepixel.ui.CinePixel
    ```
    *O `-cp out` diz ao Java para procurar as classes compiladas dentro da pasta `out`.*

5.  **Acesse o Sistema**
- **Login:** `admin`
- **Senha:** `1234`

### 6. Membros da Equipe

- [Carolini Aparecida Silva Santos]
- [Diego Xavier Celeste]
- [Kauã Silveira Claudino]
- [Kevin Garcia Gomes]
