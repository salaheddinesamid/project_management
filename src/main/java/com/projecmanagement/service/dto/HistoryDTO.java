package com.projecmanagement.service.dto;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

@Data
public class HistoryDTO {

    private Date actionDate;
    private UserDTO userDTO;
    private String action;
    private Integer projectId;

    public HistoryDTO(
            Date actionDate,
            UserDTO userDTO,
            String action,
            Integer projectId
    ){
        this.actionDate = actionDate;
        this.userDTO = userDTO;
        this.action = action;
        this.projectId = projectId;
    }
}
