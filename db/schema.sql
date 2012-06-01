drop database if exists daw1;
create database daw1;
use daw1;

create table estadoCivil (
  id int not null auto_increment primary key,
  descripcion varchar(15)
) default charset=utf8;

create table distrito (
  id int not null auto_increment primary key,
  descripcion varchar(15)
) default charset=utf8;

create table vendedor (
  id int not null auto_increment primary key,
  nombre varchar(20),
  apellido varchar(20),
  password varchar(30),
  edad int,
  fechaNacimiento varchar(20),
  estadoCivil_id int references estadoCivil,
  distrito_id int references distrito
) default charset=utf8;