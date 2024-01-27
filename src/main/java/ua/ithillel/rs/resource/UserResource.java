package ua.ithillel.rs.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ua.ithillel.rs.model.User;
import ua.ithillel.rs.service.UserService;

import java.util.List;

@Path("/users")
public class UserResource {
    @Inject
    private UserService userService;

    @GET
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @GET
    @Path("/{id}")
    public User getUserById(@PathParam("id") Integer id) {
        return userService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addUser(User user) {
        return userService.add(user);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User deleteUser(@PathParam("id") Integer id) {
        return userService.delete(id);
    }
}
