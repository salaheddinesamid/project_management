package com.projecmanagement.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectID;

    @Column(nullable = true)
    private String projectName;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @Column(name = "createdBy")
    private Integer createdBy;

    @ElementCollection
    private List<Integer> sprintsIds;

    @ElementCollection
    private List<Integer> tasksIds;

    @Column(name = "team_id")
    Integer teamId;
}