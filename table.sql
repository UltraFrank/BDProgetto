drop database if exists unisa3;
create database unisa3;
use unisa3;

create table Aeroporto(
	Acronimo char(3) primary key,
	Nome varchar(20) not null,
	Città varchar(20) not null);
    
create table Amenità(
	Nome varchar(20) primary key);
    
create table Tipologia(
	Nome varchar(20) primary key);
    
create table Direttore(
	CF char(16) primary key,
    Nome varchar(20) not null,
    Cognome varchar(20) not null,
    Indirizzo varchar(20) not null);

create table Compagnia_Aerea(
	Nome varchar(12) primary key,
    NAerei int not null);

create table Collocazione(
	Acronimo char(3),
    Nome varchar(12),
    
	primary key(Acronimo, Nome),
    foreign key(Acronimo) references Aeroporto(Acronimo),
    foreign key(Nome) references Compagnia_Aerea(Nome));
    
create table Gestione(
	Acronimo char(3),
    CF char(16),
    CodiceDipendente varchar(16) not null,
    
	primary key(Acronimo, CF),
    foreign key(Acronimo) references Aeroporto(Acronimo),
    foreign key(CF) references Direttore(CF));
    
create table Clienti(
	CF char(16) primary key,
    Nome varchar(20) not null,
    Cognome varchar(20) not null);
    
create table Biglietto(
	Aereo_di_Riferimento varchar(20),
    Fila int,
    Posto int,
    Costo int not null,
    
    primary key(Aereo_di_Riferimento, Fila, Posto));
    
create table Necessità(
	Aereo_di_Riferimento varchar(20),
    Fila int,
    Posto int,
    CF varchar(16),
    
    primary key(Aereo_di_Riferimento, Fila, Posto, CF),
    foreign key(Aereo_di_Riferimento) references Biglietto(Aereo_di_Riferimento),
    foreign key(Fila) references Biglietto(Fila),
    foreign key(Posto) references Biglietto(Posto),
    foreign key(CF) references Clienti(CF));
    
create table Aereo(
	Codice_Aereo varchar(20) primary key,
	TipoVolo varchar(20) default 'Nazionale',
	Modello varchar(20) not null,
	Prefisso_Nazionale char(5),
	Prefisso_Internazionale char(5));
    
create table Possesso(
	Codice_Aereo varchar(20),
    Nome varchar(12),
    
    primary key(Codice_Aereo,Nome),
	foreign key(Codice_Aereo) references Aereo(Codice_Aereo),
    foreign key(Nome) references Compagnia_Aerea(Nome));
    
create table Prenotazione(
	Aereo_di_Riferimento varchar(20),
    Fila int,
    Posto int,
    Codice_Aereo varchar(20),
    Data_Partenza char not null,
    
	primary key(Aereo_di_Riferimento, Fila, Posto, Codice_Aereo),
    foreign key(Aereo_di_Riferimento) references Biglietto(Aereo_di_Riferimento),
    foreign key(Fila) references Biglietto(Fila),
    foreign key(Posto) references Biglietto(Posto),
    foreign key(Codice_Aereo) references Aereo(Codice_Aereo));
    
create table HangarEsclusivi(
	CodiceHangar char(3) primary key);
    

