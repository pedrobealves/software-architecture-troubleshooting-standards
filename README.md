# software-architecture-troubleshooting-standards
Development of the architectural structures for norms for Anticipation, Substitution and Replacement of face-to-face classes of UTFPR Technical and Professional Education Courses.

## Testes

###### Testes de integração

> src/test/java/br/edu/utfpr/troubleshootingstandards/repository

###### Testes unitários

> src/test/java/br/edu/utfpr/troubleshootingstandards/service

## Descrição do sistema

![Camadas do projeto](https://raw.githubusercontent.com/trecky/software-architecture-troubleshooting-standards/develop/docs/pkg.png)


* **DTO** - transferir vários elementos de dados.
* **Repository** - encapsula o acesso e a manipulação de dados.
* **Service** - mantém as regras de negócio.
* **Model** - entidades a serem persististidas.
* **Exceptions** - exceções do sistema.

#### Diagramas de atividade

![Proposta de antecipação](https://raw.githubusercontent.com/trecky/software-architecture-troubleshooting-standards/develop/docs/Proposta%20de%20Antecipa%C3%A7%C3%A3o.png)

![Aprovação de antecipação](https://raw.githubusercontent.com/trecky/software-architecture-troubleshooting-standards/develop/docs/Aprova%C3%A7%C3%A3o%20de%20Proposta%20de%20Antecipa%C3%A7%C3%A3o.png)
