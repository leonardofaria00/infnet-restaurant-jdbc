package br.edu.infnet.restaurant.domain.service.user;

import br.edu.infnet.restaurant.domain.data.model.User;
import br.edu.infnet.restaurant.domain.exceptions.DataNotFoundException;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTest {

    private final UserService service;

    public UserServiceTest() {
        this.service = new UserService();
    }

    @Order(1)
    @Test
    public void thenCreateUserWithSuccess() {
        service.create(new User("Leonardo", 28));
        Assertions.assertTrue(true, "Success to insert User");
    }

    @Order(2)
    @Test
    public void thenFindByIdUserWithSuccess() {
        final User user = service.findById(1);
        Assertions.assertNotNull(user);
        Assertions.assertTrue(true, "Success to find User");
    }

    @Order(3)
    @Test
    public void thenFindByIdUserWithError() {
        Assertions.assertThrows(DataNotFoundException.class, () -> {
            service.findById(99);
        });
    }

    @Order(4)
    @Test
    public void thenFindAllUserWithSuccess() {
        final List<User> user = service.findAll();
        Assertions.assertNotNull(user);
        Assertions.assertTrue(true, "Success to find all Users");
    }

    @Order(5)
    @Test
    public void thenUpdateUserWithSuccess() {
        final User user = service.updateById(1, new User("José das Couves", 30));
        Assertions.assertNotNull(user);
        Assertions.assertTrue(true, "Success to change User");
    }

    @Order(6)
    @Test
    public void thenUpdateUserWithError() {
        Assertions.assertThrows(DataNotFoundException.class, () -> {
            service.updateById(99, new User("José das Couves", 30));
        });
    }

    @Order(7)
    @Test
    public void thenDeleteByIdUserWithSuccess() {
        service.create(new User("Maria", 50));
        service.deleteById(1);
        Assertions.assertTrue(true, "Success to delete User");
    }

    @Order(8)
    @Test
    public void thenDeleteByIdUserWithError() {
        Assertions.assertThrows(DataNotFoundException.class, () -> {
            service.deleteById(99);
        });
    }
}