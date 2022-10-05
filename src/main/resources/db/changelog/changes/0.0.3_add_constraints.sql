ALTER TABLE t_users
    DROP CONSTRAINT IF EXISTS user_company_id_fk;
ALTER TABLE t_users
    ADD CONSTRAINT user_company_id_fk
        FOREIGN KEY (company_id) REFERENCES t_companies(id)
            ON DELETE SET NULL;

ALTER TABLE t_users
    DROP CONSTRAINT IF EXISTS user_speciality_id_fk;
ALTER TABLE t_users
    ADD CONSTRAINT user_speciality_id_fk
        FOREIGN KEY (speciality_id) REFERENCES t_specialties(id)
            ON DELETE SET NULL;

ALTER TABLE t_users_roles
    DROP CONSTRAINT IF EXISTS user_roles_id_fk;
ALTER TABLE t_users_roles
    ADD CONSTRAINT user_roles_id_fk
        FOREIGN KEY (user_id) REFERENCES t_users;

ALTER TABLE t_users_roles
    DROP CONSTRAINT IF EXISTS roles_user_id_fk;
ALTER TABLE t_users_roles
    ADD CONSTRAINT roles_user_id_fk
        FOREIGN KEY (roles_id) REFERENCES t_roles;