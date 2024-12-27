package com.projecmanagement.service.controller;

import com.projecmanagement.service.dto.HistoryDTO;
import com.projecmanagement.service.dto.ProjectDetailsDTO;
import com.projecmanagement.service.dto.ReportDTO;
import com.projecmanagement.service.dto.TaskDTO;
import com.projecmanagement.service.model.History;
import com.projecmanagement.service.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/get_project_by_creator/{userId}")
    public ResponseEntity<List<ProjectDetailsDTO>> getProject(@PathVariable Integer userId){
        return projectService.getAllProjectDetails(userId);
    }

    @GetMapping("/generate_report/{projectId}")
    public ResponseEntity<ReportDTO> generateReport(@PathVariable Integer projectId){
        return projectService.generateReport(projectId);
    }

    @GetMapping("/get_project_tasks/{projectId}")
    public ResponseEntity<List<TaskDTO>> projectDetailsDTOResponseEntity(@PathVariable Integer projectId){
        return projectService.getProjectTasks(projectId);
    }

    @PostMapping("/new_history")
    public ResponseEntity<Object> saveNewProjectHistory(@RequestBody HistoryDTO historyDTO){
        return projectService.AddHistory(historyDTO);
    }

    @GetMapping("/get_project_history/{projectId}")
    public ResponseEntity<List<History>> getProjectHistory(@PathVariable Integer projectId){
        return projectService.projectHistory(projectId);
    }
}
