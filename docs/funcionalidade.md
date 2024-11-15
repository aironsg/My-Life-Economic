# Funcionalidades do App

## Telas do Aplicativo

### Tela Splash
1. A tela deverá ter a logo do app centralizada.
2. A tela deverá exibir o nome do app abaixo da logo.
3. A tela deverá incluir uma barra de progresso circular para indicar o carregamento dos dados.

---

### Tela Login
1. A tela deverá exibir o título **"BEM-VINDO"**.
2. A tela deverá incluir uma imagem pré-definida no layout.
3. A tela deverá conter os campos:
    - **E-mail**
    - **Senha**
4. A tela deverá exibir um texto clicável com a frase **"Esqueceu a senha?"**:
    - 4.1 Ao clicar, o sistema deverá redirecionar o usuário para a tela de recuperação de senha.
5. A tela deverá ter um botão de **Login**.
6. A tela deverá exibir um texto clicável com a frase **"Criar conta"**:
    - 6.1 Ao clicar, o sistema deverá redirecionar o usuário para a tela de criação de conta.

---

### Tela Criação de Conta
1. A tela deverá exibir o título **"CRIAR CONTA"**.
2. A tela deverá incluir uma imagem pré-definida no layout.
3. A tela deverá conter os campos:
    - **Nome**
    - **E-mail**
    - **Telefone**
    - **Senha**
4. A tela deverá exibir um texto clicável com a frase **"Já possui uma conta?"**:
    - 4.1 Ao clicar, o sistema deverá redirecionar o usuário para a tela de login.
5. A tela deverá ter um botão de **Criar conta**.

---

### Tela Recuperação de Conta
1. O sistema deverá ter **duas telas** para recuperação de conta.

#### Tela Principal
2.1 A tela deverá ter um botão de retorno.  
2.2 A tela deverá exibir o título **"RESETE SUA SENHA"**.  
2.3 A tela deverá incluir uma imagem de apresentação.  
2.4 A tela deverá conter um campo para inserir o e-mail.  
2.5 O sistema não permitirá o envio de e-mails mal formatados.  
2.6 O sistema deverá enviar um e-mail de recuperação após a confirmação do usuário.  
2.7 O sistema deverá confirmar se o e-mail fornecido está correto.  

#### Tela Secundária
3.1 A tela deverá exibir o título **"CHEQUE SEU EMAIL"**.  
3.2 A tela deverá apresentar uma mensagem explicativa para o usuário.  
3.3 A tela deverá incluir um botão de **Login**:
   - 3.3.1 Ao clicar, o sistema deverá redirecionar o usuário para a tela de login.

---

### Tela Home
1. O sistema deverá exibir os dados das transações em formato de lista dentro de **cards clicáveis**.
2. A tela deverá ter uma **AppBar**.
3. A tela deverá incluir um card de apresentação de saldo entre a AppBar e o corpo da tela:
    - 3.1 O card deverá mostrar o saldo total.  
    - 3.2 O card deverá exibir o total de despesas.  
    - 3.3 O card deverá exibir o total de receitas.  
4. O card deverá incluir um botão para ocultar o saldo total.  
5. A tela deverá ter um botão flutuante na parte inferior (**FloatingActionButton**):
    - 5.1 O botão deverá redirecionar o usuário para a tela de nova transação.  
6. A tela deverá incluir uma barra de navegação inferior (**BottomBar**):
    - 6.1 As opções da barra deverão ser: **Home, Estatística, Carteira, Perfil**.

---

### Tela Estatística
1. A tela deverá conter botões de seleção:
    - **Dia**
    - **Semana**
    - **Mês**
    - **Ano**
    - 1.1 Os botões ficarão acima do gráfico.
2. A tela deverá exibir um campo para gráficos na parte superior.
3. Gráficos:
    - 3.1 Categorias: **Receitas, Despesas**.
    - 3.2 Períodos: **Dia, Semana, Mês, Ano**.
4. A tela deverá exibir as transações de maior relevância:
    - 4.1 Botão para alternar entre maior e menor valor.
    - 4.2 Botão para alternar entre receitas e despesas.
5. A tela deverá apresentar as transações em formato de **cards**, que mudam de cor quando selecionados:
    - 5.1 O card selecionado deverá redirecionar o usuário para a tela de detalhes da transação.
6. A tela deverá incluir uma **BottomBar**:
    - 6.1 As opções na barra deverão ser: **Home, Estatística, Carteira, Perfil**.

---

### Tela Detalhe da Transação
1. A tela deverá exibir as seguintes informações sobre a transação:
    - **Status**
    - **Detalhe**
    - **Valor**
    - **Data**
2. A tela deverá ter um botão para fazer o download da transação em formato **PDF**.
3. A tela deverá ter um botão de voltar na **AppBar**.
4. A tela deverá incluir um título na AppBar: **"Detalhe da Transação"**.

---

### Tela Carteira
1. A tela deverá apresentar uma lista de transações ordenadas por data de criação.
2. A tela deverá ter um botão de voltar na **AppBar**.
3. A tela deverá incluir um título na AppBar: **"Carteira"**.

---

### Tela Perfil
1. O sistema deverá ter **três telas** relacionadas ao perfil: **Principal, Alterar Nome, Alterar Senha**.

#### Tela Principal
2.1 A tela deverá exibir uma imagem de perfil onde o usuário poderá inserir sua foto.  
2.2 A tela deverá incluir o título **"Perfil"**.  
2.3 A tela deverá mostrar o nome do usuário abaixo da foto.  
2.4 A tela deverá exibir o e-mail do usuário.  
2.5 A tela deverá incluir botões para:
    - **Alterar Nome**
    - **Alterar Senha**
    - **Deslogar**
2.6 A tela deverá incluir uma **BottomBar**:
    - 2.6.1 As opções na barra deverão ser: **Home, Estatística, Carteira, Perfil**.

#### Tela Alterar Nome
3.1 A tela deverá exibir o título **"Perfil"**.  
3.2 A tela deverá incluir campos para inserir o novo nome do usuário.  
3.3 A tela deverá ter botões para **Salvar** e **Cancelar**.

#### Tela Alterar Senha
4.1 A tela deverá exibir o título **"Perfil"**.  
4.2 A tela deverá incluir campos para inserir a nova senha do usuário.  
4.3 A tela deverá ter botões para **Salvar** e **Cancelar**.

---
