# Documentação do Aplicativo My Life Economic (Minha Vida Econômica)

## Índice
1. [Introdução](#introdução)
2. [Requisitos Funcionais](#requisitos-funcionais)
   - [Cadastro de Receita/Despesa](#cadastro-de-receitadespesa)
   - [Relatórios Financeiros](#relatórios-financeiros)
   - [Login e Registro](#login-e-registro)
   - [Recuperação de Conta](#recuperação-de-conta)
   - [Perfil](#perfil)
   - [Carteira](#carteira)
   - [Carregamento de Dados](#carregamento-de-dados)
3. [Requisitos Não Funcionais](#requisitos-não-funcionais)
   - [Desempenho](#desempenho)
   - [Usabilidade](#usabilidade)
   - [Confiabilidade](#confiabilidade)
   - [Segurança](#segurança)
   - [Compatibilidade](#compatibilidade)
   - [Manutenibilidade](#manutenibilidade)
4. [Notas Finais](#notas-finais)

---

## Introdução
Este documento descreve os requisitos funcionais e não funcionais para o aplicativo **My Life Economic**. Ele foi elaborado para garantir clareza no desenvolvimento e na implementação das funcionalidades principais, bem como para atender aos objetivos de usabilidade, desempenho e segurança.

---

## Requisitos Funcionais

### Cadastro de Receita/Despesa
1. O sistema deve permitir ao usuário cadastrar receitas e despesas.
2. O sistema deve permitir que o usuário informe:
   - **Valor da transação**: mínimo de R$ 0,01 e máximo de R$ 100.000,00.
   - **Categoria da transação**: selecionada de uma lista ou personalizada pelo usuário.
   - **Descrição da transação**: exemplo: "Conta de energia".
   - **Tipo de transação**: receita ou despesa.
   - **Data da transação**.
3. O sistema deve validar que todos os campos estão preenchidos.
4. Antes de salvar a transação, o sistema deve exibir um card de confirmação com as informações preenchidas e solicitar ao usuário a validação final.
5. O sistema deve inserir a data atual do sistema, caso o usuário não escolha uma.

---

### Relatórios Financeiros
1. O sistema deve gerar relatórios financeiros com base nos seguintes filtros:
   - Período **diário**
   - Período **semanal**
   - Período **mensal**
   - Período **anual**
2. O sistema deve exibir gráficos detalhados com o percentual gasto em cada categoria.
   - O sistema deve mostrar um gráfico de linha com os períodos de despesas e receitas.
3. O sistema deve permitir exportar relatórios em formatos como **PDF**.

---

### Recuperação de Conta
1. O sistema deve permitir que o usuário solicite a recuperação de conta por email.
2. O sistema deve enviar um link de recuperação ao email cadastrado.
3. O sistema deve mostrar uma mensagem de aviso, informando o email digitado e permitindo o cancelamento.
4. O sistema deve levar o usuário para a tela de login após o envio do email de redefinição de senha.

---

### Registro
1. O sistema deve permitir que novos usuários se registrem com:
   - **Nome**.
   - **Email**: único e válido.
   - **Telefone**.
   - **Senha**.
2. O sistema deve validar o formato do email conforme o padrão (ex.: usuario@dominio.com).
3. O sistema deve levar o usuário para a tela principal após a conclusão do cadastro.
4. O sistema deve validar que todos os campos foram preenchidos.
5. O sistema deve armazenar as informações do novo usuário no sistema de autenticação remoto.

---

### Login
1. O sistema deve permitir que usuários façam login com:
   - **Email**: único e válido.
   - **Senha**.
2. O sistema deve validar o formato do email conforme o padrão (ex.: usuario@dominio.com).
3. O sistema deve permitir login com biometria para usuários registrados.

---

### Perfil
1. O sistema deve permitir que usuários adicionem uma foto de perfil a partir da galeria do dispositivo.
2. O sistema deve redirecionar o usuário para as sub-telas quando os botões correspondentes forem clicados.
3. O sistema deve deslogar o usuário quando o botão "Deslogar" for pressionado, exibindo uma mensagem de confirmação.
4. O sistema deve exibir o nome e o email do usuário cadastrados.
5. O sistema deve validar os campos de nome e senha antes de realizar atualizações.

---

### Carteira
1. O sistema deve listar todas as transações do usuário por ordem de data, da mais recente para a mais antiga.
2. O sistema deve permitir a filtragem de transações por tipo (receita ou despesa).
3. O sistema deve exibir os detalhes de cada transação em uma tela específica.
4. O sistema deve permitir o download de transações selecionadas em formato **PDF**.

---

### Carregamento de Dados
1. O sistema deve carregar os dados do servidor durante a exibição da tela **Splash**.
2. O sistema deve buscar os dados de login do usuário no servidor.
3. Caso o usuário não seja encontrado no servidor, ele deve ser redirecionado para a tela de login.
4. O sistema deve informar o usuário caso não haja conexão com a internet.
5. O sistema deve armazenar os dados localmente e também na nuvem.

---

## Requisitos Não Funcionais

### Desempenho
- O sistema deve carregar as telas principais em até **2 segundos** em dispositivos com configuração mínima de **4 GB de RAM**.
- Consultas e geração de relatórios devem ser concluídas em até **5 segundos**.

---

### Usabilidade
- A interface deve seguir os padrões do **Material Design**.
- Mensagens de erro devem ser claras, ajudando o usuário a corrigir problemas.
- A interface deve ser responsiva em diferentes tamanhos de tela.

---

### Confiabilidade
- O sistema deve realizar backups automáticos das transações localmente e na nuvem.
- Deve ser capaz de suportar até **100.000 transações** sem degradação de desempenho.

---

### Segurança
- Senhas devem ser armazenadas de forma **criptografada**.
- Alterações críticas devem exigir autenticação.

---

### Compatibilidade
- O sistema deve ser compatível com **Android 10.0** ou superior.

---

### Manutenibilidade
- O código deve seguir boas práticas de desenvolvimento, como **Clean Code** e **Arquitetura Limpa**.
- A documentação técnica e os comentários no código devem estar sempre atualizados.

---

## Notas Finais
Este documento será atualizado conforme novas funcionalidades forem adicionadas. Sugestões ou correções podem ser feitas abrindo uma **issue** no repositório do projeto.
