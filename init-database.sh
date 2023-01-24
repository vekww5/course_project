psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER crm;

    CREATE DATABASE crm;
    ALTER USER crm WITH encrypted PASSWORD 'crm';
    GRANT ALL PRIVILEGES ON DATABASE crm TO crm;

    CREATE DATABASE keycloak_db;
    GRANT ALL PRIVILEGES ON DATABASE keycloak_db TO crm;

    CREATE DATABASE scheduler;
    GRANT ALL PRIVILEGES ON DATABASE resources TO crm;

EOSQL