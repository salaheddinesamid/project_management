package com.projecmanagement.service.repository;

import com.projecmanagement.service.model.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint,Integer> {
}
