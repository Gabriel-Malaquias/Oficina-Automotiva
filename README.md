<h1>Sistema de Oficina Automotiva</h1>
<h2>Descrição</h2>
<p>A aplicação tem o objetivo de simular a rotina de serviços prestados por uma oficina automotiva como cadastramento de cliente, veiculo, uma ficha descrevendo o problema a ser resolvido e a exibição de um simples
orçamento. A finalidade deste repositório e mostrar habilidades com a linguagem java interagindo com um banco de dados.</p>
<h2>Demonstração</h2>
<p>O sistema não possui uma interface gráfica implementada e portanto, o seu funcionamento ocorre pelo terminal como nas imagens abaixo:</p>
<img src=""> 
<img src="https://github.com/Gabriel-Malaquias/Oficina-Automotiva/blob/main/Pacote/Imagens_Demonstra%C3%A7%C3%A3o/Veiculo.png">
<img src="https://github.com/Gabriel-Malaquias/Oficina-Automotiva/blob/main/Pacote/Imagens_Demonstra%C3%A7%C3%A3o/Ficha.png">
<img src="https://github.com/Gabriel-Malaquias/Oficina-Automotiva/blob/main/Pacote/Imagens_Demonstra%C3%A7%C3%A3o/Or%C3%A7amento.png">
<img src="https://github.com/Gabriel-Malaquias/Oficina-Automotiva/blob/main/Pacote/Imagens_Demonstra%C3%A7%C3%A3o/Or%C3%A7amento_part2.png">
<h2>Instalação</h2>
<p>1) Baixar o repositório localmente em sua máquina. Para isso, utlize o comando: git clone url_repositorio.
<p>2) Tenha uma IDE apropriada para programar em java e executar o código. Exemplos: Eclipse, JetBrains ou VSCode</p>
<p>3) A aplicação funciona interagindo com um banco de dados. Neste caso, é importante que seja criado uma base de dados em sua máquina e de preferência usando o MYSQL. Para facilitar, abaixo estão 
os comando SQL que criarão todas as tabelas necessárias para que o código funcione:</p>
<div>
  <nav>
    <li>Criação do banco de dados</li>
    <p>
      <pre>
      create database Oficina;
      </pre>
    </p>
    <li>Criação da tabela que armazenará os dados do cliente
    <p>
    <pre>
    create table cliente(
    id_cliente int not null auto_increment,
    nome varchar(50),
    telefone varchar(15),
    cpf varchar(15),<br>
    primary key (id_cliente)
    );</pre></p>
    </li>
    <li>Criação da tabela que armazenará os dados do veículo
    <pre>
    <p>
    create table veiculo(
    id_veiculo int not null auto_increment,
    modelo varchar(20),
    fabricante varchar(20),
    cor varchar(20),
    placa varchar(8),
    dono int,<br>
    primary key (id_veiculo),
    foreign key(dono) references cliente(id_cliente)
    );</p>
    </pre>
    </li>
    <li>Criação da tabela conterá as peças em estoque na oficina
    <p>
    <pre>
    create table estoque_pecas(
    id_peca int not null auto_increment,
    nome_peca varchar(50),
    preco float,<br>
    primary key (id_peca)
    );<br>
    insert into estoque_pecas(id_peca, nome_peca, preco) values 
    (default, 'Kit de Amortecedor', 550),
    (default, 'Kit Coaxins de Motor', 420),
    (default, 'Vela de Ignição', 15),
    (default, 'Correia Dentada', 350),
    (default, 'Bateria Moura 70ah', 360),
    (default, 'Correia do Alternador', 90),
    (default, 'Lanterna de Farol', 40),
    (default, 'Kit Óleo de Motor', 130);
    </pre>
    </p>
    </li>
    <li>Por fim, a criação da tabela que armazenará a ficha do veículo
    <p>
    <pre>
    create table ficha(
    id_ficha int not null auto_increment,
    veiculo_defeito int,
    peca_necessaria int,
    descricao_defeito text,<br>
    primary key (id_ficha)
    );</p>
    alter table ficha add foreign key (veiculo_defeito) references veiculo(id_veiculo);<br>
    alter table ficha add foreign key(peca_necessaria) references estoque_pecas(id_pecas);
    </pre>  
  </li>
  </nav>
</div>
<p>4) Em vista de que a aplicação interage com o banco de dados por meio do JBDC, é necessário configurar este driver na IDE a ser utilizada para executar o código. Isto pode ser feito de formas diferentes a depender
do ambiente que for a ser utilizado para rodar o projeto. No mais, abaixo está o link de download do driver JDBC:</p>
<p>https://dev.mysql.com/downloads/connector/j/</p>
<h2>Uso</h2>
<p>Ao executar o código pela primeira vez não haverá ainda nenhum dado armazenado no banco de dados, por isso é importante lembrar que ao informar o numero de id do dono no cadastramento do veículo o valor será 1. O mesmo
vale para o id do veículo informado no momento de cadastrar a ficha, o valor será 1. Para cada execução que for feita para rodar o código, o valor do id do dono e do veículo informado vai se incrementando. Exemplo:
<div>
  <nav>
    <li>Primeira execução do código: 
      <pre>
      <h3>Cadastramento do Veículo</h3>
      <p>'Informe o número de identificação do dono: 1'</p>
      <h3>Ficha do Veículo</h3>
      <p>'Informe o número de identificação do veículo: 1'</p>
      </pre>
    </li>
    <li>Segunda execução do código:
      <pre>
      <h3>Cadastramento do Veículo</h3>
      <p>'Informe o número de identificação do dono: 2'</p>
      <h3>Ficha do Veículo</h3>
      <p>'Informe o número de identificação do veículo: 2'</p>
      </pre>
    </li>
    <li>Terceira execução do código:
      <pre>
      <h3>Cadastramento do Veículo</h3>
      <p>'Informe o número de identificação do dono: 3'</p>
      <h3>Ficha do Veículo</h3>  
      <p>'Informe o número de identificação do veículo: 3'</p>
      </pre>
    </li>
  </nav>
</div> 
Esta lógica segue para cada execução que for feita para rodar a aplicação
</p>
