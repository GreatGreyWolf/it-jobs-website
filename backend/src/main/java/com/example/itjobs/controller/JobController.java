package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.itjobs.service.JobService;
import com.example.itjobs.specification.JobSpecification;
import com.example.itjobs.entity.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs(
            @RequestParam(required = false) String category_name,
            @RequestParam(required = false) String technology_name,
            @RequestParam(required = false) String role_name,
            @RequestParam(required = false) String company_name,
            @RequestParam(required = false) String company_size,
            @RequestParam(required = false) String company_type,
            @RequestParam(required = false) String industry,
            @RequestParam(required = false) String employment_type_name,
            @RequestParam(required = false) String goodie_name,
            @RequestParam(required = false) String level_name,
            @RequestParam(required = false) String language_name,
            @RequestParam(required = false) String profession_name,
            @RequestParam(required = false) String certificate_name,
            @RequestParam(required = false) String method_name,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String todo,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Integer salary_min,
            @RequestParam(required = false) Integer salary_max,
            @RequestParam(required = false) Integer work_percentage_min,
            @RequestParam(required = false) Integer work_percentage_max) {
        Specification<Job> spec = createSpecification(
                category_name, technology_name, role_name, company_name,
                company_size, company_type, industry, employment_type_name,
                goodie_name, level_name, language_name, profession_name,
                certificate_name, method_name, title, description, todo,
                location, salary_min, salary_max, work_percentage_min, work_percentage_max
        // ... Pass more parameters as needed
        );
        return jobService.findAll(spec);
    }

    private Specification<Job> createSpecification(
            String category_name, String technology_name, String role_name,
            String company_name, String company_size, String company_type,
            String industry, String employment_type_name, String goodie_name,
            String level_name, String language_name, String profession_name,
            String certificate_name, String method_name, String title,
            String description, String todo, String location,
            Integer salary_min, Integer salary_max, Integer work_percentage_min, Integer work_percentage_max) {
        List<Specification<Job>> specs = new ArrayList<>();

        if (category_name != null) {
            specs.add(new JobSpecification("category_name", "EQUAL", category_name));
        }
        if (technology_name != null) {
            specs.add(new JobSpecification("technology_name", "EQUAL", technology_name));
        }
        if (role_name != null) {
            specs.add(new JobSpecification("role_name", "EQUAL", role_name));
        }
        if (company_name != null) {
            specs.add(new JobSpecification("company_name", "EQUAL", company_name));
        }
        if (company_size != null) {
            specs.add(new JobSpecification("company_size", "EQUAL", company_size));
        }
        if (company_type != null) {
            specs.add(new JobSpecification("company_type", "EQUAL", company_type));
        }
        if (industry != null) {
            specs.add(new JobSpecification("industry", "EQUAL", industry));
        }
        if (employment_type_name != null) {
            specs.add(new JobSpecification("employment_type_name", "EQUAL", employment_type_name));
        }
        if (goodie_name != null) {
            specs.add(new JobSpecification("goodie_name", "EQUAL", goodie_name));
        }
        if (level_name != null) {
            specs.add(new JobSpecification("level_name", "EQUAL", level_name));
        }
        if (language_name != null) {
            specs.add(new JobSpecification("language_name", "EQUAL", language_name));
        }
        if (profession_name != null) {
            specs.add(new JobSpecification("profession_name", "EQUAL", profession_name));
        }
        if (certificate_name != null) {
            specs.add(new JobSpecification("certificate_name", "EQUAL", certificate_name));
        }
        if (method_name != null) {
            specs.add(new JobSpecification("method_name", "EQUAL", method_name));
        }
        if (title != null) {
            specs.add(new JobSpecification("title", "LIKE", title));
        }
        if (description != null) {
            specs.add(new JobSpecification("description", "LIKE", description));
        }
        if (todo != null) {
            specs.add(new JobSpecification("todo", "LIKE", todo));
        }
        if (location != null) {
            specs.add(new JobSpecification("location", "EQUAL", location));
        }
        if (salary_min != null) {
            specs.add(new JobSpecification("salary_min", "GREATER_THAN_OR_EQUAL", salary_min));
        }
        if (salary_max != null) {
            specs.add(new JobSpecification("salary_max", "LESS_THAN_OR_EQUAL", salary_max));
        }
        if (work_percentage_min != null) {
            specs.add(new JobSpecification("work_percentage_min", "GREATER_THAN_OR_EQUAL", work_percentage_min));
        }
        if (work_percentage_max != null) {
            specs.add(new JobSpecification("work_percentage_max", "LESS_THAN_OR_EQUAL", work_percentage_max));
        }

        Specification<Job> finalSpec = null;
        if (!specs.isEmpty()) {
            finalSpec = specs.get(0);
            for (int i = 1; i < specs.size(); i++) {
                finalSpec = finalSpec.and(specs.get(i));
            }
        }

        return finalSpec;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> job = jobService.getJobById(id);
        if (job.isPresent()) {
            return ResponseEntity.ok(job.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@Valid @RequestBody Job job) {
        Job createdJob = jobService.saveJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @Valid @RequestBody Job updatedJob) {
        if (!jobService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedJob.setId(id);
        Job savedJob = jobService.saveJob(updatedJob);
        return ResponseEntity.ok(savedJob);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        if (!jobService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}