package com.projecmanagement.service.dto;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

@Data
public class HistoryDTO {

    private Date actionDate;
    private Integer userId;
    private String action;
    private Integer projectId;

}
