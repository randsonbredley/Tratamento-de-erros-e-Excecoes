[readme_simulador_de_animais_exce_es_e_polimorfismo.md](https://github.com/user-attachments/files/33513547/readme_simulador_de_animais_exce_es_e_polimorfismo.md)
# Simulador de Animais: Exceções em Java com Herança e Polimorfismo

Este projeto foi desenvolvido como parte da atividade prática de **Programação Orientada a Objetos (POO)** do **Instituto Federal de Pernambuco - Campus Belo Jardim**.

O objetivo principal é demonstrar o tratamento de erros customizados em Java utilizando os conceitos de **Herança**, **Polimorfismo** (relacionamento *IS-A / É-UM*) e **Sobrescrita de Métodos (@Override)**.

---

## 🛠️ Conceitos Aplicados

* **Exceções Customizadas:** Criação de exceções próprias herdando da classe nativa `Exception`.
* **Herança:** Hierarquia entre classes de erro (`AnimalException` -> `HungryAnimalException` / `TiredAnimalException`) e classes de domínio (`Animal` -> `Canine` -> `Dog`).
* **Polimorfismo no Tratamento de Exceções:** Captura de múltiplas exceções filhas utilizando uma referência da superclasse (`catch (AnimalException a)`).
* **Modificadores de Acesso e Encapsulamento:** Uso dos modificadores `private` e `public` com métodos seletores (*getters*).
* **Sobrescrita (@Override):** Redefinição do comportamento do método `roam()` em subclasses para regras específicas de energia.

---

## 📂 Estrutura do Projeto

```text
src/
├── Animal.java                # Superclasse base para os animais
├── Canine.java                # Subclasse intermediária
├── Dog.java                   # Subclasse que sobrescreve o método roam()
├── AnimalException.java       # Exceção base do domínio animal
├── HungryAnimalException.java # Exceção disparada quando o nível de fome é elevado (> 10)
├── TiredAnimalException.java  # Exceção disparada quando o nível de energia é baixo (< 5)
└── Simulador.java             # Classe principal que executa o loop de testes
```

---

## 💻 Classes e Implementações

### 1. Hierarquia de Exceções Customizadas

* **`AnimalException.java`**
  ```java
  public class AnimalException extends Exception {
      public AnimalException(String mensagem) {
          super(mensagem);
      }
  }
  ```

* **`HungryAnimalException.java`**
  ```java
  public class HungryAnimalException extends AnimalException {
      public HungryAnimalException(String mensagem) {
          super(mensagem);
      }
  }
  ```

* **`TiredAnimalException.java`**
  ```java
  public class TiredAnimalException extends AnimalException {
      public TiredAnimalException(String mensagem) {
          super(mensagem);
      }
  }
  ```

---

### 2. Classes do Domínio

* **`Animal.java`**
  ```java
  public class Animal {
      private int hunger;
      private int energia;

      public Animal(int hunger, int energia) {
          this.hunger = hunger;
          this.energia = energia;
      }

      public int getHunger() {
          return this.hunger;
      }

      public int getEnergia() {
          return this.energia;
      }

      public void eat() {
          System.out.println("O animal comeu e não está mais com fome.");
          this.hunger = 0;
      }

      public void roam() throws AnimalException {
          if (this.hunger > 10) {
              throw new HungryAnimalException("O animal está muito faminto para andar!");
          }
          System.out.println("O animal está vagando pelo ambiente.");
      }
  }
  ```

* **`Dog.java`**
  ```java
  public class Dog extends Canine {

      public Dog(int hunger, int energia) {
          super(hunger, energia);
      }

      @Override
      public void roam() throws AnimalException {
          if (getEnergia() < 5) {
              throw new TiredAnimalException("O cão está cansado demais para andar!");
          }
          super.roam();
      }
  }
  ```

---

### 3. Execução e Polimorfismo

* **`Simulador.java`**
  ```java
  public class Simulador {
      public static void main(String[] args) {
          Animal[] animais = new Animal[3];

          animais[0] = new Animal(5, 10);  // Estado normal
          animais[1] = new Animal(15, 10); // Lança HungryAnimalException
          animais[2] = new Dog(3, 2);      // Lança TiredAnimalException

          for (int i = 0; i < animais.length; i++) {
              System.out.println("\n--- Testando Animal " + (i + 1) + " ---");
              try {
                  animais[i].roam();
              } catch (AnimalException a) {
                  System.out.println("ERRO CAPTURADO: " + a.getMessage());
                  System.out.println("Alimentando o animal...");
                  animais[i].eat();
              }
          }
      }
  }
  ```

---

## ❓ Questão de Reflexão

> **Por que o mesmo bloco `catch (AnimalException a)` captura o novo erro (`TiredAnimalException`) sem a necessidade de alterar a classe `Simulador`?**

**Resposta:**
Isso ocorre devido aos conceitos de **Herança** e **Polimorfismo**:
1. **Regra IS-A (É-UM):** Como `TiredAnimalException` estende `AnimalException`, a nova exceção passa no teste *IS-A* (ou seja, `TiredAnimalException` **É-UMA** `AnimalException`).
2. **Polimorfismo:** No bloco `catch (AnimalException a)`, a variável de referência `a` é do tipo genérico `AnimalException`. Por polimorfismo, ela consegue capturar e manipular qualquer objeto cuja classe seja uma subclasse derivada de `AnimalException` (`HungryAnimalException` ou `TiredAnimalException`).

---

## 🚀 Como Executar o Projeto

1. Clone o repositório ou baixe os ficheiros do código-fonte.
2. Certifique-se de que possui o **JDK 8+** instalado.
3. Compile todas as classes `.java`:
   ```bash
   javac *.java
   ```
4. Execute a classe principal `Simulador`:
   ```bash
   java Simulador
   ```
