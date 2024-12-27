package com.projecmanagement.service.service;

import com.projecmanagement.service.dto.*;
import com.projecmanagement.service.model.Project;
import com.projecmanagement.service.model.Report;
import com.projecmanagement.service.model.Sprint;
import com.projecmanagement.service.repository.ProjectRepository;
import com.projecmanagement.service.repository.SprintRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final SprintRepository sprintRepository;
    private final RestTemplate restTemplate;

    public ProjectService(ProjectRepository projectRepository, SprintRepository sprintRepository, RestTemplate restTemplate) {
        this.projectRepository = projectRepository;
        this.sprintRepository = sprintRepository;
        this.restTemplate = restTemplate;
    }

    // Create new project
    public ResponseEntity<Object> createNewProject(ProjectDetailsDTO projectDetailsDTO) {

        // Creating and saving a new project
        Project project = new Project();
        project.setProjectName(projectDetailsDTO.getProjectName());
        project.setCreatedBy(projectDetailsDTO.getCreatedBy());
        project.setCreatedAt(projectDetailsDTO.getCreatedAt());
        projectRepository.save(project);

        return new ResponseEntity<>("Project is created!", HttpStatus.OK);
    }

    // Get project data:


    // Create a sprint
    public ResponseEntity<Object> createSprint(Integer projectId, SprintDTO sprintDTO){
        Project project = projectRepository.findById(projectId).get();
        List<Integer> sprintsIds = project.getSprintsIds();
        Sprint sprint = new Sprint();
        sprint.setSprintName(sprintDTO.getSprintName());
        sprint.setStatus(sprintDTO.getStatus());
        sprint.setStartDate(sprintDTO.getStartDate());
        sprint.setEndDate(sprintDTO.getEndDate());
        sprint.setTasksIds(sprintDTO.getTasksIds());
        sprintsIds.add(sprint.getSprintID());
        project.setSprintsIds(sprintsIds);
        sprintRepository.save(sprint);
        return new ResponseEntity<>("SPRINT HAS BEEN ADDED",HttpStatus.OK);
    }

    // Assign task to project:


    // Generate report
    @Async
    public ResponseEntity<ReportDTO> generateReport(Integer projectId){
        Project project = projectRepository.findById(projectId).get();
        String teamServiceURL = "http://localhost:9000/api/team/get_team_members/"+projectId;
        String tasksServiceURL = "http://localhost:8081/api/task/get_project_tasks/"+projectId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Report report = new Report();
        Integer teamIds = project.getTeamId();
        List<Integer> tasksIds = project.getTasksIds();
        //HttpEntity<Integer> httpEntity1 = new HttpEntity<>(teamIds,headers);
        HttpEntity<List<Integer>> httpEntity2 = new HttpEntity<>(tasksIds,headers);
        ResponseEntity<List<UserDTO>> teamResponse = restTemplate.exchange(
                teamServiceURL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDTO>>() {}
        );
        ResponseEntity<List<TaskDTO>> tasks_response = restTemplate
                .exchange(
                        tasksServiceURL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<TaskDTO>>() {
                        }
                );
        List<UserDTO> teamMembers = teamResponse.getBody();
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setProjectName(project.getProjectName());
        reportDTO.setMembers(teamMembers);
        reportDTO.setTasks(tasks_response.getBody());
        return new ResponseEntity<>(reportDTO,HttpStatus.OK);
    }

    // Add project history:
    public void AddHistory(HistoryDTO historyDTO){

    }

    public void closeSprint(Integer sprintId){
        Sprint sprint = sprintRepository.findById(sprintId).get();
        List<Integer> sprintTasks = sprint.getTasksIds();
        String taskServiceURL = "http://localhost:8081/api/task/check_sprint_task_completion";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<Integer>> httpEntity = new HttpEntity<>(sprintTasks,headers);
        ResponseEntity<List<TaskDTO>> response = restTemplate
                .exchange(
                        taskServiceURL,
                        HttpMethod.POST,
                        httpEntity,
                        new ParameterizedTypeReference<List<TaskDTO>>() {}
                );
        List<TaskDTO> tasks = response.getBody();
    }
    public ResponseEntity<List<ProjectDetailsDTO>> getAllProjectDetails(Integer creatorId){
        String taskServiceURL = "http://localhost:8081/api/task/get_project_tasks/";
        List<Project> projects = projectRepository.findAllByCreatedBy(creatorId);
        List<ProjectDetailsDTO> projectsDTO = projects
                .stream()
                .map(project -> {
                    ResponseEntity<List<TaskDTO>> tasks = restTemplate
                            .exchange(
                                    taskServiceURL+project.getProjectID(),
                                    HttpMethod.GET,
                                    null,
                                    new ParameterizedTypeReference<List<TaskDTO>>() {
                                    }
                            );
                    return new ProjectDetailsDTO(
                            project.getProjectID(),
                            project.getProjectName(),
                            project.getStatus(),
                            project.getCreatedAt(),
                            project.getCreatedBy(),
                            tasks.getBody(),
                            project.getTeamId()
                    );
                }).collect(Collectors.toList());

        return new ResponseEntity<>(projectsDTO,HttpStatus.OK);
    }

    @Async
    public ResponseEntity<List<TaskDTO>> getProjectTasks(Integer projectId){
        String tasksServiceURL = "http://localhost:8081/api/task/get_project_tasks/"+projectId;
        ResponseEntity<List<TaskDTO>> response = restTemplate
                .exchange(
                        tasksServiceURL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<TaskDTO>>() {
                        }
                );
        return response;
    }
    /*
    public ResponseEntity<List<ProjectDetailsDTO>> getProjectsByCreator(Integer userId) {
        // Fetch all projects created by the user
        List<Project> projects = projectRepository.findAllByCreatedBy(userId);

        // Map projects to ProjectDetailsDTO
        List<ProjectDetailsDTO> projectDetailsDTOS = projects.stream()
                .map(project -> {
                    // Fetch tasks specific to the project
                    List<TaskDTO> taskDTOsForProject = getProjectTasks(project.getProjectID());

                    // Create ProjectDetailsDTO
                    return new ProjectDetailsDTO(
                            project.getProjectID(),
                            project.getProjectName(),
                            project.getStatus(),
                            project.getCreatedAt(),
                            project.getCreatedBy(),
                            taskDTOsForProject, // Attach tasks for this project
                            project.getTeamId()
                    );
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(projectDetailsDTOS, HttpStatus.OK);
    }*/


}
