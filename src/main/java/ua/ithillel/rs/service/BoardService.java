package ua.ithillel.rs.service;

import org.jvnet.hk2.annotations.Contract;
import ua.ithillel.rs.dao.BoardDao;
import ua.ithillel.rs.model.dto.BoardDto;
import ua.ithillel.rs.resource.BoardResource;

import java.util.List;

@Contract
public interface BoardService {
    List<BoardDto> getAllBoards();
    BoardDto getBoardById(Integer id);
    BoardDto createBoard(BoardDto board);
    BoardDto deleteBoard(Integer id);
}
