CREATE USER backend_user WITH PASSWORD 'backend_password';
CREATE DATABASE it_jobs_db;
GRANT ALL PRIVILEGES ON DATABASE it_jobs_db TO backend_user;
