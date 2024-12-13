package com.projecmanagement.service.controller;

import com.projecmanagement.service.dto.ProjectDetailsDTO;
import com.projecmanagement.service.service.ProjectService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Controller for creating new project:
    @PostMapping("/new_project")
    public  ResponseEntity<Object> newProject(@RequestBody ProjectDetailsDTO projectDetailsDTO){
        return projectService.createNewProject(projectDetailsDTO);
    }

    @GetMapping("/generate_report/{projectId}")
    public ResponseEntity<Object> generateReport(@PathVariable Integer projectId){
        return projectService.generateReport(projectId);
    }
}
