package com.example.itjobs.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.itjobs.service.JobService;
import com.example.itjobs.specification.JobSpecification;
import com.example.itjobs.entity.Job;
import com.example.itjobs.helper.ParamConfig;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs(HttpServletRequest request) {
        Specification<Job> spec = createSpecification(request);
        return jobService.findAll(spec);
    }

    private Specification<Job> createSpecification(HttpServletRequest request) {
        List<Specification<Job>> specs = new ArrayList<>();

        for (Map.Entry<String, ParamConfig> entry : PARAM_CONFIG_MAP.entrySet()) {
            String paramName = entry.getKey();
            ParamConfig config = entry.getValue();
            String paramValue = request.getParameter(paramName);
            if (paramValue != null) {
                specs.add(new JobSpecification(config.getDbColumn(), config.getOperation(), paramValue));
            }
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

    private static final Map<String, ParamConfig> PARAM_CONFIG_MAP;

static {
    Map<String, ParamConfig> tempMap = new HashMap<>();

    tempMap.put("categoryName", new ParamConfig("EQUAL", "methodCategory.categoryName"));
    tempMap.put("companyName", new ParamConfig("EQUAL", "company.companyName"));
    tempMap.put("companySize", new ParamConfig("EQUAL", "company.companySize"));
    tempMap.put("companyType", new ParamConfig("EQUAL", "company.companyType"));
    tempMap.put("employmentTypeName", new ParamConfig("EQUAL", "employmentType.employmentTypeName"));
    tempMap.put("industry", new ParamConfig("EQUAL", "company.industry"));
    tempMap.put("levelName", new ParamConfig("EQUAL", "experienceLevel.levelName"));
    tempMap.put("roleName", new ParamConfig("EQUAL", "role.roleName"));

    tempMap.put("languageName", new ParamConfig("EQUAL", "jobRequirement.languages.languageName"));
    tempMap.put("professionName", new ParamConfig("EQUAL", "jobRequirement.professions.professionName"));
    tempMap.put("certificateName", new ParamConfig("EQUAL", "jobRequirement.certificates.certificateName"));

    tempMap.put("technologyName", new ParamConfig("EQUAL", "technologies.technologyName"));
    tempMap.put("methodName", new ParamConfig("EQUAL", "methods.methodName"));
    tempMap.put("goodieName", new ParamConfig("EQUAL", "goodies.goodieName"));

    tempMap.put("title", new ParamConfig("LIKE", "title"));
    tempMap.put("description", new ParamConfig("LIKE", "description"));
    tempMap.put("todo", new ParamConfig("LIKE", "todo"));
    tempMap.put("location", new ParamConfig("EQUAL", "location"));
    tempMap.put("salaryMin", new ParamConfig("LESS_THAN_OR_EQUAL", "salaryMax"));
    tempMap.put("salaryMax", new ParamConfig("GREATER_THAN_OR_EQUAL", "salaryMin"));
    tempMap.put("workPercentageMin", new ParamConfig("LESS_THAN_OR_EQUAL", "workPercentageMax"));
    tempMap.put("workPercentageMax", new ParamConfig("GREATER_THAN_OR_EQUAL", "workPercentageMin"));

    PARAM_CONFIG_MAP = Collections.unmodifiableMap(tempMap);
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
        try {
            Job createdJob = jobService.saveJob(job);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @Valid @RequestBody Job updatedJob) {
        if (!jobService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedJob.setId(id);
        try {
            Job savedJob = jobService.saveJob(updatedJob);
            return ResponseEntity.ok(savedJob);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
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