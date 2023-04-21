CREATE DATABASE neoribd
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       LC_COLLATE = 'en_US.utf8'
       LC_CTYPE = 'en_US.utf8'
       TEMPLATE = template0
       TABLESPACE = pg_default
       CONNECTION LIMIT = -1; 
	   
CREATE TABLE public.persona (
	id_person int4 NOT NULL DEFAULT nextval('persona_id_seq'::regclass),
	nombre varchar(100) NOT NULL,
	genero varchar(20) NULL,
	edad int4 NULL,
	identificacion varchar(20) NULL,
	direccion varchar(200) NULL,
	telefono varchar(20) NOT NULL,
	CONSTRAINT persona_pkey PRIMARY KEY (id_person)
);
	   
CREATE TABLE public.cliente (
	id serial4 NOT NULL,
	clienteid varchar(100) NOT NULL,
	contrasena varchar(100) NOT NULL,
	estado int4 NOT NULL,
	persona_id int4 NOT NULL,
	CONSTRAINT cliente_clienteid_key UNIQUE (clienteid),
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);


-- public.cliente foreign keys

ALTER TABLE public.cliente ADD CONSTRAINT cliente_persona_id_fkey FOREIGN KEY (persona_id) REFERENCES public.persona(id_person);


CREATE TABLE public.cuenta (
	id serial4 NOT NULL,
	numero_cuenta varchar(50) NOT NULL,
	tipo_cuenta varchar(50) NOT NULL,
	saldo_inicial numeric(10, 2) NOT NULL,
	estado int4 NOT NULL,
	client_id int4 NOT NULL,
	CONSTRAINT cuenta_pkey PRIMARY KEY (id),
	CONSTRAINT unique_account UNIQUE (tipo_cuenta, numero_cuenta)
);


-- public.cuenta foreign keys

ALTER TABLE public.cuenta ADD CONSTRAINT cuenta_fk FOREIGN KEY (client_id) REFERENCES public.cliente(id);


CREATE TABLE public.movimiento (
	id serial4 NOT NULL,
	fecha timestamp NOT NULL,
	tipo_movimiento varchar(50) NOT NULL,
	valor numeric(10, 2) NOT NULL,
	saldo numeric(10, 2) NOT NULL,
	cuenta_id int4 NOT NULL,
	CONSTRAINT movimiento_pkey PRIMARY KEY (id)
);


-- public.movimiento foreign keys

ALTER TABLE public.movimiento ADD CONSTRAINT movimiento_cuenta_id_fkey FOREIGN KEY (cuenta_id) REFERENCES public.cuenta(id);