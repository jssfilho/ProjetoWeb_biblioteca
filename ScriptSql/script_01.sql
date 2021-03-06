/*create database biblioteca;
create table biblioteca.autor(
    cod integer primary key NOT NULL AUTO_INCREMENT,
    nome varchar(40) not null,
    email varchar(50) not null
);
*/
create table biblioteca.editora(
    cod integer primary key NOT NULL AUTO_INCREMENT,
    nome varchar(40) not null,
    cnpj varchar(30) not null
);
create table biblioteca.colecao(
    cod integer primary key NOT NULL AUTO_INCREMENT,
    nome varchar(40) not null,
    genero varchar(50) not null
);
/*
create table biblioteca.obra(
    cod integer primary key NOT NULL AUTO_INCREMENT,
    titulo varchar(40) not null,
    descricao varchar(50) not null,
    cod_editora integer,
    cod_colecao integer
);

create table biblioteca.obra_autor (
	cod integer primary key NOT NULL AUTO_INCREMENT,
    cod_obra integer,
    cod_autor integer,
    FOREIGN KEY (cod_obra) REFERENCES biblioteca.obra(cod),
    FOREIGN KEY (cod_autor) REFERENCES biblioteca.autor(cod)
);
*/
