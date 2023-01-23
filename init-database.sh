psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER crm_;

    CREATE DATABASE crm_;
    ALTER USER crm_ WITH encrypted PASSWORD 'crm_';
    GRANT ALL PRIVILEGES ON DATABASE crm_ TO crm_;

    CREATE DATABASE keycloak_db;
    GRANT ALL PRIVILEGES ON DATABASE keycloak_db TO crm_;

    CREATE DATABASE scheduler_;
    GRANT ALL PRIVILEGES ON DATABASE resources TO crm_;

EOSQL