package com.projecmanagement.service.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class SprintDTO {

    Integer sprintId;
    String sprintName;
    Date startDate;
    Date endDate;
    List<Integer> tasksIds;
    String status;

    public SprintDTO(
            Integer sprintId,
            String sprintName,
            Date startDate,
            Date endDate,
            List<Integer> tasksIds,
            String status
    ){
        this.sprintId = sprintId;
        this.sprintName = sprintName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasksIds = tasksIds;
        this.status = status;
    }
}
