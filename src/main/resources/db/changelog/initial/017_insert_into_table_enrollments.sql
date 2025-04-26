--liquibase formatted sql
--changeset Daniyar:017
INSERT INTO enrollments (user_id, course_id, enrollment_date) VALUES
((SELECT id FROM users WHERE email = 'patrick@gmail.com'),
(SELECT id FROM courses WHERE title = 'Introduction to Programming'),
NOW()),
((SELECT id FROM users WHERE email = 'patrick@gmail.com'),
(SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'),
NOW()),
((SELECT id FROM users WHERE email = 'jane@gmail.com'),
(SELECT id FROM courses WHERE title = 'Database Management'),
NOW()),
((SELECT id FROM users WHERE email = 'jane@gmail.com'),
(SELECT id FROM courses WHERE title = 'Web Development'),
NOW());