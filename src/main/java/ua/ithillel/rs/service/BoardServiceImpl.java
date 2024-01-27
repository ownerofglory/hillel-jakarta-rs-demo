package ua.ithillel.rs.service;

import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import ua.ithillel.rs.dao.BoardDao;
import ua.ithillel.rs.model.Board;
import ua.ithillel.rs.model.dto.BoardDto;
import ua.ithillel.rs.model.mapper.BoardMapper;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BoardServiceImpl implements BoardService {
    @Inject
    private BoardDao boardDao;
    @Inject
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> getAllBoards() {
        // call dao

        // map dao response

        final List<Board> boardsFromDb = boardDao.findAll();

        return boardsFromDb.stream()
                .map(boardMapper::boardToBoardDto)
                .toList();
    }

    @Override
    public BoardDto getBoardById(Integer id) {
        final Board boardFromDb = boardDao.findById(id);
        return boardMapper.boardToBoardDto(boardFromDb);
    }

    @Override
    public BoardDto createBoard(BoardDto boardDto) {
        final Board board = boardMapper.boardDtoToBoard(boardDto);

        final Board savedBoard = boardDao.save(board);


        return boardMapper.boardToBoardDto(savedBoard);
    }

    @Override
    public BoardDto deleteBoard(Integer id) {
        return null;
    }
}
