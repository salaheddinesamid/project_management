package com.projecmanagement.service.dto;

import com.projecmanagement.service.model.TeamDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
public class ProjectDetailsDTO {
    Integer id;
    String projectName;
    Date createdAt;
    Integer createdBy;
    List<TaskDTO> tasks;
    List<TeamDTO> teams;
    public ProjectDetailsDTO(
            Integer id,
            String projectName,
            Date createdAt,
            Integer createdBy,
            List<TaskDTO> tasks,
            List<TeamDTO> teams
    ){
        this.id = id;
        this.projectName = projectName;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.tasks = tasks;
        this.teams = teams;
    }
}
