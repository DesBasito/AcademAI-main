--liquibase formatted sql
--changeset Daniyar:013
INSERT INTO roles (role) VALUES
 ('ROLE_STUDENT'),
 ('ROLE_TEACHER'),
 ('ROLE_ADMIN');