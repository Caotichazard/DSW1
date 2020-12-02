create database Hoteis;

use Hoteis;

create table Hotel(cnpj varchar(18) not null, nome varchar(256) not null, cidade varchar(256) not null, email  varchar(256) not null, senha  varchar(64) not null, primary key (cnpj));


insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-99', 'Bir bir', 'Bor bor', "aaaaa@bbbb.cccc",'123456789');

insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-98', 'Bar bar', 'Bor bor', "aaaaa@bbbb.cccc",'123456789');

insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-97', 'Ber ber', 'Bor bor', "aaaaa@bbbb.cccc",'123456789');

insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-96', 'Bur bur', 'Bor bor', "aaaaa@bbbb.cccc",'123456789');



create table SiteReservas(email varchar(256) not null, senha varchar(64) not null, url varchar(256) not null, nome varchar(256) not null, telefone varchar(256) not null, primary key(url));

insert into SiteReservas(email, senha, url, nome, telefone) values  ("aaaaa@bbbb.cccc", 'aikasfikqa', 'qaiofaeoadso.ccc', 'aikasfikqa','123456789');

create table Usuario(id bigint not null auto_increment, nome varchar(256) not null, login varchar(256) not null unique, senha varchar(64) not null, papel varchar(10), primary key (id));

insert into Usuario(nome, login, senha, papel) values ('Administrador', 'admin', 'admin', 'ADMIN');


create table Promocoes(id bigint not null auto_increment, url varchar(256) not null, hotel varchar(256) not null, preco varchar(256), inicio date, fim date, primary key(id));