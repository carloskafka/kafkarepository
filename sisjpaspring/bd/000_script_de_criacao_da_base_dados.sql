/* Drop Tables */

DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS fornecedor;
DROP TABLE IF EXISTS conta_acesso;


/* Create Tables */

CREATE TABLE cliente
(
	id bigserial NOT NULL,
	nome varchar(100),
	cnpj varchar(100),
	razao_social varchar(100),
	email varchar(100),
	telefone varchar(100),
	versao varchar(100),
	PRIMARY KEY (id)
) WITHOUT OIDS;


CREATE TABLE fornecedor
(
	id bigserial NOT NULL,
	nome varchar(100),
	nome_fantasia varchar(100),
	cnpj varchar(100),
	PRIMARY KEY (id)
) WITHOUT OIDS;

CREATE TABLE conta_acesso
(
  id bigserial NOT NULL,
  login character varying(100),
  senha character varying(100),  
  token character varying(36),
  CONSTRAINT conta_acesso_pkey PRIMARY KEY (id)
) WITHOUT OIDS;

