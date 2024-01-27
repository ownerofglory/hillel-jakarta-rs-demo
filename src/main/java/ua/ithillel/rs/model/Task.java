package ua.ithillel.rs.model;

import lombok.Data;

@Data
public class Task {
    private Integer id;
    private String title;
    private String description;

    private TaskList taskList;
}
