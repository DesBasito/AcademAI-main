--liquibase formatted sql
--changeset Daniyar:016
INSERT INTO courses (title, image, description, teacher_id, category_id) VALUES
('Introduction to Programming', 'intro_programming.jpg', 'Basic programming concepts with hands-on exercises.',
 (SELECT id FROM users WHERE email = 'brown@gmail.com'),
 (SELECT id FROM categories WHERE name = 'Programming')),

('Data Structures and Algorithms', 'data_structures.jpg', 'Learn how to use and implement data structures efficiently.',
 (SELECT id FROM users WHERE email = 'alice@gmail.com'),
 (SELECT id FROM categories WHERE name = 'Programming')),

('Database Management', 'database_management.jpg', 'Understanding relational databases and SQL.',
 (SELECT id FROM users WHERE email = 'alice@gmail.com'),
 (SELECT id FROM categories WHERE name = 'Database Management')),

('Web Development', 'web_dev.jpg', 'Build modern web applications using HTML, CSS, and JavaScript.',
 (SELECT id FROM users WHERE email = 'brown@gmail.com'),
 (SELECT id FROM categories WHERE name = 'Web Development')),

('Machine Learning Basics', 'ml_basics.jpg', 'An introductory course on machine learning and AI techniques.',
 (SELECT id FROM users WHERE email = 'admin@gmail.com'),
 (SELECT id FROM categories WHERE name = 'Machine Learning'));
