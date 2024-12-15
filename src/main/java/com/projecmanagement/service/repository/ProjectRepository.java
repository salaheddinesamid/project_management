package com.projecmanagement.service.repository;

import com.projecmanagement.service.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    List<Project> findAllByCreatedBy(Integer userId);
}
