package org.manu.enums;

public class Task {
    private String name;
    private LevelPriority priority;

    public Task(String name, LevelPriority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public LevelPriority getPriority() {
        return priority;
    }

}
