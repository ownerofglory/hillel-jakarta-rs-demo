package ua.ithillel.rs.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ua.ithillel.rs.model.dto.BoardDto;
import ua.ithillel.rs.service.BoardService;

import java.util.List;

@Path("/boards")
public class BoardResource {
    @Inject
    private BoardService boardService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        // call service
        final List<BoardDto> allBoards = boardService.getAllBoards();

        return Response.ok(allBoards).build(); // 200
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        final BoardDto boardById = boardService.getBoardById(id);

        return Response.ok(boardById).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBoard(BoardDto boardDto) {
        final BoardDto created = boardService.createBoard(boardDto);

        return Response.ok(created).build();
    }
}
