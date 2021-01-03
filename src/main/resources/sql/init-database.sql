-- RESET DATABASE
drop table if exists VIDEOTECADB.REGIA;
drop table if exists VIDEOTECADB.CAST;
drop table if exists VIDEOTECADB.ATTORI;
drop table if exists VIDEOTECADB.REGISTI;
drop table if exists VIDEOTECADB.FILM;

-- CREAZIONE DELLA TABELLA FILM
create table VIDEOTECADB.FILM
(
	TITOLO varchar(100) primary key,
	GENERE varchar(25),
	ANNO  smallint
);

-- CREAZIONE DELLA TABELLA REGISTI
create table VIDEOTECADB.REGISTI
(
	ID_NOME      varchar(70) primary key,
	NOME         varchar(40) not null,
	COGNOME      varchar(30) not null,
	DATA_NASCITA date,
	DATA_MORTE   date
);

-- CREAZIONE DELLA TABELLA ATTORI
create table VIDEOTECADB.ATTORI
(
	ID_NOME      varchar(70) primary key,
	NOME         varchar(40) not null,
	COGNOME      varchar(30) not null,
	DATA_NASCITA date,
	DATA_MORTE   date
);

-- CREAZIONE TABELLA REGIA
create table VIDEOTECADB.REGIA
(
	TITOLO  varchar(100),
	ID_NOME varchar(70),
	foreign key (TITOLO)  references VIDEOTECADB.FILM(TITOLO),
	foreign key (ID_NOME) references VIDEOTECADB.REGISTI(ID_NOME),
	primary key (TITOLO, ID_NOME)
);

-- CREAZIONE TABELLA CAST
create table VIDEOTECADB.CAST
(
	TITOLO  varchar(100),
	ID_NOME varchar(70),
	foreign key (TITOLO)  references VIDEOTECADB.FILM(TITOLO),
	foreign key (ID_NOME) references VIDEOTECADB.ATTORI(ID_NOME),
	primary key (TITOLO, ID_NOME)
);