package com.airscholar.jpabud.controller;

import com.airscholar.jpabud.dtos.ProjectDto;
import com.airscholar.jpabud.entities.repositories.ProjectRepository;
import com.airscholar.jpabud.mappers.ProjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import com.airscholar.jpabud.entities.Project;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping("/project/find/{name}")
    public List<ProjectDto> findByName(@PathVariable String name) {
        List<Project> projectList = projectRepository.findByName(name);
        return projectList.stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/project/new")
    public ProjectDto saveProject(@RequestBody @NonNull @Valid ProjectDto projectDto) {
        Project project = projectMapper.projectDtoToProject(projectDto);
        return projectMapper.projectToProjectDto(projectRepository.save(project));
    }

    @PostMapping("/project/update")
    public ProjectDto updateProject(@RequestBody @NonNull @Valid ProjectDto projectDto) {
        if(projectDto.getId() == null) {
            throw new IllegalArgumentException("Project ID is missing. Use /new to create a new project.");
        }

        Project projectEntity = projectRepository.findById(projectDto.getId()).orElseThrow(EntityNotFoundException::new);
        projectMapper.updateProjectFromProjectDto(projectDto, projectEntity);
        return projectMapper.projectToProjectDto(projectRepository.save(projectEntity));
    }
}
