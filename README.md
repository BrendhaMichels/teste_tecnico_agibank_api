# Projeto de Testes Automatizados - Dog API

Este repositório contém um conjunto de testes de API automatizados para a [Dog API](https://dog.ceo/dog-api/), desenvolvido como parte de um desafio técnico para QA.

O projeto foi construído em Java, utilizando RestAssured para realizar as requisições HTTP e TestNG como framework de testes.

## 🚀 Tecnologias Utilizadas
* **Linguagem:** Java
* **Testes de API:** RestAssured
* **Framework de Teste:** TestNG
* **Gerenciador de Dependências:** Apache Maven
* **Relatórios:** ExtentReports

## 📋 Pré-requisitos
Para executar este projeto, você precisará ter instalado em sua máquina:
* JDK 11 ou superior
* Apache Maven

## ⚙️ Configuração do Ambiente
1.  Clone este repositório para a sua máquina local:
    ```bash
    git clone https://github.com/BrendhaMichels/teste_tecnico_agibank_api.git
    ```
2.  Navegue até a pasta raiz do projeto:
    ```bash
    cd teste_tecnico_agibank_api
    ```
3.  O Maven cuidará do download de todas as dependências necessárias automaticamente.

## ▶️ Como Executar os Testes
A suíte de testes é controlada pelo arquivo `testng.xml`. Para executar todos os testes de validação da API, utilize o seguinte comando Maven no terminal a partir da raiz do projeto:

```bash
mvn clean test
```

## 📊 Relatório de Testes
Após a execução, um relatório HTML interativo é gerado pelo **ExtentReports**.

1.  Uma pasta chamada `reports` será criada na raiz do projeto.
2.  Dentro dela, você encontrará o arquivo `extent-report.html`.
3.  Abra este arquivo em qualquer navegador para visualizar os resultados detalhados de cada teste.

## 🧪 Cenários de Teste Automatizados

O projeto valida os principais endpoints da Dog API, cobrindo os seguintes cenários:

1.  **Listar Todas as Raças (`GET /breeds/list/all`)**: Valida se a API retorna o status `200 OK` e uma lista de todas as raças de cachorros.
2.  **Buscar Imagens por Raça Válida (`GET /breed/{breed}/images`)**: Garante que, para uma raça existente (ex: "hound"), a API retorna `200 OK` e uma lista de URLs de imagens.
3.  **Buscar Imagens por Raça Inválida (`GET /breed/{breed}/images`)**: Valida o tratamento de erro da API, garantindo que a busca por uma raça inexistente (ex: "gato") retorna o status `404 Not Found`.
4.  **Buscar Imagem Aleatória (`GET /breeds/image/random`)**: Confere se a API retorna `200 OK` e uma URL de imagem válida.
5.  **Listar Sub-raças (`GET /breed/{breed}/list`)**: Testa se a API lista corretamente as sub-raças de uma raça principal (ex: "boston" como sub-raça de "bulldog").
6.  **Buscar Múltiplas Imagens Aleatórias (`GET /breed/{breed}/images/random/{count}`)**: Valida se a API retorna o número exato de imagens solicitado (ex: 3 imagens para a raça "hound").