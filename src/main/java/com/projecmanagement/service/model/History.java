package com.projecmanagement.service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer historyId;


    @Column(name = "date")
    Date date;
    @Column(name = "userId")
    Integer userId;

    @Column(name = "action")
    String action;

    @Column(name = "projectId")
    Integer projectId;
}
