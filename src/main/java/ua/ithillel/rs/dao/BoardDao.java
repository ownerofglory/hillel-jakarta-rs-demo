package ua.ithillel.rs.dao;

import org.jvnet.hk2.annotations.Contract;
import ua.ithillel.rs.model.Board;

import java.util.List;

@Contract
public interface BoardDao {
    List<Board> findAll();
    Board findById(Integer id);
    Board save(Board board);
    Board remove(Integer id);
}
