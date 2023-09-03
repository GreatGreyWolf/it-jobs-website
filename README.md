# IT Jobs Website
A MVC it-jobs Website as a side project for learning java spring boot (backend), angular (frontend) and postgres (database).
It's still in the making

## Features
- **Job Listings**: Browse the latest IT job openings.
- **Profile Creation**: Create a profile to showcase skills and experiences.
- **Job Application**: Apply for jobs with a single click.
- **Recruiter Dashboard**: Post new job listings and view applications.

> Note: The platform is still under development. More features will be added in the upcoming releases.

## Quick Start

### Prerequisites
- Docker & Docker Compose installed.
- Ensure ports `4200`, `8080`, and `5432` are available.

### Starting the Project

1. Navigate to the project's root directory.
2. Run the following command:
```bash
docker-compose up --build
```

## Accessing the Platform
- Frontend: Available at localhost:4200.
- Backend API: Accessible at localhost:8080.
- Database: Connect using psql -h localhost -p 5432 -U postgres.

## Development
The project is split into three main components:

1. Backend: Developed using Java Spring Boot. (Directory: /backend)
2. Frontend: Built with Angular. (Directory: /frontend)
3. Database: PostgreSQL database init-scripts. (Directory: /init-scripts)
