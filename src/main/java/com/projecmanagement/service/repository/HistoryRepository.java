package com.projecmanagement.service.repository;

import com.projecmanagement.service.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Integer> {

    List<History> findAllByProjectId(Integer projectId);
}
