--liquibase formatted sql
--changeset Daniyar:018
INSERT INTO modules (title, course_id)
VALUES
    ('Introduction and Setup', (SELECT id FROM courses WHERE title = 'Introduction to Programming')),
    ('Variables and Data Types', (SELECT id FROM courses WHERE title = 'Introduction to Programming')),
    ('Control Structures', (SELECT id FROM courses WHERE title = 'Introduction to Programming')),
    ('Functions and Modules', (SELECT id FROM courses WHERE title = 'Introduction to Programming')),
    ('Project: Build a Simple Program', (SELECT id FROM courses WHERE title = 'Introduction to Programming')),

    ('Complexity Analysis', (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms')),
    ('Arrays and Linked Lists', (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms')),
    ('Stacks and Queues', (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms')),
    ('Trees and Graphs', (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms')),
    ('Sorting and Searching Algorithms', (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms')),

    ('Database Basics', (SELECT id FROM courses WHERE title = 'Database Management')),
    ('SQL Queries and Joins', (SELECT id FROM courses WHERE title = 'Database Management')),
    ('Database Normalization', (SELECT id FROM courses WHERE title = 'Database Management')),
    ('Transactions and Concurrency', (SELECT id FROM courses WHERE title = 'Database Management')),
    ('Database Security and Indexing', (SELECT id FROM courses WHERE title = 'Database Management')),

    ('HTML and CSS Basics', (SELECT id FROM courses WHERE title = 'Web Development')),
    ('JavaScript Fundamentals', (SELECT id FROM courses WHERE title = 'Web Development')),
    ('Frontend Frameworks', (SELECT id FROM courses WHERE title = 'Web Development')),
    ('Backend Development Basics', (SELECT id FROM courses WHERE title = 'Web Development')),
    ('Full-Stack Project', (SELECT id FROM courses WHERE title = 'Web Development')),

    ('Introduction to ML', (SELECT id FROM courses WHERE title = 'Machine Learning Basics')),
    ('Supervised Learning', (SELECT id FROM courses WHERE title = 'Machine Learning Basics')),
    ('Unsupervised Learning', (SELECT id FROM courses WHERE title = 'Machine Learning Basics')),
    ('Model Evaluation', (SELECT id FROM courses WHERE title = 'Machine Learning Basics')),
    ('Building an ML Project', (SELECT id FROM courses WHERE title = 'Machine Learning Basics'));




