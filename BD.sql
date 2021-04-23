create database reportehoras;
use reportehoras;

create table servicio(
    idservicio varchar(10) primary key not null,
    tiposervicio varchar(20) not null default 'normal'
);

create table tecnico(
    idtecnico varchar(20) primary key not null
);

create table reporteservicio(
    idreporteservicio int auto_increment primary key not null,
    fechainicio varchar(50) not null,
    fechafinal varchar(50) not null,
    numerosemana int not null,
    totalhorasservicio int not null,
    idservicio varchar(10) not null,
    idtecnico varchar(20) not null,
    foreign key (idservicio) references servicio(idservicio),
    foreign key (idtecnico) references tecnico(idtecnico)
);

use reportehoras;
insert into tecnico(idtecnico) values
("123456"),
("654321"),
("789456"),
("145687"),
("201365");

use reportehoras;
insert into servicio(idservicio, tiposervicio) values
("001", "normal"),
("002","emergencia");

truncate table reporteservicio;

use reportehoras;
select * from reporteservicio;

drop database reportehoras;