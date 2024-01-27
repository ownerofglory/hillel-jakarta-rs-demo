package ua.ithillel.rs.service;

import org.jvnet.hk2.annotations.Service;
import ua.ithillel.rs.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserInMemoryService implements UserService {
    private static int id = 0;
    private final List<User> users = new ArrayList<>();
    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(Integer id) {
        final User existingUser = users.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst()
                .orElse(null);
        return existingUser;
    }

    @Override
    public User add(User user) {
        user.setId(++id);

        users.add(user);
        return user;
    }

    @Override
    public User delete(Integer id) {
        final User exisiting = users.stream()
                .filter(user -> Objects.equals(user.getId(), id))
                .findFirst().get();

        users.remove(exisiting);

        return exisiting;
    }
}
