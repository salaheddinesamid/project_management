package com.projecmanagement.service.dto;

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
    String status;
    Date createdAt;
    Integer createdBy;
    List<TaskDTO> tasks;
    Integer team;
    public ProjectDetailsDTO(
            Integer id,
            String projectName,
            String status,
            Date createdAt,
            Integer createdBy,
            List<TaskDTO> tasks,
            Integer team
    ){
        this.id = id;
        this.projectName = projectName;
        this.status = status;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.tasks = tasks;
        this.team = team;
    }
}
