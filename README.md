# 📍 EventManager - Java Console Application

Sistema de **cadastro e notificação de eventos** da sua cidade, desenvolvido em Java no estilo console e seguindo o paradigma de programação orientada a objetos.

---

## 🚀 Funcionalidades

- Cadastro de usuários
- Criação de eventos (com nome, endereço, categoria, data/hora e descrição)
- Participação em eventos
- Cancelamento de participação
- Consulta de eventos futuros, passados e ocorrendo no momento
- Armazenamento e leitura de dados do arquivo `events.data`

---

## 🧱 Estrutura do Projeto

```
EventManager/
├── Main.java
├── User.java
├── Event.java
├── EventManager.java
├── FileManager.java
└── events.data (criado em tempo de execução)
```

---

## 💻 Requisitos

- Java JDK 17 ou superior
- [VS Code](https://code.visualstudio.com/)
- Extensão: [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

---

## ✅ Como rodar o projeto no VS Code

### 1. Baixe e extraia o ZIP

> Extraia `EventManager.zip` em uma pasta local, por exemplo:
> `C:\Users\SeuNome\Documentos\EventManager`

### 2. Abra no VS Code

- Vá em **File > Open Folder...** e selecione a pasta extraída

### 3. Compile e execute

- Abra `Main.java`
- Clique no botão de **executar (▶️)** no canto superior direito
- Ou use o terminal:

```bash
javac *.java
java Main
```

---

## 📝 Observações

- Os eventos são salvos automaticamente no arquivo `events.data`
- O sistema reconhece e carrega os eventos existentes ao iniciar

---

## 📘 Exemplo de uso

```
=== Cadastro de Usuário ===
Nome: João
Email: joao@email.com
Cidade: Porto Alegre

=== Menu ===
1. Cadastrar novo evento
2. Listar eventos disponíveis
3. Participar de evento
4. Cancelar participação
5. Meus eventos
6. Eventos já ocorridos
7. Checar evento atual
0. Sair
```

---

## 📄 Licença

Este projeto é acadêmico e pode ser usado livremente para fins educacionais.