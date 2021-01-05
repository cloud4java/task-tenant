CREATE TABLE if not exists public.DATASOURCECONFIG (
	id bigint PRIMARY KEY,
	driverclassname VARCHAR(255),
	url VARCHAR(255),
	name VARCHAR(255),
	username VARCHAR(255),
	password VARCHAR(255),
	initialize BOOLEAN
);

INSERT INTO DATASOURCECONFIG VALUES (1, 'org.postgresql.Driver', 'jdbc:postgresql://localhost1:5432/client1?currentSchema=public&ApplicationName=MultiTenant', 'client1', 'postgres', 'postgres', true);
INSERT INTO DATASOURCECONFIG VALUES (2, 'org.postgresql.Driver', 'jdbc:postgresql://localhost1:5432/client2?currentSchema=public&ApplicationName=MultiTenant', 'client2', 'postgres', 'postgres', true);



-- ##### DDL needs to be executed for Schema-Based MultiTenancy ############
-- create schema if not exists test1;
-- create schema if not exists test2;
-- create table public.city(id bigint, name varchar(200));
-- create table test2.city(id bigint, name varchar(200));

-- CREATE SEQUENCE "test1".hibernate_sequence
CREATE SEQUENCE hibernate_sequence
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  NO MAXVALUE
  CACHE 1;

-- CREATE SEQUENCE "test2".hibernate_sequence
-- CREATE SEQUENCE hibernate_sequence
--  START WITH 1
--  INCREMENT BY 1
--  NO MINVALUE
--  NO MAXVALUE
--  CACHE 1;

  -- Chamada dos tenants
  -- curl -X POST http://localhost:8082/ -H 'Content-Type: application/json' -H 'X-TenantID: tenant1' -d '{"title":"Task1 Empresa 1", "status": 1}'
  -- curl -X POST http://localhost:8082/ -H 'Content-Type: application/json' -H 'X-TenantID: tenant2' -d '{"title":"Task1 Empresa 2", "status": 1}'
  -- curl http://localhost:8082/ -H 'X-TenantID: tenant1'
  -- curl http://localhost:8082/ -H 'X-TenantID: tenant2'