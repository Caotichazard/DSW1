create database Hoteis;

use Hoteis;

create table Hotel(cnpj varchar(18) not null, nome varchar(256) not null, cidade varchar(256) not null, email  varchar(256) not null, senha  varchar(256) not null, primary key (cnpj));


insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-99', 'Bir bir', 'Bor bor', "aaaaa@bbbb.cccc",'123456789');

insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-98', 'Bar bar', 'Bor bor', "aaaaa@bbbb.cccc",'123456789');

insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-97', 'Ber ber', 'Bor bor', "aaaaa@bbbb.cccc",'123456789');

insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-96', 'Bur bur', 'Bor bor', "aaaaa@bbbb.cccc",'123456789');



