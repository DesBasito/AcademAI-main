--liquibase formatted sql
--changeset Daniyar:019
INSERT INTO lessons (title, module_id) VALUES
-- Introduction and Setup
('Getting Started with Programming',
 (SELECT id FROM modules WHERE title = 'Introduction and Setup'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Installing Required Software',
 (SELECT id FROM modules WHERE title = 'Introduction and Setup'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Understanding Programming Languages',
 (SELECT id FROM modules WHERE title = 'Introduction and Setup'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Writing Your First Program',
 (SELECT id FROM modules WHERE title = 'Introduction and Setup'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Debugging and Running Code',
 (SELECT id FROM modules WHERE title = 'Introduction and Setup'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),

-- Variables and Data Types
('What are Variables?',
 (SELECT id FROM modules WHERE title = 'Variables and Data Types'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Primitive Data Types',
 (SELECT id FROM modules WHERE title = 'Variables and Data Types'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Working with Strings',
 (SELECT id FROM modules WHERE title = 'Variables and Data Types'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Type Conversion',
 (SELECT id FROM modules WHERE title = 'Variables and Data Types'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Best Practices for Variable Naming',
 (SELECT id FROM modules WHERE title = 'Variables and Data Types'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),

-- Control Structures
('Introduction to Conditional Statements',
 (SELECT id FROM modules WHERE title = 'Control Structures'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('If-Else Statements',
 (SELECT id FROM modules WHERE title = 'Control Structures'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Switch Statements',
 (SELECT id FROM modules WHERE title = 'Control Structures'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Loops: While and For',
 (SELECT id FROM modules WHERE title = 'Control Structures'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Nested and Infinite Loops',
 (SELECT id FROM modules WHERE title = 'Control Structures'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),

-- Functions and Modules
('Understanding Functions',
 (SELECT id FROM modules WHERE title = 'Functions and Modules'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Function Parameters and Return Values',
 (SELECT id FROM modules WHERE title = 'Functions and Modules'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Scope and Lifetime of Variables',
 (SELECT id FROM modules WHERE title = 'Functions and Modules'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Importing and Using Modules',
 (SELECT id FROM modules WHERE title = 'Functions and Modules'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Creating and Using Custom Modules',
 (SELECT id FROM modules WHERE title = 'Functions and Modules'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),

-- Project: Build a Simple Program
('Project Overview',
 (SELECT id FROM modules WHERE title = 'Project: Build a Simple Program'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Planning the Application',
 (SELECT id FROM modules WHERE title = 'Project: Build a Simple Program'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Writing the Core Logic',
 (SELECT id FROM modules WHERE title = 'Project: Build a Simple Program'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Testing and Debugging',
 (SELECT id FROM modules WHERE title = 'Project: Build a Simple Program'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),
('Finalizing and Deploying the Project',
 (SELECT id FROM modules WHERE title = 'Project: Build a Simple Program'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Introduction to Programming'))),



-- Complexity Analysis
('Introduction to Complexity Theory',
 (SELECT id FROM modules WHERE title = 'Complexity Analysis'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Big O Notation and Growth Rates',
 (SELECT id FROM modules WHERE title = 'Complexity Analysis'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Time Complexity Examples',
 (SELECT id FROM modules WHERE title = 'Complexity Analysis'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Space Complexity and Trade-offs',
 (SELECT id FROM modules WHERE title = 'Complexity Analysis'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Optimizing Algorithms for Performance',
 (SELECT id FROM modules WHERE title = 'Complexity Analysis'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),

-- Arrays and Linked Lists
('Introduction to Arrays',
 (SELECT id FROM modules WHERE title = 'Arrays and Linked Lists'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Operations on Arrays',
 (SELECT id FROM modules WHERE title = 'Arrays and Linked Lists'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Introduction to Linked Lists',
 (SELECT id FROM modules WHERE title = 'Arrays and Linked Lists'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Singly vs Doubly Linked Lists',
 (SELECT id FROM modules WHERE title = 'Arrays and Linked Lists'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Implementing Linked Lists in Code',
 (SELECT id FROM modules WHERE title = 'Arrays and Linked Lists'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),

-- Stacks and Queues
('Introduction to Stacks',
 (SELECT id FROM modules WHERE title = 'Stacks and Queues'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Stack Operations (Push, Pop, Peek)',
 (SELECT id FROM modules WHERE title = 'Stacks and Queues'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Introduction to Queues',
 (SELECT id FROM modules WHERE title = 'Stacks and Queues'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Queue Operations (Enqueue, Dequeue)',
 (SELECT id FROM modules WHERE title = 'Stacks and Queues'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Applications of Stacks and Queues',
 (SELECT id FROM modules WHERE title = 'Stacks and Queues'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),

-- Trees and Graphs
('Introduction to Trees',
 (SELECT id FROM modules WHERE title = 'Trees and Graphs'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Binary Trees and Traversals',
 (SELECT id FROM modules WHERE title = 'Trees and Graphs'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Introduction to Graphs',
 (SELECT id FROM modules WHERE title = 'Trees and Graphs'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Graph Representations (Adjacency List, Matrix)',
 (SELECT id FROM modules WHERE title = 'Trees and Graphs'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Graph Traversal Algorithms (BFS, DFS)',
 (SELECT id FROM modules WHERE title = 'Trees and Graphs'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),

-- Sorting and Searching Algorithms
('Introduction to Sorting Algorithms',
 (SELECT id FROM modules WHERE title = 'Sorting and Searching Algorithms'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Bubble Sort and Selection Sort',
 (SELECT id FROM modules WHERE title = 'Sorting and Searching Algorithms'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Quick Sort and Merge Sort',
 (SELECT id FROM modules WHERE title = 'Sorting and Searching Algorithms'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Introduction to Searching Algorithms',
 (SELECT id FROM modules WHERE title = 'Sorting and Searching Algorithms'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),
('Binary Search and Hashing',
 (SELECT id FROM modules WHERE title = 'Sorting and Searching Algorithms'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Data Structures and Algorithms'))),

-- Database Basics
('Introduction to Databases',
 (SELECT id FROM modules WHERE title = 'Database Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Types of Databases',
 (SELECT id FROM modules WHERE title = 'Database Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Database Architecture',
 (SELECT id FROM modules WHERE title = 'Database Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Relational vs Non-Relational Databases',
 (SELECT id FROM modules WHERE title = 'Database Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Use Cases of Databases',
 (SELECT id FROM modules WHERE title = 'Database Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),

-- SQL Queries and Joins
('Introduction to SQL',
 (SELECT id FROM modules WHERE title = 'SQL Queries and Joins'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Basic SQL Commands (SELECT, INSERT, UPDATE, DELETE)',
 (SELECT id FROM modules WHERE title = 'SQL Queries and Joins'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Using WHERE and ORDER BY',
 (SELECT id FROM modules WHERE title = 'SQL Queries and Joins'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Understanding SQL Joins (INNER, LEFT, RIGHT, FULL)',
 (SELECT id FROM modules WHERE title = 'SQL Queries and Joins'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Advanced SQL Queries and Subqueries',
 (SELECT id FROM modules WHERE title = 'SQL Queries and Joins'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),

-- Database Normalization
('What is Database Normalization?',
 (SELECT id FROM modules WHERE title = 'Database Normalization'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('First Normal Form (1NF)',
 (SELECT id FROM modules WHERE title = 'Database Normalization'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Second Normal Form (2NF)',
 (SELECT id FROM modules WHERE title = 'Database Normalization'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Third Normal Form (3NF)',
 (SELECT id FROM modules WHERE title = 'Database Normalization'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Denormalization and When to Use It',
 (SELECT id FROM modules WHERE title = 'Database Normalization'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),

-- Transactions and Concurrency
('Introduction to Database Transactions',
 (SELECT id FROM modules WHERE title = 'Transactions and Concurrency'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('ACID Properties in Databases',
 (SELECT id FROM modules WHERE title = 'Transactions and Concurrency'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Implementing Transactions in SQL',
 (SELECT id FROM modules WHERE title = 'Transactions and Concurrency'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Handling Concurrency in Databases',
 (SELECT id FROM modules WHERE title = 'Transactions and Concurrency'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Deadlocks and Locking Mechanisms',
 (SELECT id FROM modules WHERE title = 'Transactions and Concurrency'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),

-- Database Security and Indexing
('Introduction to Database Security',
 (SELECT id FROM modules WHERE title = 'Database Security and Indexing'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('User Authentication and Roles',
 (SELECT id FROM modules WHERE title = 'Database Security and Indexing'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('SQL Injection and How to Prevent It',
 (SELECT id FROM modules WHERE title = 'Database Security and Indexing'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Indexing for Performance Optimization',
 (SELECT id FROM modules WHERE title = 'Database Security and Indexing'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),
('Database Backup and Recovery',
 (SELECT id FROM modules WHERE title = 'Database Security and Indexing'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Database Management'))),

('Introduction to HTML',
 (SELECT id FROM modules WHERE title = 'HTML and CSS Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Structuring a Web Page',
 (SELECT id FROM modules WHERE title = 'HTML and CSS Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('CSS Basics and Selectors',
 (SELECT id FROM modules WHERE title = 'HTML and CSS Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Flexbox and Grid Layout',
 (SELECT id FROM modules WHERE title = 'HTML and CSS Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Responsive Web Design',
 (SELECT id FROM modules WHERE title = 'HTML and CSS Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),

-- JavaScript Fundamentals
('Introduction to JavaScript',
 (SELECT id FROM modules WHERE title = 'JavaScript Fundamentals'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Variables and Data Types',
 (SELECT id FROM modules WHERE title = 'JavaScript Fundamentals'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Functions and Scope',
 (SELECT id FROM modules WHERE title = 'JavaScript Fundamentals'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('DOM Manipulation',
 (SELECT id FROM modules WHERE title = 'JavaScript Fundamentals'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Event Handling and Async JavaScript',
 (SELECT id FROM modules WHERE title = 'JavaScript Fundamentals'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),

-- Frontend Frameworks
('Introduction to Frontend Frameworks',
 (SELECT id FROM modules WHERE title = 'Frontend Frameworks'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Getting Started with React.js',
 (SELECT id FROM modules WHERE title = 'Frontend Frameworks'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('State Management in React',
 (SELECT id FROM modules WHERE title = 'Frontend Frameworks'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Routing in Frontend Apps',
 (SELECT id FROM modules WHERE title = 'Frontend Frameworks'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Component-Based UI Development',
 (SELECT id FROM modules WHERE title = 'Frontend Frameworks'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),

-- Backend Development Basics
('Introduction to Backend Development',
 (SELECT id FROM modules WHERE title = 'Backend Development Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Setting Up a Node.js Server',
 (SELECT id FROM modules WHERE title = 'Backend Development Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('REST APIs and HTTP Methods',
 (SELECT id FROM modules WHERE title = 'Backend Development Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Connecting to a Database',
 (SELECT id FROM modules WHERE title = 'Backend Development Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Authentication and Authorization',
 (SELECT id FROM modules WHERE title = 'Backend Development Basics'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),

-- Full-Stack Project
('Project Overview and Setup',
 (SELECT id FROM modules WHERE title = 'Full-Stack Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Building the Frontend',
 (SELECT id FROM modules WHERE title = 'Full-Stack Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Developing the Backend API',
 (SELECT id FROM modules WHERE title = 'Full-Stack Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Integrating Frontend and Backend',
 (SELECT id FROM modules WHERE title = 'Full-Stack Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),
('Deployment and Final Review',
 (SELECT id FROM modules WHERE title = 'Full-Stack Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Web Development'))),

('What is Machine Learning?',
 (SELECT id FROM modules WHERE title = 'Introduction to ML'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Types of Machine Learning',
 (SELECT id FROM modules WHERE title = 'Introduction to ML'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('ML Applications in Real Life',
 (SELECT id FROM modules WHERE title = 'Introduction to ML'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Basic ML Workflow',
 (SELECT id FROM modules WHERE title = 'Introduction to ML'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Popular ML Tools and Libraries',
 (SELECT id FROM modules WHERE title = 'Introduction to ML'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),

-- Supervised Learning
('Overview of Supervised Learning',
 (SELECT id FROM modules WHERE title = 'Supervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Regression Models',
 (SELECT id FROM modules WHERE title = 'Supervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Classification Models',
 (SELECT id FROM modules WHERE title = 'Supervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Training and Testing Data',
 (SELECT id FROM modules WHERE title = 'Supervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Overfitting and Underfitting',
 (SELECT id FROM modules WHERE title = 'Supervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),

-- Unsupervised Learning
('Introduction to Unsupervised Learning',
 (SELECT id FROM modules WHERE title = 'Unsupervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Clustering Algorithms',
 (SELECT id FROM modules WHERE title = 'Unsupervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Dimensionality Reduction',
 (SELECT id FROM modules WHERE title = 'Unsupervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Principal Component Analysis (PCA)',
 (SELECT id FROM modules WHERE title = 'Unsupervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Anomaly Detection',
 (SELECT id FROM modules WHERE title = 'Unsupervised Learning'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),

-- Model Evaluation
('Metrics for Model Evaluation',
 (SELECT id FROM modules WHERE title = 'Model Evaluation'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Confusion Matrix and Accuracy',
 (SELECT id FROM modules WHERE title = 'Model Evaluation'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Precision, Recall, and F1 Score',
 (SELECT id FROM modules WHERE title = 'Model Evaluation'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Cross-Validation Techniques',
 (SELECT id FROM modules WHERE title = 'Model Evaluation'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Hyperparameter Tuning',
 (SELECT id FROM modules WHERE title = 'Model Evaluation'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),

-- Building an ML Project
('Defining the ML Problem',
 (SELECT id FROM modules WHERE title = 'Building an ML Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Data Collection and Preprocessing',
 (SELECT id FROM modules WHERE title = 'Building an ML Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Model Selection and Training',
 (SELECT id FROM modules WHERE title = 'Building an ML Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Evaluating and Optimizing the Model',
 (SELECT id FROM modules WHERE title = 'Building an ML Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics'))),
('Deploying the ML Model',
 (SELECT id FROM modules WHERE title = 'Building an ML Project'
                           AND course_id = (SELECT id FROM courses WHERE title = 'Machine Learning Basics')));

