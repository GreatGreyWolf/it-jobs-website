-- Data Insertion

-- MethodCategory
INSERT INTO MethodCategory (category_name) VALUES ('IT');

-- Method
INSERT INTO Method (method_name, category_id) VALUES
('Scrum', 1),
('Pair Programming', 1),
('Code Reviews', 1),
('UnitTests', 1),
('Integration Tests', 1),
('CI/CD Build Server', 1),
('Version Control (Git)', 1),
('Time Tracking', 1),
('Tester', 1);

-- Technology
INSERT INTO Technology (technology_name) VALUES
('Java'),
('JavaScript'),
('Python'),
('C#'),
('C++'),
('Rust'),
('Golang'),
('R'),
('Pearl'),
('Ruby'),
('PHP'),
('Angular'),
('React'),
('Vue'),
('Svelte'),
('Blockchain'),
('Kubernetes');

-- Role
INSERT INTO Role (role_name) VALUES
('DevOps'),
('DevSecOps'),
('Frontend-Developer'),
('Backend-Developer'),
('Fullstack-Developer'),
('ProductOwner'),
('ProductManager');

-- Company
INSERT INTO Company (company_name, company_size, company_type, industry) VALUES
('meta', 'Large', 'Multinational Corporation', 'Technology'),
('amazon', 'Large', 'Multinational Corporation', 'E-commerce'),
('apple', 'Large', 'Multinational Corporation', 'Technology'),
('netflix', 'Medium', 'Multinational Corporation', 'Entertainment'),
('google', 'Large', 'Multinational Corporation', 'Technology');

-- Employment Type
INSERT INTO EmploymentType (employment_type_name) VALUES
('Full-time'),
('Part-time'),
('Apprenticeship');

-- Goodie
INSERT INTO Goodie (goodie_name) VALUES
('Free coffee'),
('5 weeks vacations'),
('Home Office'),
('Life insurance'),
('Team Events'),
('Public Transport Half-Fare'),
('Standing Desk'),
('Company Parking'),
('Career Paths'),
('Free Fruits'),
('Annual Bonus pay');

-- Experience Level
INSERT INTO ExperienceLevel (level_name) VALUES
('Junior'),
('Regular'),
('Senior'),
('Lead');

-- Language
INSERT INTO Language (language_name) VALUES
('English'),
('French'),
('German'),
('Italian');

-- Profession
INSERT INTO Profession (profession_name) VALUES
('School'),
('Bachelor'),
('Master'),
('Self-Taught');

-- Certificate
INSERT INTO Certificate (certificate_name) VALUES
('AWS Certified Solutions Architect'),
('Google Cloud Professional Architect'),
('Microsoft Certified: Azure Solutions Architect Expert'),
('Certified Kubernetes Administrator');

-- Job Requirement
INSERT INTO JobRequirement (experience_level_id, requirement_description) VALUES
(3, 'Candidate must have experience working in large teams and handling high-pressure situations.'),  -- Experience for Java Developer
(1, 'Familiarity with modern front-end tools like Webpack and Babel is a plus.'),                     -- Experience for Angular Developer
(2, 'Experience with Django framework is preferred.'),                                                -- Experience for Python Developer
(1, 'Knowledge of Redux or other state management libraries is beneficial.'),                         -- Experience for React Developer
(3, 'Experience with Kubernetes and Docker is a must.');                                              -- Experience for DevOps Engineer

-- Jobs
INSERT INTO Job (title, description, todo, location, salary, work_percentage, category_id, role_id, company_id, employment_type_id, requirement_id) VALUES
('Java Developer', 'Develop and maintain Java applications', 'Implement new features, Fix bugs', 'New York', 70000, 100, 1, 5, 1, 1, 1),
('Angular Developer', 'Frontend development with Angular', 'Design responsive UIs', 'Los Angeles', 65000, 100, 1, 3, 2, 1, 2),
('Python Developer', 'Backend development with Python', 'Develop microservices', 'San Francisco', 80000, 100, 1, 4, 3, 1, 3),
('React Developer', 'UI development with React', 'Work with the UX team', 'Chicago', 75000, 100, 1, 3, 4, 1, 4),
('DevOps Engineer', 'Manage infrastructure and deployments', 'Implement CI/CD pipelines', 'Boston', 85000, 100, 1, 1, 5, 1, 5);
-- Requirement Language
INSERT INTO RequirementLanguage (requirement_id, language_id) VALUES
(1, 1),  -- English and
(1, 3),  -- German for Java Developer
(2, 2),  -- French for Angular Developer
(3, 1),  -- English for Python Developer
(4, 1),  -- English for React Developer
(5, 1);  -- English for DevOps Engineer

-- Requirement Certificate
INSERT INTO RequirementCertificate (requirement_id, certificate_id) VALUES
(1, 1),  -- AWS Certification for Java Developer
(2, 3),  -- Azure Certification for Angular Developer
(5, 4);  -- Azure Certification for DevOps Engineer

-- RequirementProfession
INSERT INTO RequirementProfession (requirement_id, profession_id) VALUES
(1, 2),  -- Bachelor or
(1, 3),  -- Master for Java Developer
(2, 2),  -- Bachelor for Angular Developer
(3, 2),  -- Bachelor for Python Developer
(3, 3),  -- Bachelor for Python Developer
(4, 1),  -- School for React Developer
(5, 4);  -- Self-taught for DevOps Engineer

-- JobTechnology
INSERT INTO JobTechnology (job_id, technology_id) VALUES
(1, 1),  -- Java for Java Developer
(2, 12), -- Angular for Angular Developer
(3, 3),  -- Python for Python Developer
(4, 13), -- Angular for Angular Developer
(5, 3),  -- Python for DevOps Engineer
(5, 16), -- Blockchain for DevOps Engineer
(5, 17); -- Kubernetes for DevOps Engineer

-- JobMethod
INSERT INTO JobMethod (job_id, method_id) VALUES
(1, 1),  -- Scrum for Java Developer
(1, 3),  -- Code Reviews for Java Developer
(1, 4),  -- UnitTests for Java Developer
(1, 5),  -- Integration Tests for Java Developer
(1, 6),  -- CI/CD for Java Developer
(2, 1),  -- Scrum for Angular Developer
(2, 2),  -- Pair Programming for Angular Developer
(2, 3),  -- Code Reviews for Angular Developer
(3, 1),  -- Scrum for Python Developer
(3, 3),  -- Code Reviews for Python Developer
(3, 4),  -- UnitTests for Python Developer
(4, 1),  -- Scrum for React Developer
(4, 2),  -- Pair Programming for React Developer
(4, 3),  -- Code Reviews for React Developer
(5, 1),  -- Scrum for DevOps Engineer
(5, 6);  -- CI/CD for DevOps Engineer

-- JobGoodie
INSERT INTO JobGoodie (job_id, goodie_id) VALUES
(1, 1),  -- Free coffee for Java Developer
(2, 2),  -- 5 weeks vacations for Angular Developer
(2, 3),  -- Home Office Angular Developer
(3, 2),  -- 5 weeks vacations for React Developer
(4, 2),  -- 5 weeks vacations for Python Developer
(5, 2),  -- 5 weeks vacations for DevOps Engineer
(5, 10); -- 5 Annual Bonus pay for DevOps Engineer
