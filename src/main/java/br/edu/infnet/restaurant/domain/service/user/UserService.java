package br.edu.infnet.restaurant.domain.service.user;

import br.edu.infnet.restaurant.domain.data.model.User;
import br.edu.infnet.restaurant.domain.exceptions.DataNotFoundException;
import br.edu.infnet.restaurant.domain.repository.user.UserRepository;
import br.edu.infnet.restaurant.infrastructure.repository.user.UserRepositoryImpl;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepositoryImpl();
    }

    public void create(final User user) {
        userRepository.create(user);
    }

    public User findById(final Integer id) {
        return userRepository.findById(id).orElseThrow(DataNotFoundException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateById(final Integer id, final User user) {
        return userRepository.updateById(id, user);
    }
}
