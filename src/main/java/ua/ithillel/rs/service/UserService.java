package ua.ithillel.rs.service;

import org.jvnet.hk2.annotations.Contract;
import ua.ithillel.rs.model.User;

import java.util.List;

@Contract
public interface UserService {
    List<User> getAll();
    User getById(Integer id);
    User add(User user);
    User delete(Integer id);
}
