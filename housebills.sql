-- drop database housebills;
-- create database housebills;
-- use housebills;
CREATE TABLE Usuario (
    idUsuario int (2) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome VARCHAR (100),
    telefone CHAR (11),
    email VARCHAR(30),
    endereco VARCHAR(100),
    ocupacao VARCHAR (100),
    renda DOUBLE,
    senha VARCHAR(30)
);

CREATE TABLE Grupo (
    idGrupo int (2) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nomeGrupo VARCHAR (30),
    endereco VARCHAR (30),
    telefone CHAR (11)
);

CREATE TABLE Conta (
    idConta int(2) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo VARCHAR (30)
);

CREATE TABLE Paga (
    paga_id int(2) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_usuario int(2),
    grupo_id int (2),
    conta_id int (2),
    valor_conta DOUBLE,
    valor_pago DOUBLE,
    parcelamento int (10),
    data_pagamento DATE,
    data_vencimento DATE,
    juros DOUBLE
);

ALTER TABLE Paga ADD CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES Usuario(idUsuario);
ALTER TABLE Paga ADD CONSTRAINT fk_grupo FOREIGN KEY (conta_id) REFERENCES Conta(idConta);
ALTER TABLE Paga ADD CONSTRAINT fk_conta FOREIGN KEY (grupo_id) REFERENCES Grupo(idGrupo);
   