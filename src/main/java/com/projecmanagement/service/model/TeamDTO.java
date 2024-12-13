package com.projecmanagement.service.model;

import lombok.Data;

@Data
public class TeamDTO {

    Integer teamId;
    String teamName;

    public TeamDTO(
            Integer teamId,
            String teamName
    ){

    }
}
