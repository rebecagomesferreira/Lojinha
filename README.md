# Lojinha - Sistema de Compras em Java

Projeto desenvolvido em Java com o objetivo de simular o funcionamento 
básico de uma loja virtual via console, aplicando conceitos fundamentais de POO.

---

# Funcionalidades

- Listagem de produtos
- Adição de itens ao carrinho
- Visualização do carrinho
- Escolha de forma de pagamento
- Finalização de pedido
- Controle de estoque

---

# Conceitos aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Separação de responsabilidades
- Uso de `List` e `Stream`
- Enum (`TipoPagamento`)
- Validação de dados
- Controle de estado (estoque)

---

# Fluxo da aplicação

1. O sistema exibe os produtos disponíveis
2. O usuário escolhe um produto e quantidade
3. O item é adicionado ao carrinho
4. O usuário pode visualizar o carrinho
5. Escolhe a forma de pagamento
6. O pedido é finalizado

---

# Como executar o projeto

 Pré-requisitos

- Java JDK 17+
- VS Code ou outra IDE Java

---

# Executando no VS Code

1. Instale a extensão:

   - Extension Pack for Java

2. Abra a pasta do projeto

3. Execute o arquivo:

   ```
   Main.java
   ```

---

# Validações implementadas

* Entrada inválida (evita quebra do sistema)
* Quantidade negativa ou zero
* Controle de estoque
* Carrinho vazio ao finalizar pedido

---

# Sobre o padrão Singleton

O padrão Singleton garante que uma classe tenha apenas uma instância 
durante toda a execução.

Ele pode ser aplicado neste projeto, por exemplo, para:

* Gerenciar o carrinho global
* Controlar configurações do sistema

  Exemplo:

```java
public class Configuracao {

    private static Configuracao instancia;

    private Configuracao() {}

    public static Configuracao getInstancia() {
        if (instancia == null) {
            instancia = new Configuracao();
        }
        return instancia;
    }
}
```
