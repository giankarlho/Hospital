create database BDHospital;
use BDHospital;

-- drop table paciente	ok
-- select * from paciente
CREATE TABLE PACIENTE(
	NUMPAC		int PRIMARY KEY NOT NULL ,
	NOMPAC		varchar(30) not NULL ,		-- nombre
	APEPAC		varchar(70) not null,		-- apellido
	SEXPAC		char(1) not null,		-- sexo	M o F
	FNPAC		date,				-- fecha de nacimiento
	DNIPAC		char(8) not null,		-- dni	
	TELFPAC		varchar(30)  ,
	EMAILPAC	varchar(30) NULL ,			-- email
	NUMUBI		char(6),				-- ubigeo direccion
	DIRPAC		varchar(50),  			-- direccion
	GSPAC		varchar(5),
	HCPAC		char(11),				-- historia clínica del sistema: fecha de ingreso 'ddmmaaaa' + correlativo (3)			
	ESTPAC		char(1)					-- Activo o no					
)
;
CREATE TABLE USUARIO		-- personal
(
	NUMUSU			int identity(1,1) primary key not null,
	NOMUSU			varchar(50),
	USUUSU			char(5),
	PWDUSU			varchar(50),
	DNIUSU			char(8),	
	TELFUSU			VARCHAR(30),
	FNACUSU			date,
	CARGUSU			varchar(30) ,
	UBIUSU			CHAR(6),
	LEVUSU			CHAR(1)		-- niveles de acceso: 1 ADMIN , 2 OPERARIO
)
;
--drop table PROVEEDOR 
--select * from PROVEEDOR
CREATE TABLE PROVEEDOR
(
	NUMPROV		int identity(1,1) primary key not null,
	NOMPROV		varchar(80) not null,
	RUCPROV		char(11) not null,
	DIRPROV		varchar(100),
	TIPPROV		varchar(18),		-- laboratorio o distribuidor
	TELFPROV	varchar(50),
	COMPROV		varchar(80),		-- nombre comercial
	ABRPROV		varchar(8),		-- abreviatura del proveedor
	NUMUBI		char(6),
	ESTPROV		char(1) default 'A'
)
;

-- SELECT * from MEDICINA 
CREATE TABLE MEDICINA
(
	NUMMED		bigint primary key NOT NULL ,
	NOMGENMED	varchar(100),		-- nombre genérico del medicamento
	NOMCOMMED	varchar(80),		-- nombre comercial del medicamento
	COSMED		decimal(10,2),		-- costo
	PRECMED		decimal(10,2),		-- precio 
	PREMED		varchar(40),		-- presentación: frasco, tableta, tarro, etc
	CANTMED		int,			-- cantidad
	OBSMED		varchar(80),		-- observacion		
	LUGMED		varchar(4),			-- ubicación del medicamento dentro de farmacia
	FCHMED		date,				-- fecha de vencimiento 
	LOTMED		varchar(8),
	ESTMED		char(1) default 'A',			-- estado: Activo,Baja
	NUMPROV		int					-- proveedor
)
go
-- drop table DOC_VENTA
CREATE TABLE DOC_VENTA
(
	NCOD_DOC	bigint identity(1,1) primary key not null,			-- codigo correlativo de la venta
	NUM_DOC		varchar(14) NOT NULL ,			-- 0002-123456
	TIP_DOC		char(1),				-- si es boleta , factura o ticket
	FCHING_DOC	datetime default getdate(),	-- fecha de la venta
	MONT_DOC	decimal(10,2),				-- monto total de la venta
	OBS_DOC		varchar(50),				-- observación
	NUMPAC		bigint					-- código del paciente
)
;
CREATE TABLE DETVENTA
(
	NUMMED		bigint  NOT NULL ,
	NCOD_DOC	bigint  NOT NULL ,
	CANTV_MED	int,					-- cantidad de medicina vendida
	STOTV_DOC	decimal(10,2),				-- subtotal de medicina vendida
	CONSTRAINT  XPKDETVENTA PRIMARY KEY (NUMMED  ASC,NCOD_DOC  ASC)
);

CREATE TABLE UBIGEO(
	NUMUBI		char(6) not null primary key,
	DPTOUBI		varchar(50),
	PROVUBI		varchar(50),
	DISTUBI		varchar(50)
)

CREATE TABLE SERIE
(
	--NUMSER		int primary key,
	TIPSER		int primary key,		--	1 si es boleta, 2 si es factura, 3 si es ticket, 4 si es orden interna , 5: Donacion,6: Laboratorio
	FACSER		varchar(14)				--	nro de comprobante: FAR2018-000001 , LAB2018-000005	 
	--CODSER		bigint				-- NCOD_DOC tanto para DOC_VENTA como para SERVLAB
)
go
insert into serie values (3,'FAR2021-000001')
insert into serie values (6,'LAB2021-000001')


-- Procedures, Views, Tiggers

-- INSERT Venta y detVenta
create procedure spInsertVta
@NUM_DOC char(14),@TIP_DOC char(1),@FCHING_DOC date,@MONT_DOC decimal(6,2),@OBS_DOC varchar(50),@NUMPAC bigint
as
insert into DOC_VENTA values
(@NUM_DOC,@TIP_DOC,@FCHING_DOC,@MONT_DOC,@OBS_DOC,@NUMPAC)

create procedure spInsertDetVta
@NUMMED bigint,@NCOD_DOC bigint,@CANTV_MED int,@STOTV_DOC decimal(6,2)
as
insert into DETVENTA values  
@NUMMED bigint,@NCOD_DOC = select max(NCOD_DOC) + 1 from doc_venta  bigint,@CANTV_MED int,@STOTV_DOC decimal(6,2)


select (max(NCOD_DOC) +1) as maxi from doc_venta

--Autocomplete Paciente y Medicina

create PROCEDURE spAutoCompletMed
@generico varchar(60)
as
select CONCAT(NOMGENMED, ' ',NOMCOMMED, ' ', PREMED, ' ','Disp.',CANTMED,' s/',PRECMED,' ',ABRPROV) as producto 
from medicina m inner join proveedor p on m.NUMPROV =p.NUMPROV 
where cantmed>0 and estmed='A' and NOMGENMED like @generico ORDER BY FCHMED

-- EXECUTE spAutoCompletMed '%am%' 

create PROCEDURE spDatosAutoCompletMed
@producto varchar(500)
as
select NUMMED,NOMGENMED, NOMCOMMED,PREMED, PRECMED,CANTMED,NOMPROV 
from medicina m inner join proveedor p on m.NUMPROV = p.NUMPROV 
WHERE CONCAT(NOMGENMED, ' ',NOMCOMMED, ' ', PREMED, ' ','Disp.',CANTMED,' s/',PRECMED,' ',ABRPROV)=@producto

-- EXECUTE spDatosAutoCompletMed 'BETAHISTINA SERC 8 MG. CJA. X 60 COMP Disp.1321 s/0.50'

-- select * from doc_venta
-- NCOD_DOC	NUM_DOC		TIP_DOC		FCHING_DOC	MONT_DOC	OBS_DOC	NUMPAC

-- select * from detventa
-- NUMMED	NCOD_DOC	CANTV_MED	STOTV_DOC

-- select * from paciente
-- NUMPAC	NOMPAC	APEPAC	SEXPAC	FNPAC	DNIPAC	TELFPAC	EMAILPAC	NUMUBI	DIRPAC	GSPAC	HCPAC	ESTPA

-- select * from medicina
-- NUMMED	NOMGENMED	NOMCOMMED	COSMED	PRECMED	PREMED	CANTMED	OBSMED	LUGMED	FCHMED	LOTMED	ESTMED	NUMPROV

-- select * from PROVEEDOR p 
-- NUMPROV	NOMPROV		RUCPROV		DIRPROV TIPPROV	TELFPROV	COMPROV	ABRPROV	NUMUBI	ESTPROV|
