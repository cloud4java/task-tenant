#FROM docker-devel.depdes.artifactory.prod.cloud.ihf/postgres
FROM postgres

COPY create-multiple-postgresql-databases.sh /docker-entrypoint-initdb.d/
COPY 0-init.sql /docker-entrypoint-initdb.d/

RUN sed -i -e 's/\r$//' /docker-entrypoint-initdb.d/create-multiple-postgresql-databases.sh

RUN chmod +x /docker-entrypoint-initdb.d/create-multiple-postgresql-databases.sh
EXPOSE 5432
#
