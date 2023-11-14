
CREATE DATABASE BDColegio
USE BDColegio


CREATE TABLE Administrador
( 
	Codigo_Ad            varchar(20)  NOT NULL ,
	Nombre_Ad            varchar(30)  NULL ,
	Apellido_Ad          varchar(30)  NULL ,
	Email_Ad             varchar(100)  NULL ,
	Celular_Ad           integer  NULL ,
	Dni_Ad               integer  NULL ,
	Direccion_Ad         varchar(100)  NULL ,
	Usu_Ad               varchar(20)  NULL ,
	Pass_Ad              varchar(20)  NULL 
)
go



ALTER TABLE Administrador
	ADD CONSTRAINT XPKAdministrador PRIMARY KEY  CLUSTERED (Codigo_Ad ASC)
go



CREATE TABLE Alumno
( 
	Dni_Al               integer  NOT NULL ,
	Nombre_Al            varchar(30)  NULL ,
	Apellido_Al          varchar(30)  NULL ,
	Sexo_Al              varchar(10)  NULL ,
	Usu_Al               varchar(20)  NULL ,
	Pass_Al              varchar(20)  NULL ,
	Codigo_Au            varchar(20)  NULL ,
	Codigo_Ap            varchar(20)  NULL 
)
go



ALTER TABLE Alumno
	ADD CONSTRAINT XPKAlumno PRIMARY KEY  CLUSTERED (Dni_Al ASC)
go



CREATE TABLE Apoderado
( 
	Codigo_Ap            varchar(20)  NOT NULL ,
	Dni_Ap               integer  NULL ,
	Nombre_Ap            varchar(30)  NULL ,
	Apellido_Ap          varchar(30)  NULL ,
	Direccion_Ap         varchar(100)  NULL ,
	Celular_Ap           integer  NULL ,
	Email_Ap             varchar(100)  NULL 
)
go



ALTER TABLE Apoderado
	ADD CONSTRAINT XPKApoderado PRIMARY KEY  CLUSTERED (Codigo_Ap ASC)
go



CREATE TABLE Aula
( 
	Codigo_Au            varchar(20)  NOT NULL ,
	Seccion_Au           varchar(20)  NULL ,
	CantidadMx_Au        integer  NULL ,
	Codigo_Ni            varchar(20)  NULL ,
	Codigo_Gr            varchar(20)  NULL 
)
go



ALTER TABLE Aula
	ADD CONSTRAINT XPKAula PRIMARY KEY  CLUSTERED (Codigo_Au ASC)
go



CREATE TABLE Cursos
( 
	Codigo_C             varchar(20)  NOT NULL ,
	Nombre_C             varchar(30)  NULL ,
	Codigo_Pr            varchar(20)  NULL 
)
go



ALTER TABLE Cursos
	ADD CONSTRAINT XPKCursos PRIMARY KEY  CLUSTERED (Codigo_C ASC)
go



CREATE TABLE Grado
( 
	Codigo_Gr            varchar(20)  NOT NULL ,
	Nombre_Gr            varchar(20)  NULL 
)
go



ALTER TABLE Grado
	ADD CONSTRAINT XPKGrado PRIMARY KEY  CLUSTERED (Codigo_Gr ASC)
go



CREATE TABLE Matricula
( 
	Codigo_Ma            varchar(20)  NOT NULL ,
	Fecha_Ma             date  NULL ,
	Dni_Al               integer  NULL 
)
go



ALTER TABLE Matricula
	ADD CONSTRAINT XPKMatricula PRIMARY KEY  CLUSTERED (Codigo_Ma ASC)
go



CREATE TABLE Nivel
( 
	Codigo_Ni            varchar(20)  NOT NULL ,
	Nombre_Ni            varchar(20)  NULL 
)
go



ALTER TABLE Nivel
	ADD CONSTRAINT XPKNivel PRIMARY KEY  CLUSTERED (Codigo_Ni ASC)
go



CREATE TABLE Profesor
( 
	Codigo_Pr            varchar(20)  NOT NULL ,
	Nombre_Pr            varchar(30)  NULL ,
	Apellido_Pr          varchar(30)  NULL ,
	Dni_Pr               integer  NULL ,
	Celular_Pr           integer  NULL ,
	Direccion_Pr         varchar(100)  NULL ,
	Sexo_Pr              varchar(10)  NULL ,
	Codigo_Au            varchar(20)  NULL 
)
go



ALTER TABLE Profesor
	ADD CONSTRAINT XPKProfesor PRIMARY KEY  CLUSTERED (Codigo_Pr ASC)
go




ALTER TABLE Alumno
	ADD CONSTRAINT R_1 FOREIGN KEY (Codigo_Au) REFERENCES Aula(Codigo_Au)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Alumno
	ADD CONSTRAINT R_2 FOREIGN KEY (Codigo_Ap) REFERENCES Apoderado(Codigo_Ap)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Aula
	ADD CONSTRAINT R_4 FOREIGN KEY (Codigo_Ni) REFERENCES Nivel(Codigo_Ni)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Aula
	ADD CONSTRAINT R_5 FOREIGN KEY (Codigo_Gr) REFERENCES Grado(Codigo_Gr)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Cursos
	ADD CONSTRAINT R_7 FOREIGN KEY (Codigo_Pr) REFERENCES Profesor(Codigo_Pr)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Matricula
	ADD CONSTRAINT R_3 FOREIGN KEY (Dni_Al) REFERENCES Alumno(Dni_Al)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




ALTER TABLE Profesor
	ADD CONSTRAINT R_6 FOREIGN KEY (Codigo_Au) REFERENCES Aula(Codigo_Au)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
go




--------------###############################################################################-------------
select * from Administrador
Select * from Alumno
select * from Profesor
select * from Matricula
select * from Apoderado
select * from Cursos
select * from Nivel
select * from Grado
select * from Aula

select count(*) from Alumno
-------
select count(*) from Grado
-------
select count(*) from Profesor
-------
select count(*) from Cursos

--------------###############################################################################-------------

----------Administrador-------------

insert into Administrador (Codigo_Ad,Nombre_Ad,Apellido_Ad,Email_Ad,Celular_Ad,Dni_Ad,Direccion_Ad,Usu_Ad,Pass_Ad)values
('AD001','Admin','Velasco','admin@gmail.com',915369368,77389022,'Lima','admin','12345678')

--------------###############################################################################-------------

----------Login---

create procedure sp_verif_alumno
@dni integer
as
begin  
select * from Alumno where Dni_Al=@dni
end


create procedure sp_verif_admin
@cod varchar(20)
as
begin  
select * from Administrador where Codigo_Ad=@cod
end


create procedure sp_iniciar_alumno
@usu varchar (20),
@pass  varchar (20)
as
begin
select Dni_Al,Nombre_Al,Apellido_Al,Sexo_Al,Usu_Al,Pass_Al,Codigo_Au,Codigo_Ap from Alumno
where Usu_Al=@usu and Pass_Al=@pass
end

create procedure sp_inciar_profesor
@cod varchar(20),
@dni integer
as
begin 
select Codigo_Pr,Nombre_Pr,Apellido_Pr,Dni_Pr,Celular_Pr,Direccion_Pr,Sexo_Pr,Codigo_Au from Profesor
where Codigo_Pr=@cod and Dni_Pr=@dni
end


create procedure sp_iniciar_admin
@usu varchar (20),
@pass  varchar (20)
as
begin 
select Codigo_Ad, Nombre_Ad , Apellido_Ad,Email_Ad,Celular_Ad,Dni_Ad,Direccion_Ad,Usu_Ad,Pass_Ad from Administrador
where Usu_Ad=@usu and Pass_Ad =@pass
end


--------------###############################################################################-------------

----------Apoderado-------------

create procedure sp_insert_apoderado
@cod varchar(20),
@dni integer,
@nom varchar(30),
@ape varchar(30),
@dir varchar(100),
@cel integer,
@email varchar(100)
as
begin
insert into Apoderado (Codigo_Ap,Dni_Ap,Nombre_Ap,Apellido_Ap,Direccion_Ap,Celular_Ap,Email_Ap)
values(@cod,@dni,@nom,@ape,@dir,@cel,@email)
end


create procedure sp_mod_apoderado
@cod varchar(20),
@dni integer,
@nom varchar(30),
@ape varchar(30),
@dir varchar(100),
@cel integer,
@email varchar(100)
as
begin
update Apoderado set Codigo_Ap=@cod,Dni_Ap=@dni,Nombre_Ap=@nom,
Apellido_Ap=@ape,Direccion_Ap=@dir,Celular_Ap=@cel,Email_Ap=@email where
@cod=Codigo_Ap 
end


create procedure sp_eli_apoderado
@cod varchar(20)
as
begin 
delete from Apoderado where Codigo_Ap=@cod
end

create procedure sp_listar_apoderado
as
begin
select * from Apoderado
end

insert into Apoderado (Codigo_Ap,Dni_Ap,Nombre_Ap,Apellido_Ap,Direccion_Ap,Celular_Ap,
Email_Ap)values('AP001',77777777,'Juan','Alberto','Chiclayo','965487521','juan@gmail.com')

--------------###############################################################################-------------

----------Alumno-------------

create procedure sp_insert_alumno
@dni integer,
@nom varchar(30),
@ape varchar (30),
@sexo varchar(10),
@usu varchar(20),
@pass varchar (20),
@codaula varchar (20),
@codApo varchar(20)
as
begin 
insert into Alumno (Dni_Al,Nombre_Al,Apellido_Al,Sexo_Al,Usu_Al,Pass_Al,Codigo_Au,Codigo_Ap)
values(@dni,@nom,@ape,@sexo,@usu,@pass,@codaula,@codApo)
end

create procedure sp_mod_alumno
@dni integer,
@nom varchar(30),
@ape varchar (30),
@sexo varchar(10),
@usu varchar(20),
@pass varchar (20),
@codaula varchar (20),
@codApo varchar(20)
as
begin 
update Alumno set Nombre_Al=@nom,Apellido_Al=@ape,Sexo_Al=@sexo,
Usu_Al=@usu,Pass_Al=@pass,Codigo_Au=@codaula,Codigo_Ap=@codApo where @dni=Dni_Al
end

create procedure sp_eli_alumno
@dni integer
as
begin
delete from Alumno where Dni_Al=@dni
end

create procedure sp_listar_alumno
as
begin 
select * from Alumno
end

exec sp_listar_alumno

insert into Alumno (Dni_Al,Nombre_Al,Apellido_Al,Sexo_Al,Usu_Al,Pass_Al,Codigo_Au,Codigo_Ap)values(75487689,'Karen','Armendariz','Femenino','karen','12345','AU001','AP001')

--------------###############################################################################-------------

----------Matricula-------------

create procedure sp_insert_matricula
@cod varchar(20),
@fecha date,
@dni integer
as
begin
insert into Matricula (Codigo_Ma,Fecha_Ma,Dni_Al)
values(@cod,@fecha,@dni)
end


create procedure sp_eliminar_matricula
@cod varchar(20)
as
begin
delete from Matricula where Codigo_Ma=@cod
end


create procedure sp_listar_matricula
as
begin
select * from Matricula
end

--------------###############################################################################-------------

----------Profesor-------------

create procedure sp_insert_profesor
@cod varchar(20),
@nom varchar (30),
@ape varchar(30),
@dni integer,
@cel integer,
@dir varchar(100),
@sexo varchar(10),
@codaula varchar (20)
as
begin 
insert into Profesor (Codigo_Pr,Nombre_Pr,Apellido_Pr,Dni_Pr,Celular_Pr,Direccion_Pr,Sexo_Pr,Codigo_Au)
values (@cod,@nom,@ape,@dni,@cel,@dir,@sexo,@codaula)
end

create procedure sp_mod_profesor
@cod varchar(20),
@nom varchar (30),
@ape varchar(30),
@dni integer,
@cel integer,
@dir varchar(100),
@sexo varchar(10),
@codaula varchar (20)
as
begin
update Profesor set Nombre_Pr=@nom,Apellido_Pr=@ape,Dni_Pr=@dni,Celular_Pr=@cel,Direccion_Pr=@dir,Sexo_Pr=@sexo,Codigo_Au=@codaula
where @cod=Codigo_Pr
end


create procedure sp_eliminar_profesor
@cod varchar(20)
as
begin 
delete from Profesor where Codigo_Pr=@cod
end

create procedure sp_listar_profesor
as
begin
select * from Profesor
end


insert into Profesor (Codigo_Pr,Nombre_Pr,Apellido_Pr,Dni_Pr,Celular_Pr,Direccion_Pr,Sexo_Pr,Codigo_Au )
values('PR001','Cesar','Velasco',70367460,997884147,'Miraflores','M','AU001')

--------------###############################################################################-------------

----------Cursos-------------


create procedure sp_insert_cursos
@cod varchar(20),
@nombre varchar(30),
@codpro varchar(20)
as
begin
insert into Cursos (Codigo_C,Nombre_C,Codigo_Pr)values(@cod,@nombre,@codpro)
end


create procedure sp_mod_cursos
@cod varchar(20),
@nombre varchar(30),
@codpro varchar(20)
as
begin
update Cursos set Nombre_C=@nombre,Codigo_Pr=@codpro where @cod=Codigo_C
end

create procedure sp_eli_cursos
@cod varchar (20)
as
begin
delete from Cursos where Codigo_C=@cod
end

create procedure sp_listar_cursos
as
begin
select * from Cursos
end

--------------###############################################################################-------------

----------Aula-------------
create procedure sp_insert_aula
@cod varchar(20),
@seccion varchar(20),
@cant integer,
@nivel varchar(20),
@grado varchar (20)
as
begin
insert into Aula (Codigo_Au,Seccion_Au,CantidadMx_Au,Codigo_Ni,Codigo_Gr)
values(@cod,@seccion,@cant,@nivel,@grado)
end

create procedure sp_mod_aula
@cod varchar(20),
@seccion varchar(20),
@cant integer,
@nivel varchar(20),
@grado varchar (20)
as
begin
update Aula set Seccion_Au=@seccion,CantidadMx_Au=@cant,Codigo_Ni=@nivel,Codigo_Gr=@grado
where @cod=Codigo_Au
end


create procedure sp_eli_aula
@cod varchar(20)
as
begin
delete from Aula where Codigo_Au=@cod
end

create procedure sp_listar_aula
as
begin
select * from Aula
end

exec sp_listar_aula

insert into Aula (Codigo_Au,Seccion_Au,CantidadMx_Au,Codigo_Ni,Codigo_Gr)
values('AU001','A',25,'NI001','GR001')
exec sp_insert_aula 'AU002','A',24,'NI001','GR001'


--------------###############################################################################-------------

----------Admin-------------

create procedure sp_insert_admin
@cod varchar(20),
@nom varchar(20),
@ape varchar(30),
@email varchar(100),
@celu integer,
@dni integer,
@direc varchar(100),
@usu varchar(20),
@pass varchar (20)
as
begin
insert into Administrador(Codigo_Ad,Nombre_Ad,Apellido_Ad,Email_Ad,Celular_Ad,Dni_Ad,Direccion_Ad,Usu_Ad,Pass_Ad)
values(@cod,@nom,@ape,@email,@celu,@dni,@direc,@usu,@pass)
end

create procedure sp_mod_admin
@cod varchar(20),
@nom varchar(20),
@ape varchar(30),
@email varchar(100),
@celu integer,
@dni integer,
@direc varchar(100),
@usu varchar(20),
@pass varchar (20)
as
begin
update Administrador set Nombre_Ad=@nom,Apellido_Ad=@ape,Email_Ad=@email,Celular_Ad=@celu,Dni_Ad=@dni,Direccion_Ad=@direc,Usu_Ad=@usu,Pass_Ad=@pass 
where @cod=Codigo_Ad
end


create procedure sp_eli_admin
@cod varchar(20)
as
begin
delete from Administrador where Codigo_Ad=@cod
end

create procedure sp_listar_admin
as
begin
select * from Administrador
end

select Codigo_Ad,Nombre_Ad,Apellido_Ad,Email_Ad,Celular_Ad,Dni_Ad,Direccion_Ad,Usu_Ad,Pass_Ad from Administrador where Codigo_Ad= 'AD001'

select*from Administrador
--------------###############################################################################-------------

----------Nivel-------------

insert into Nivel (Codigo_Ni,Nombre_Ni)values('NI001','Primaria')
insert into Nivel (Codigo_Ni,Nombre_Ni)values('NI002','Secundaria')

--------------###############################################################################-------------

----------Grado-------------

insert into Grado (Codigo_Gr,Nombre_Gr)values('GR001','1º Grado')
insert into Grado (Codigo_Gr,Nombre_Gr)values('GR002','2º Grado')
insert into Grado (Codigo_Gr,Nombre_Gr)values('GR003','3º Grado')
insert into Grado (Codigo_Gr,Nombre_Gr)values('GR004','4º Grado')
insert into Grado (Codigo_Gr,Nombre_Gr)values('GR005','5º Grado')



--------------###############################################################################-------------

----------Inner Join Alumno-------------

select al.Dni_Al,a.Codigo_Au,a.Seccion_Au,n.Nombre_Ni,g.Nombre_Gr,p.Nombre_Pr,c.Nombre_C from Alumno al inner join Aula a on al.Codigo_Au=a.Codigo_Au inner join Profesor p on p.Codigo_Au=a.Codigo_Au inner join Nivel n on n.Codigo_Ni=a.Codigo_Ni inner join Grado g on a.Codigo_Gr=g.Codigo_Gr inner join Cursos c on p.Codigo_Pr = c.Codigo_Pr where al.Dni_Al = 75487689

--------------###############################################################################-------------

----------Inner Join Docente-------------
select * from Profesor
select p.Codigo_Pr,Nombre_Pr,p.Dni_Pr,c.Nombre_C,a.Codigo_Au,a.Seccion_Au,n.Nombre_Ni,g.Nombre_Gr from Profesor p inner join Cursos c on p.Codigo_Pr= c.Codigo_Pr inner join Aula a on p.Codigo_Au=a.Codigo_Au inner join Nivel n on a.Codigo_Ni = n.Codigo_Ni inner join Grado g on g.Codigo_Gr=a.Codigo_Gr where p.Codigo_Pr = 'D002'





--------------###############################################################################-------------

---INGRESO AL INTRANET DEL COLEGIO

--ADMINISTRADOR
--USUARIO = Usu_Ad
--CONTRASEÑA = Pass_Ad


--------------###############################################################################-------------

--ALUMNO
--USUARIO = nombre o Usu_Ad
--CONTRASEÑA = Pass_Al

--------------###############################################################################-------------

--PROFESOR 
--USUARIO = CODIGO
--CONTRASEÑA = DNI

