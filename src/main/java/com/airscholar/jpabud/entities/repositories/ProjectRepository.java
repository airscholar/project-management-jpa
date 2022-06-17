package com.airscholar.jpabud.entities.repositories;

import com.airscholar.jpabud.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByName(String name);

    @Query("select p from Project p inner join p.tasks tasks where tasks.endDate is null order by p.name")
    List<Project> findActiveProjects();


}