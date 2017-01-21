# ベースイメージ
FROM debian

MAINTAINER gaymin

# Install PostgreSQL
RUN apt update && apt install -y postgresql-9.4

# Switch User
USER postgres

# Start PostgeSQL
RUN /etc/init.d/postgresql start &&\
    psql --command "CREATE USER admin WITH SUPERUSER PASSWORD 'adminPwd';" &&\
    createdb -O admin stock_trace

# Config file deploy
ADD pg_hba.conf /etc/postgresql/9.4/main/pg_hba.conf
ADD postgresql.conf /etc/postgresql/9.4/main/postgresql.conf

# Add VOLUMEs to allow backup of config, logs and databases
VOLUME  ["/etc/postgresql", "/var/log/postgresql", "/var/lib/postgresql"]

# Expose the PostgreSQL port
EXPOSE 5432

CMD ["/usr/lib/postgresql/9.4/bin/postgres", "-D", "/var/lib/postgresql/9.4/main", "-c", "config_file=/etc/postgresql/9.4/main/postgresql.conf"]
