# blackJack-ms
Jogo "Black Jack" ou "21" com linguagem java e springboot em uma estrutura basica de microserviços.<br />

# Tecnologias
Java 11<br />
Estrutura de microserviços<br />
Rest<br />
Oauth<br />
Springboot - starter web, config server, actuator<br />
springCloud - Netflix Eureka(Load Balancer),Netflix Zuul(Apigateway)<br />
h2<br />

# Regras do jogo
Cada jogador puxa apenas uma carta por rodada.<br />
Jogador pode parar de puxar, caso opte por isso ele não podera mais puxar carta até o final do jogo.<br />
Cada Carta vale de 1 a 11 dependendendo da carta por exemplo: A vale 1, 5 vale 5 e K, Q e J vale 11.<br />
A soma da cartas não pode passar de 21, caso passe o jogador perde e esta fora do jogo.<br />
Caso jogador alcance exatamente 21 o jogo acaba ali mesmo e ele é declarado vencedor.<br />
Caso todos jogadores pararem de puxar é declarado vencedor quem esta mais proximo.<br />
Caso 2 ou mais jogadores estejam com a mesma pontuação mais proxima ao 21 é declarado empate e ninguem vence.<br />
Cartas são embaralhadas automaticamente antes de cada jogada.<br />

# Serviços
-As apis estarão disponiveis em um collection postman dentro da pasta resource do projeto bj-partida;<br />
<br />
Temos diversos serviços mas para teste os principais são:<br />
<br />
http://localhost:8765/bj-oauth/oauth/token <br />
Para autenticação e geração do token para acesso a outros serviços.<br />
Autenticação é feita através de Basic Auth credenciais do próprio projeto e username e password de usuarios pré cadastrados.<br />
<br />
http://localhost:8765/bj-partida/partida/iniciaPartida?nomePrimeiroJogador=Jogador1&nomeSegundoJogador=Jogador2&nomeTerceiroJogador=Jogador3&nomeQuartoJogador=Jogador4 <br />
Este serviço é responsavel por inicia uma partida a partir de nome de jogadores passado por Query Param, sendo obrigatório apenas o primeiro e tendo no maximo 4 jogadores.<br />
Necessario autenticação por token bearer de um usuario do tipo jogador ou admin.<br />
<br />
http://localhost:8765/bj-partida/partida/puxaCarta/{idPartida}/{idJogador}?parou=true <br />
Este serviço é o que move o jogo sendo necessario passar o id da partida e o id do jogador por Path Param e opcionalmente por Query Param a boolean chamada parou.<br />
É neste serviço que se aplicam todas as regras do jogo e nele que desenrola a partida.<br />
idPartida não se altera muito é o mesmo do começo ao fim.<br />
idJogador é oque define qual jogador esta puxando ou parando de puxar.<br />
a boolean parou define se o jogador quer parar de puxar carta, ao passar como true.<br />
Necessario autenticação por token bearer de um usuario do tipo jogador ou admin.<br />
<br />
http://localhost:8765/bj-partida/partida/buscaPartida/{idPartida} <br />
Este serviço apenas busca uma partida do banco para caso queira ver o andamento.<br />
Necessario autenticação por token bearer de um usuario do tipo Jogador ou admin.<br />