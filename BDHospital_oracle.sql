CREATE TABLE USUARIO		-- personal
(
	NUMUSU			integer PRIMARY KEY NOT NULL ,
	NOMUSU			varchar2(50),
	USUUSU			char(5),
	PWDUSU			varchar2(50),
	DNIUSU			char(8),	
	TELFUSU			VARCHAR2(30),
	FNACUSU			date,
	CARGUSU			varchar2(30) ,
	UBIUSU			CHAR(6),
	LEVUSU			CHAR(1)		-- niveles de acceso: 1 ADMIN , 2 OPERARIO
);

CREATE TABLE PACIENTE(
	NUMPAC		integer PRIMARY KEY NOT NULL ,
	NOMPAC		varchar(30) not NULL ,		-- nombre
	APEPAC		varchar(70) not null,		-- apellido
	SEXPAC		char(1) not null,		-- sexo	M o F
	DNIPAC		char(8) not null,		-- dni	
	FNPAC		date,				-- fecha de nacimiento
	DIRPAC		varchar(50),  			-- direccion
	NUMUBI		char(6)				-- ubigeo direccion	
);

CREATE TABLE PROVEEDOR
(
	NUMPROV		integer primary key not null,
	NOMPROV		varchar(80) not null,
	RUCPROV		char(11) not null,
	DIRPROV		varchar(100),
	TIPPROV		varchar(18),		-- laboratorio o distribuidor
	TELFPROV	varchar(50),
	COMPROV		varchar(80),		-- nombre comercial
	ABRPROV		varchar(8),		-- abreviatura del proveedor
	NUMUBI		char(6)
);

CREATE TABLE MEDICINA
(
	NUMMED		integer primary key not null,
	NOMGENMED	varchar(100),		-- nombre genérico del medicamento
	NOMCOMMED	varchar(80),		-- nombre comercial del medicamento
	COSMED		decimal(10,2),		-- costo
	PRECMED		decimal(10,2),		-- precio 
	PREMED		varchar(40),		-- presentación: frasco, tableta, tarro, etc
	CANTMED		integer,			-- cantidad
	OBSMED		varchar(80),		-- observacion		
	FCHMED		date,		-- fecha de vencimiento 
	LOTMED		varchar(8),		-- lote
	NUMPROV		integer			-- proveedor
)
;
CREATE TABLE DOC_VENTA
(
	NCOD_DOC	integer  primary key not null,			-- codigo correlativo de la venta
	NUM_DOC		varchar(14) NOT NULL ,			-- 0002-123456
	TIP_DOC		char(10),				-- si es boleta , factura o ticket
	FCHING_DOC	date,		-- default getdate(),	-- fecha de la venta
	MONT_DOC	decimal(10,2),				-- monto total de la venta
	OBS_DOC		varchar(50),				-- observación
	NUMPAC		long					-- código del paciente
)
;

CREATE TABLE UBIGEO(
	NUMUBI		char(6) not null primary key,
	DPTOUBI		varchar(50),
	PROVUBI		varchar(50),
	DISTUBI		varchar(50)
);

DROP TABLE DETVENTA 


CREATE TABLE DETVENTA
(
	NUMDETVTA   integer not null primary key,
	NUMMED		integer  NOT NULL ,
	NCOD_DOC	integer  NOT NULL ,
	CANTV_MED	integer,					-- cantidad de medicina vendida
	STOTV_DOC	decimal(10,2)				-- subtotal de medicina vendida
	--CONSTRAINT  XPKDETVENTA PRIMARY KEY (NUMMED,NCOD_DOC)
);


-- Creando las secuencias
create sequence idUsuario
start with 1	-- inicio
increment by 1  -- incremento
ORDER;

create sequence idPaciente
start with 1	-- inicio
increment by 1  -- incremento
ORDER;

create sequence idProveedor
start with 1	-- inicio
increment by 1  -- incremento
ORDER;

create sequence idMedicina
start with 1	-- inicio
increment by 1  -- incremento
ORDER;

create sequence idVenta
start with 1	-- inicio
increment by 1  -- incremento
ORDER;




-- Creando los triggers
CREATE or REPLACE TRIGGER idUsuario
BEFORE INSERT ON USUARIO
FOR EACH ROW
BEGIN
SELECT idUsuario.NEXTVAL INTO :NEW.NUMUSU FROM DUAL;
END;

CREATE or REPLACE TRIGGER idPaciente
BEFORE INSERT ON PACIENTE
FOR EACH ROW
BEGIN
SELECT idPaciente.NEXTVAL INTO :NEW.NUMPAC FROM DUAL;
END;

CREATE or REPLACE TRIGGER idProveedor
BEFORE INSERT ON PROVEEDOR
FOR EACH ROW
BEGIN
SELECT idProveedor.NEXTVAL INTO :NEW.NUMPROV FROM DUAL;
END;

CREATE or REPLACE TRIGGER idMedicina
BEFORE INSERT ON MEDICINA
FOR EACH ROW
BEGIN
SELECT idMedicina.NEXTVAL INTO :NEW.NUMMED FROM DUAL;
END;

CREATE or REPLACE TRIGGER idVenta
BEFORE INSERT ON DOC_VENTA
FOR EACH ROW
BEGIN
SELECT idVenta.NEXTVAL INTO :NEW.NCOD_DOC FROM DUAL;
END;

CREATE or REPLACE TRIGGER idDetVenta
BEFORE INSERT ON DETVENTA
FOR EACH ROW
BEGIN
SELECT idDetVenta.NUMDETVTA INTO :NEW.NCOD_DOC FROM DUAL;
END;

	 
	
	
	
	

SELECT * FROM usuario

-- se conoce el usuario
select nomusu, usuusu, pwdusu, levusu from usuario where usuusu='Gian1' and pwdusu='cualquiera' or '1'='1';

-- se conoce el password
select nomusu, usuusu, pwdusu, levusu from usuario where usuusu='cualquiera'or '1'='1' and pwdusu='abc123';

-- no se conoce ninguno
select nomusu, usuusu, pwdusu, levusu from usuario where usuusu='cualquiera'or '1'='1' and pwdusu='sdfsdf'or '1'='1' ;



INSERT INTO BDHOSPITAL.USUARIO (NOMUSU,        USUUSU,           PWDUSU,   LEVUSU)
VALUES('Giancarlo', 'GIAN1', 'abc123', '1');
INSERT INTO BDHOSPITAL.USUARIO (NOMUSU,        USUUSU,           PWDUSU,   LEVUSU)
VALUES('Nicolás', 'NICO1', 'abc123', '2');


INSERT INTO BDHOSPITAL.USUARIO (NOMUSU,        USUUSU,           PWDUSU,   LEVUSU)
VALUES('Lucio', 'LUCI1', 'e99a18c428cb38d5f260853678922e03', '1');



SELECT * FROM usuario;


select nomusu, usuusu, pwdusu, levusu from usuario;


















'or '1'='1'