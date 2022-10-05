DROP TABLE IF EXISTS t_companies CASCADE;
CREATE TABLE t_companies(
    id SERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL
);

DROP TABLE IF EXISTS t_specialties CASCADE;
CREATE TABLE t_specialties(
    id SERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL
);

DROP TABLE IF EXISTS t_roles CASCADE;
CREATE TABLE t_roles(
    id SERIAL PRIMARY KEY NOT NULL,
    name TEXT NOT NULL,
    role TEXT NOT NULL
);

DROP TABLE IF EXISTS t_users CASCADE;
CREATE TABLE t_users(
    id SERIAL PRIMARY KEY NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    full_name TEXT NOT NULL,
    avatar_url TEXT,
    company_id INT,
    speciality_id INT
);

DROP TABLE IF EXISTS t_users_roles;
CREATE TABLE t_users_roles(
    user_id INT NOT NULL,
    roles_id INT NOT NULL
);