package com.projecmanagement.service.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sprint_id", nullable = false)
    private Integer sprintID;

    @Column(name = "sprint_name", length = 100)
    private String sprintName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = true)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = true)
    private Date endDate;

    @ElementCollection
    private List<Integer> tasksIds;

    @Column(name = "status", nullable = false, length = 50)
    private String status;
}
