package data.repositories;

import data.models.User;

import java.util.List;

public interface                                                                                                                                                                                                                                                                                                                                                                                    userBook {
    long count();

    User save(User user);

    User delete(User user);

    User findById(int id);

    User deleteById(int id);

    List<User> findAll();
}
