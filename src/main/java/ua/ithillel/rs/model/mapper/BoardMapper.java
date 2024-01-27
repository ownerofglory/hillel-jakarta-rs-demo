package ua.ithillel.rs.model.mapper;

import org.jvnet.hk2.annotations.Contract;
import ua.ithillel.rs.model.Board;
import ua.ithillel.rs.model.dto.BoardDto;

@Contract
public interface BoardMapper {
    BoardDto boardToBoardDto(Board board);
    Board boardDtoToBoard(BoardDto boardDto);
}
