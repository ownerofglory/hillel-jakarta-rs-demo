package ua.ithillel.rs.model;

import lombok.Data;

import java.util.List;

@Data
public class TaskList {
    private Integer id;
    private String name;

    private Board board;

    private List<Task> tasks;
}
