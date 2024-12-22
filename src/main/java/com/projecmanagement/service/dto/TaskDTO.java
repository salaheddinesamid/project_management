package com.projecmanagement.service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Data
@Getter
@Setter
public class TaskDTO {
    Integer taskId;
    String priority;
    Integer assigneeId;
    Integer assignedById;
    String content;
    String status;
    Date createdIn;
    Integer createdById;
    public TaskDTO(
            Integer taskId,
            String priority,
            Integer assigneeId,
            Integer assignedById,
            String content,
            String status,
            Date createdIn,
            Integer createdById
    ){
        this.taskId = taskId;
        this.priority = priority;
        this.assigneeId = assigneeId;
        this.assignedById = assignedById;
        this.content = content;
        this.status = status;
        this.createdIn = createdIn;
        this.createdById = createdById;
    }
}
