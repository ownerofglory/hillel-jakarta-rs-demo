package ua.ithillel.rs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Board {
    private Integer id;
    private String name;

    private List<TaskList> taskLists;
}
