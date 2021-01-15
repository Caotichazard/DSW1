# Sistema para criação de promoção de quarto de hotel em site de reservas 

Sistema criado com o intuito de possibilitar o cadastro de hoteis e sites de reservas e então permitir a criação de uma promoção em um hotel para ser exibida em um site de reservas

## Membros

Guilherme Locca Salomão\
Martin Heckman\
Reynold Navarro Mazo

## Pré configuração

### Arquivos

Os arquivos do projeto se encontram na pasta Trabalho2/

### Banco de dados
Para o uso deste programa é necessário ter o MySQL instalado na máquina

Usando o arquivo create.sql localizado em sistemaHotel/reservasHotel/dc/MySQL/create.sql

executar os seguintes comandos no terminal na raiz do projeto

`mysql -uroot -p`

`source db/MySQL/create.sql`

Com isso serão geradas as tabelas necessárias para o banco de dados e serão criadas entradas básicas para hoteis e sites de reservas

Entidades criadas:
* Hoteis
    
    * >Ibis Hotel\
      >Usuário: ibis@hotel.com\
      >Senha: ibis123

* Sites de Reserva


    * >Site de Reservas: Trivago\
      >Usuário: trivago@reservas.com\
      >Senha: trivago123

Além dessas entidades, é criado o login de Adiministrador

>ADMIN\
>Usuário: admin\
>Senha: admin

## Requisitos

* R1: CRUD de Hoteis\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Guilherme Salomão (100%)

* R2: CRUD de Sites de Reservas\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Guilherme Salomão (100%)

* R3: Listagem de todos os Hoteis\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Guilherme Salomão (40%), Martin Heckman (60%)

* R4: Listagem de todos os Hoteis de uma cidade\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Martin Heckman (100%)

* R5: Criação de uma promoção de um Hotel\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Guilherme Salomão (40%), Martin Heckman (40%), Reynold Mazo (20%)

* R6: Listagem de todas promoções de um Hotel\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Guilherme Salomão (75%), Reynold Mazo (25%)

* R7: Não permitir duas reservas de um mesmo hotel em um mesmo site na mesma data\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Martin Heckman (100%)

* R8: Listagem de todas as promoções de um Site de Reservas\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Guilherme Salomão (75%), Reynold Mazo (25%)

* R9: Internacionalização do sistema\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Martin Heckman (100%)

* R10: Validação de dados\
  (X) Implementado ( ) Parcialmente implementado ( ) Não implementado\
Divisão na implementação da funcionalidade: Reynold Mazo (100%)