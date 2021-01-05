#!/bin/bash
set -e
set -u

function create_user_and_database() {
	local database=$(echo $1 | tr ',' ' ' | awk '{print $1}')
	local owner=$(echo $1 | tr ',' ' ' | awk '{print $2}')
	echo " Creating user and database '$database'"
	psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
	  CREATE DATABASE $database;
	  GRANT ALL PRIVILEGES ON DATABASE $database TO $owner;
	  \connect $database;
   create table public.task(id bigint, title varchar(200), status integer);
   CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;
EOSQL
}

if [ -n "$POSTGRES_MULTIPLE_DATABASES" ]; then
	echo "Multiple database creation requested: $POSTGRES_MULTIPLE_DATABASES"
	for db in $(echo $POSTGRES_MULTIPLE_DATABASES | tr ':' ' '); do
		create_user_and_database $db
	done
	echo "Multiple databases created"
fi
