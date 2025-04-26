--liquibase formatted sql
--changeset Daniyar:015
INSERT INTO categories (name, parent_id) VALUES
 ('Programming', NULL),
 ('Web Development', NULL),
 ('Mobile Development', NULL),
 ('Game Development', NULL),
 ('Data Science', NULL),
 ('Machine Learning', NULL),
 ('Artificial Intelligence', NULL),
 ('Cybersecurity', NULL),
 ('Cloud Computing', NULL),
 ('DevOps', NULL),
 ('Networking', NULL),
 ('Database Management', NULL),
 ('Software Engineering', NULL),
 ('Blockchain', NULL),
 ('UI/UX Design', NULL),
 ('IT Project Management', NULL),
 ('Big Data', NULL),
 ('Internet of Things (IoT)', NULL),
 ('Embedded Systems', NULL),
 ('Automation and Scripting', NULL),
 ('Testing and QA', NULL),
 ('Operating Systems', NULL),
 ('Computer Science Fundamentals', NULL),
 ('IT Support and Helpdesk', NULL),
 ('Virtualization', NULL),
 ('Cloud Security', NULL),
 ('Digital Marketing', NULL),
 ('AR/VR Development', NULL),
 ('Robotics', NULL),
 ('Cryptography', NULL);


INSERT INTO categories (name, parent_id) VALUES
('Python', (SELECT id FROM categories WHERE name = 'Programming')),
('Java', (SELECT id FROM categories WHERE name = 'Programming')),
('C++', (SELECT id FROM categories WHERE name = 'Programming')),
('JavaScript', (SELECT id FROM categories WHERE name = 'Programming')),
('Functional Programming', (SELECT id FROM categories WHERE name = 'Programming'));

INSERT INTO categories (name, parent_id) VALUES
('Frontend Development', (SELECT id FROM categories WHERE name = 'Web Development')),
('Backend Development', (SELECT id FROM categories WHERE name = 'Web Development')),
('Full-Stack Development', (SELECT id FROM categories WHERE name = 'Web Development')),
('Web Security', (SELECT id FROM categories WHERE name = 'Web Development')),
('CMS Development', (SELECT id FROM categories WHERE name = 'Web Development'));

INSERT INTO categories (name, parent_id) VALUES
('Android Development', (SELECT id FROM categories WHERE name = 'Mobile Development')),
('iOS Development', (SELECT id FROM categories WHERE name = 'Mobile Development')),
('Cross-Platform Development', (SELECT id FROM categories WHERE name = 'Mobile Development')),
('Mobile UI/UX', (SELECT id FROM categories WHERE name = 'Mobile Development'));

INSERT INTO categories (name, parent_id) VALUES
('Unity Development', (SELECT id FROM categories WHERE name = 'Game Development')),
('Unreal Engine Development', (SELECT id FROM categories WHERE name = 'Game Development')),
('2D Game Development', (SELECT id FROM categories WHERE name = 'Game Development')),
('3D Game Development', (SELECT id FROM categories WHERE name = 'Game Development'));

INSERT INTO categories (name, parent_id) VALUES
('Data Analysis', (SELECT id FROM categories WHERE name = 'Data Science')),
('Data Engineering', (SELECT id FROM categories WHERE name = 'Data Science')),
('Big Data Processing', (SELECT id FROM categories WHERE name = 'Data Science'));

INSERT INTO categories (name, parent_id) VALUES
('Supervised Learning', (SELECT id FROM categories WHERE name = 'Machine Learning')),
('Unsupervised Learning', (SELECT id FROM categories WHERE name = 'Machine Learning')),
('Deep Learning', (SELECT id FROM categories WHERE name = 'Machine Learning'));

INSERT INTO categories (name, parent_id) VALUES
('Neural Networks', (SELECT id FROM categories WHERE name = 'Artificial Intelligence')),
('Natural Language Processing', (SELECT id FROM categories WHERE name = 'Artificial Intelligence')),
('Computer Vision', (SELECT id FROM categories WHERE name = 'Artificial Intelligence'));

INSERT INTO categories (name, parent_id) VALUES
('Penetration Testing', (SELECT id FROM categories WHERE name = 'Cybersecurity')),
('Ethical Hacking', (SELECT id FROM categories WHERE name = 'Cybersecurity')),
('Security Operations', (SELECT id FROM categories WHERE name = 'Cybersecurity'));

INSERT INTO categories (name, parent_id) VALUES
('AWS', (SELECT id FROM categories WHERE name = 'Cloud Computing')),
('Azure', (SELECT id FROM categories WHERE name = 'Cloud Computing')),
('Google Cloud', (SELECT id FROM categories WHERE name = 'Cloud Computing'));

INSERT INTO categories (name, parent_id) VALUES
('CI/CD', (SELECT id FROM categories WHERE name = 'DevOps')),
('Infrastructure as Code', (SELECT id FROM categories WHERE name = 'DevOps')),
('Monitoring and Logging', (SELECT id FROM categories WHERE name = 'DevOps'));

INSERT INTO categories (name, parent_id) VALUES
('Network Security', (SELECT id FROM categories WHERE name = 'Networking')),
('Wireless Networking', (SELECT id FROM categories WHERE name = 'Networking')),
('Cloud Networking', (SELECT id FROM categories WHERE name = 'Networking'));

INSERT INTO categories (name, parent_id) VALUES
('SQL Databases', (SELECT id FROM categories WHERE name = 'Database Management')),
('NoSQL Databases', (SELECT id FROM categories WHERE name = 'Database Management')),
('Database Optimization', (SELECT id FROM categories WHERE name = 'Database Management'));

INSERT INTO categories (name, parent_id) VALUES
('Agile Development', (SELECT id FROM categories WHERE name = 'Software Engineering')),
('Software Architecture', (SELECT id FROM categories WHERE name = 'Software Engineering')),
('Microservices', (SELECT id FROM categories WHERE name = 'Software Engineering'));

INSERT INTO categories (name, parent_id) VALUES
('Smart Contracts', (SELECT id FROM categories WHERE name = 'Blockchain')),
('Cryptocurrency Development', (SELECT id FROM categories WHERE name = 'Blockchain')),
('Decentralized Applications', (SELECT id FROM categories WHERE name = 'Blockchain'));

INSERT INTO categories (name, parent_id) VALUES
('Scrum', (SELECT id FROM categories WHERE name = 'IT Project Management')),
('Kanban', (SELECT id FROM categories WHERE name = 'IT Project Management')),
('Risk Management', (SELECT id FROM categories WHERE name = 'IT Project Management'));

INSERT INTO categories (name, parent_id) VALUES
('Hadoop', (SELECT id FROM categories WHERE name = 'Big Data')),
('Apache Spark', (SELECT id FROM categories WHERE name = 'Big Data')),
('Data Lakes', (SELECT id FROM categories WHERE name = 'Big Data'));

INSERT INTO categories (name, parent_id) VALUES
('IoT Security', (SELECT id FROM categories WHERE name = 'Internet of Things (IoT)')),
('Embedded IoT', (SELECT id FROM categories WHERE name = 'Internet of Things (IoT)')),
('IoT Protocols', (SELECT id FROM categories WHERE name = 'Internet of Things (IoT)'));

INSERT INTO categories (name, parent_id) VALUES
('Shell Scripting', (SELECT id FROM categories WHERE name = 'Automation and Scripting')),
('Python Automation', (SELECT id FROM categories WHERE name = 'Automation and Scripting')),
('Robotic Process Automation (RPA)', (SELECT id FROM categories WHERE name = 'Automation and Scripting'));

INSERT INTO categories (name, parent_id) VALUES
('Manual Testing', (SELECT id FROM categories WHERE name = 'Testing and QA')),
('Automated Testing', (SELECT id FROM categories WHERE name = 'Testing and QA')),
('Performance Testing', (SELECT id FROM categories WHERE name = 'Testing and QA'));

INSERT INTO categories (name, parent_id) VALUES
('Public Key Cryptography', (SELECT id FROM categories WHERE name = 'Cryptography')),
('Symmetric Encryption', (SELECT id FROM categories WHERE name = 'Cryptography')),
('Blockchain Cryptography', (SELECT id FROM categories WHERE name = 'Cryptography'));
