package com.projecmanagement.service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reportID")
    private Integer reportID;

    @Column(name = "project_id")
    Integer projectId;

    @Column(name = "comment")
    private String comment;

}

