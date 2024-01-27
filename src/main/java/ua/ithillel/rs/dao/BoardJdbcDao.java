package ua.ithillel.rs.dao;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.jvnet.hk2.annotations.Service;
import ua.ithillel.rs.model.Board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardJdbcDao implements BoardDao {
    @Inject
    private Connection connection;

    @Override
    public List<Board> findAll() {
        // SELECT * FROM t_board
        List<Board> boards = null;
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM t_board");

            final ResultSet resultSet = preparedStatement.executeQuery();

            boards = new ArrayList<>();

            while (resultSet.next()) {
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("name");

                final Board board = new Board();
                board.setId(id);
                board.setName(name);
                boards.add(board);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return boards;
    }

    @Override
    public Board findById(Integer id) {
        Board board = null;
        try {
            final PreparedStatement preparedStatement
                    = connection.prepareStatement("SELECT * FROM t_board WHERE id = ?");

            preparedStatement.setInt(1, id);



            final ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            final String name = resultSet.getString("name");

            board = new Board();
            board.setId(id);
            board.setName(name);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return board;
    }

    @Override
    public Board save(Board board) {
        try {
            final PreparedStatement preparedStatement
                    = connection.prepareStatement("INSERT INTO t_board " +
                    "  (name) " +
                    "VALUES(?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, board.getName());

            final int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                final ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    final int generatedId = generatedKeys.getInt(1);
                    board.setId(generatedId);

                }
            }

            return board;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Board remove(Integer id) {
        return null;
    }
}
