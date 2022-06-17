package com.airscholar.jpabud.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class TaskDto implements Serializable {
    private final Long id;
    private final String name;
    private final Instant endDate;
    private final Instant startDate;

    public TaskDto(Long id, String name, Instant endDate, Instant startDate) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDto entity = (TaskDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.endDate, entity.endDate) &&
                Objects.equals(this.startDate, entity.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, endDate, startDate);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "endDate = " + endDate + ", " +
                "startDate = " + startDate + ")";
    }
}
