use mysql;
drop database if exists daw1;
create database daw1;
use daw1;

create table EstadoRequerimiento (
  id int auto_increment not null primary key,
  descripcion varchar(255) not null
);

create table Perfil (
  id int auto_increment not null primary key,
  descripcion varchar(255) not null  
);

create table Usuario (
  id int auto_increment not null primary key,
  login varchar(255) not null,
  password varchar(255) not null,
  nombres varchar(255) not null,
  apellidos varchar(255) not null,
  idPerfil int not null references Perfil
);

create table Desarrollador (
  id int auto_increment not null primary key,
  experiencia varchar(255) not null,
  especialidad varchar(255) not null,
  idUsuario int not null references Usuario
);

create table Area (
  id int auto_increment not null primary key,
  descripcion varchar(255) not null
);

create table Requerimiento (
  id int auto_increment not null primary key,
  idArea int not null references Area,
  tipo varchar(255) not null,
  riesgo varchar(255) not null,
  idEstadoRequerimiento int not null references EstadoRequerimiento,
  idDesarrollador int not null references Desarrollador
);

create table EstadoActividad (
  id int auto_increment not null primary key,
  descripcion varchar(255) not null
);

create table Actividad (
  id int auto_increment not null primary key,
  nombre varchar(255) not null,
  descripcion varchar(255) not null,
  idEstadoActividad int not null references EstadoActividad,
  idDesarrollador int not null references Desarrollador,
  evidenciaPruebas blob not null
);

create table ActividadQA (
  id int auto_increment not null primary key,
  descripcion varchar(255) not null,
  idEstadoActividad int not null references EstadoActividad,
  idRequerimiento int not null references Requerimiento  
);