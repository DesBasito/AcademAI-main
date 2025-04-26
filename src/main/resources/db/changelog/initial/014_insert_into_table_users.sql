--liquibase formatted sql
--changeset Daniyar:014
--passwords: qwerty
INSERT INTO users (name, surname, email, password, avatar, role_id, enabled) VALUES
('patrick', 'bob',  'patrick@gmail.com', 'A11JLNBD/rxy9SY5NeITYA==', 'user.jpg',
 (SELECT id FROM roles WHERE role = 'ROLE_STUDENT'), TRUE),
('jane', 'smith',  'jane@gmail.com', 'A11JLNBD/rxy9SY5NeITYA==', 'user.jpg',
 (SELECT id FROM roles WHERE role = 'ROLE_STUDENT'), TRUE),
('alice', 'johnson', 'alice@gmail.com', 'A11JLNBD/rxy9SY5NeITYA==', NULL,
 (SELECT id FROM roles WHERE role = 'ROLE_TEACHER'), TRUE),
('bob', 'brown', 'brown@gmail.com', 'A11JLNBD/rxy9SY5NeITYA==', NULL,
 (SELECT id FROM roles WHERE role = 'ROLE_TEACHER'), TRUE),
('admin', 'admin', 'admin@gmail.com', 'A11JLNBD/rxy9SY5NeITYA==', 'user.jpg',
 (SELECT id FROM roles WHERE role = 'ROLE_ADMIN'), TRUE);
