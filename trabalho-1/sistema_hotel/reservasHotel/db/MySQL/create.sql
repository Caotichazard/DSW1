create database Hoteis;

use Hoteis;

create table Hotel(cnpj varchar(18) not null, nome varchar(256) not null, cidade varchar(256) not null, email  varchar(256) not null, senha  varchar(64) not null, primary key (cnpj));
create table Promocoes(id bigint not null auto_increment, url varchar(256) not null, hotel varchar(256) not null, preco varchar(256), inicio date unique, fim date unique, primary key(id));
create table SiteReservas(email varchar(256) not null, senha varchar(64) not null, url varchar(256) not null, nome varchar(256) not null, telefone varchar(256) not null, primary key(url));
create table Usuario(id bigint not null auto_increment, nome varchar(256) not null, login varchar(256) not null unique, senha varchar(64) not null, papel varchar(10), primary key (id));


insert into Usuario(nome, login, senha, papel) values ('Administrador', 'admin', 'admin', 'ADMIN');

insert into SiteReservas(email, senha, url, nome, telefone) values  ("site@site.com", 'site123', 'siteDeReservas.com', 'Site de Reservas','736452918');
insert into Usuario(nome, login, senha, papel) values ('Site de Reservas', 'site@site.com', 'site123', 'SITE');

insert into SiteReservas(email, senha, url, nome, telefone) values  ("trovago@reservas.com", 'trovago123', 'trovago.com', 'Trovago','837625163');
insert into Usuario(nome, login, senha, papel) values ('Trovago', 'trovago@reservas.com', 'trovago123', 'SITE');


insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-99', 'Hotel hoteleiro', 'São Hotel', "hotel@hotel.com",'hotel123');
insert into Usuario(nome, login, senha, papel) values ('Hotel hoteleiro', 'hotel@hotel.com', 'hotel123', 'HOTEL');

insert into Hotel(cnpj, nome, cidade, email, senha) values  ('55.789.390/0008-99', 'Ibas Hotel', 'Nova uorqui', "ibas@hotel.com",'ibas123');
insert into Usuario(nome, login, senha, papel) values ('Ibas Hotel', 'ibas@hotel.com', 'ibas123', 'HOTEL');

