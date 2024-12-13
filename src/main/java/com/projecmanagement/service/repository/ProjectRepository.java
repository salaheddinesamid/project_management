package com.projecmanagement.service.repository;

import com.projecmanagement.service.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
