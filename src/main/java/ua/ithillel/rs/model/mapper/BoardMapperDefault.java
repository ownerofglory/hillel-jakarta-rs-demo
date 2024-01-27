package ua.ithillel.rs.model.mapper;

import org.jvnet.hk2.annotations.Service;
import ua.ithillel.rs.model.Board;
import ua.ithillel.rs.model.dto.BoardDto;

@Service
public class BoardMapperDefault implements BoardMapper {
    @Override
    public BoardDto boardToBoardDto(Board board) {
        if (board != null) {
            final BoardDto boardDto = new BoardDto();
            boardDto.setId(board.getId());
            boardDto.setName(board.getName());

            return boardDto;
        }

        return null;
    }

    @Override
    public Board boardDtoToBoard(BoardDto boardDto) {
        if (boardDto != null) {
            final Board board = new Board();
            board.setId(boardDto.getId());
            board.setName(boardDto.getName());

            return board;
        }

        return null;
    }
}
