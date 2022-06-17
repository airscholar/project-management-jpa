package com.airscholar.jpabud.dtos;

import com.airscholar.jpabud.entities.TaskDto;
import com.airscholar.jpabud.entities.UserDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ProjectDto implements Serializable {
    private final Long id;
    private final UserDto manager;
    private final List<TaskDto> tasks;
    private final String name;

    public ProjectDto(Long id, UserDto manager, List<TaskDto> tasks, String name) {
        this.id = id;
        this.manager = manager;
        this.tasks = tasks;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public UserDto getManager() {
        return manager;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectDto entity = (ProjectDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.manager, entity.manager) &&
                Objects.equals(this.tasks, entity.tasks) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager, tasks, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "manager = " + manager + ", " +
                "tasks = " + tasks + ", " +
                "name = " + name + ")";
    }
}
