/*create database biblioteca;*/
create table biblioteca.autor(
    cod integer primary key NOT NULL AUTO_INCREMENT,
    nome varchar(40) not null,
    email varchar(50) not null
);
