package br.edu.infnet.restaurant.domain.repository.user;

import br.edu.infnet.restaurant.domain.data.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void create(User user);

    Optional<User> findById(Integer id);

    List<User> findAll();

    User updateById(Integer id, User user);

    void deleteById(Integer id);
}
