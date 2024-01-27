package ua.ithillel.rs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.ithillel.rs.dao.BoardDao;
import ua.ithillel.rs.model.Board;
import ua.ithillel.rs.model.dto.BoardDto;
import ua.ithillel.rs.model.mapper.BoardMapper;
import ua.ithillel.rs.model.mapper.BoardMapperDefault;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class BoardServiceImplTest {
    private BoardService boardService;

    @Mock
    private BoardDao boardDaoMock;
//    @Mock
    protected BoardMapper boardMapperMock = new BoardMapperDefault();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        final Board mockBoard = new Board();
        mockBoard.setId(1000);
        mockBoard.setName("mock-name");

        when(boardDaoMock.findById(anyInt())).thenReturn(mockBoard);

        boardService = new BoardServiceImpl(boardDaoMock, boardMapperMock);
    }

    @Test
    public void getBoardByIdTest_happyFlow() {
        Integer anyId = 100;

        final BoardDto actualBoard = boardService.getBoardById(anyId);

        assertNotNull(actualBoard);
        assertNotNull(actualBoard.getId());
    }
}
