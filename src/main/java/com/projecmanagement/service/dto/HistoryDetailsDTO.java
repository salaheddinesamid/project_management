package com.projecmanagement.service.dto;

import com.projecmanagement.service.model.Project;
import lombok.Data;

import java.util.Date;

@Data
public class HistoryDetailsDTO {
    Integer historyId;
    Date actionDate;
    String action;
    Project project;
}
