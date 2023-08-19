-- Connect to the database
\c it_jobs_db;

-- Create 21 Tables
-- Method Category
CREATE TABLE MethodCategory (
  id SERIAL PRIMARY KEY,
  category_name VARCHAR(255) NOT NULL
);

-- Technology
CREATE TABLE Technology (
  id SERIAL PRIMARY KEY,
  technology_name VARCHAR(255) NOT NULL
);

-- Role
CREATE TABLE Role (
  id SERIAL PRIMARY KEY,
  role_name VARCHAR(255) NOT NULL
);

-- Company
CREATE TABLE Company (
  id SERIAL PRIMARY KEY,
  company_name VARCHAR(255) NOT NULL,
  company_size VARCHAR(50),
  company_type VARCHAR(255),
  industry VARCHAR(255)
);

-- Employment Type
CREATE TABLE EmploymentType (
  id SERIAL PRIMARY KEY,
  employment_type_name VARCHAR(255) NOT NULL
);

-- Goodie
CREATE TABLE Goodie (
  id SERIAL PRIMARY KEY,
  goodie_name VARCHAR(255) NOT NULL
);

-- Experience Level
CREATE TABLE ExperienceLevel (
  id SERIAL PRIMARY KEY,
  level_name VARCHAR(255) NOT NULL
);

-- Language
CREATE TABLE Language (
  id SERIAL PRIMARY KEY,
  language_name VARCHAR(255) NOT NULL
);

-- Profession
CREATE TABLE Profession (
  id SERIAL PRIMARY KEY,
  profession_name VARCHAR(255) NOT NULL
);

-- Certificate
CREATE TABLE Certificate (
  id SERIAL PRIMARY KEY,
  certificate_name VARCHAR(255) NOT NULL
);

-- Method
CREATE TABLE Method (
  id SERIAL PRIMARY KEY,
  method_name VARCHAR(255) NOT NULL,
  category_id INTEGER,
  FOREIGN KEY (category_id) REFERENCES MethodCategory(id)
);

-- JobRequirement
CREATE TABLE JobRequirement (
  id SERIAL PRIMARY KEY,
  experience_level_id INTEGER REFERENCES ExperienceLevel(id),
  requirement_description TEXT
);

-- RequirementLanguage
CREATE TABLE RequirementLanguage (
  requirement_id INTEGER REFERENCES JobRequirement(id),
  language_id INTEGER REFERENCES Language(id),
  PRIMARY KEY (requirement_id, language_id)
);

-- RequirementCertificate
CREATE TABLE RequirementCertificate (
  requirement_id INTEGER REFERENCES JobRequirement(id),
  certificate_id INTEGER REFERENCES Certificate(id),
  PRIMARY KEY (requirement_id, certificate_id)
);

-- RequirementProfession
CREATE TABLE RequirementProfession (
  requirement_id INTEGER REFERENCES JobRequirement(id),
  profession_id INTEGER REFERENCES Profession(id),
  PRIMARY KEY (requirement_id, profession_id)
);

-- Job
CREATE TABLE Job (
  id SERIAL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  description TEXT,
  todo TEXT,
  location VARCHAR(255),
  salary NUMERIC(10,2),
  work_percentage INTEGER,
  category_id INTEGER,
  role_id INTEGER,
  company_id INTEGER,
  employment_type_id INTEGER,
  requirement_id INTEGER,
  FOREIGN KEY (category_id) REFERENCES MethodCategory(id),
  FOREIGN KEY (role_id) REFERENCES Role(id),
  FOREIGN KEY (company_id) REFERENCES Company(id),
  FOREIGN KEY (employment_type_id) REFERENCES EmploymentType(id),
  FOREIGN KEY (requirement_id) REFERENCES JobRequirement(id)
);

-- JobGoodie
CREATE TABLE JobGoodie (
  job_id INTEGER,
  goodie_id INTEGER,
  PRIMARY KEY (job_id, goodie_id),
  FOREIGN KEY (job_id) REFERENCES Job(id),
  FOREIGN KEY (goodie_id) REFERENCES Goodie(id)
);

-- Job Technology
CREATE TABLE JobTechnology (
  job_id INTEGER,
  technology_id INTEGER,
  PRIMARY KEY (job_id, technology_id),
  FOREIGN KEY (job_id) REFERENCES Job(id),
  FOREIGN KEY (technology_id) REFERENCES Technology(id)
);

-- Job Method
CREATE TABLE JobMethod (
  job_id INTEGER,
  method_id INTEGER,
  PRIMARY KEY (job_id, method_id),
  FOREIGN KEY (job_id) REFERENCES Job(id),
  FOREIGN KEY (method_id) REFERENCES Method(id)
);

-- Filter Table
CREATE TABLE Filter (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    keyword_search TEXT,
    location TEXT,  -- Comma-separated values for multiple locations
    salary_min NUMERIC(10,2),
    salary_max NUMERIC(10,2),
    work_percentage_min INTEGER,
    work_percentage_max INTEGER,
    goodie TEXT,  -- Comma-separated values for multiple goodies
    company_id INTEGER REFERENCES Company(id),
    employment_type_id INTEGER REFERENCES EmploymentType(id),
    role_id INTEGER REFERENCES Role(id),
    technology_id INTEGER REFERENCES Technology(id),
    method_id INTEGER REFERENCES Method(id),
    experience_level_id INTEGER REFERENCES ExperienceLevel(id),
    language_id INTEGER REFERENCES Language(id),
    profession_id INTEGER REFERENCES Profession(id),
    certificate_id INTEGER REFERENCES Certificate(id)
);


-- Subscription Table
CREATE TABLE Subscription (
    id SERIAL PRIMARY KEY,
    filter_id INTEGER REFERENCES Filter(id),
    email VARCHAR(255) NOT NULL,
    last_notified_on TIMESTAMP
);
