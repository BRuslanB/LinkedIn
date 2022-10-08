INSERT INTO t_companies (name)
    VALUES ('АО Валенки'),
           ('АО Береке Банк'),
           ('ТОО Все дома'),
           ('ТОО Рога и Копыта'),
           ('ИП Добряк'),
           ('Фонд Милосердие');

INSERT INTO t_specialties (name)
VALUES ('Кассир'),
       ('Механик'),
       ('Банкир'),
       ('Водитель'),
       ('Учитель'),
       ('Управляющий');

INSERT INTO t_roles (name, role)
    VALUES ('ADMINISTRATOR', 'ROLE_ADMIN'),
           ('HR MANAGER', 'ROLE_HR_MANAGER'),
           ('CANDIDATE', 'ROLE_USER');

INSERT INTO t_users (email, full_name, password, avatar_url, company_id, speciality_id)
    VALUES ('admin@gmail.com', 'Иванов', '$2a$10$7VB4nxLa.hxOjL5/NafMLuFPndVGkRZ7FbNfOk44ktBS8h8aqxTsS', NULL, NULL, NULL),
           ('manager@gmail.com', 'Петров', '$2a$10$7VB4nxLa.hxOjL5/NafMLuFPndVGkRZ7FbNfOk44ktBS8h8aqxTsS', NULL, NULL, NULL),
           ('abramov@gmail.com', 'Абрамов', '$2a$10$7VB4nxLa.hxOjL5/NafMLuFPndVGkRZ7FbNfOk44ktBS8h8aqxTsS', NULL, 1, 3),
           ('omarov@gmail.com', 'Омаров', '$2a$10$7VB4nxLa.hxOjL5/NafMLuFPndVGkRZ7FbNfOk44ktBS8h8aqxTsS', NULL, 2, 1),
           ('pupkin@gmail.com', 'Пупкин', '$2a$10$7VB4nxLa.hxOjL5/NafMLuFPndVGkRZ7FbNfOk44ktBS8h8aqxTsS', NULL, 3, 4),
           ('gubin@gmail.com', 'Губин', '$2a$10$7VB4nxLa.hxOjL5/NafMLuFPndVGkRZ7FbNfOk44ktBS8h8aqxTsS', NULL, 4, 2),
           ('nikitin@gmail.com', 'Никитин', '$2a$10$7VB4nxLa.hxOjL5/NafMLuFPndVGkRZ7FbNfOk44ktBS8h8aqxTsS', NULL, 5, 5),
           ('achmetov@gmail.com', 'Ахметов', '$2a$10$7VB4nxLa.hxOjL5/NafMLuFPndVGkRZ7FbNfOk44ktBS8h8aqxTsS', NULL, 6, 6);

INSERT INTO t_users_roles (user_id, roles_id)
    VALUES (1, 1),
           (2, 2),
           (3, 3),
           (4, 3),
           (5, 3),
           (6, 3),
           (7, 3),
           (8, 3);