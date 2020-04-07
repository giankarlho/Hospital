create database BDHospital
go
use BDHospital
go

-- DROP TABLE UBIGEO
CREATE TABLE UBIGEO(
	CODUBI		char(6) primary key,
	DPTUBI		varchar(60),
	PROUBI		varchar(60),
	DISUBI		varchar(60)
)
go

-- drop table paciente	ok
CREATE TABLE PACIENTE(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
	NUMPAC		bigint primary key,	-- numero correlativo 
	NOMPAC		varchar(30) not NULL ,			-- nombre
	APEPAC		varchar(70) not null,			-- apellido
	SEXPAC		char(1),				-- sexo	M o F
	FNPAC		date,					-- fecha de nacimiento
	DNIPAC		char(8),				-- dni	
	TELFPAC		varchar(30)  ,				-- telefono 
	EMAILPAC	varchar(30) NULL ,			-- email	
	NUMUBI		char(6),				-- ubigeo direccion	
	DIRPAC		varchar(50),  				-- direccion
	GSPAC		varchar(5),
	HCPAC		char(11),				-- historia clínica del sistema: fecha de ingreso 'ddmmaaaa' + correlativo (3)
	ESTPAC		varchar(20),				-- estado civil
)