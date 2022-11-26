package br.edu.infnet.restaurant.domain.service.user;

import br.edu.infnet.restaurant.domain.data.model.User;
import br.edu.infnet.restaurant.domain.exceptions.DataNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class UserServiceTest {

    private final UserService service;

    public UserServiceTest() {
        this.service = new UserService();
    }

    @Test
    public void thenCreateUserWithSuccess() {
        service.create(new User("Leonardo", 28));
        Assert.assertTrue("Success to insert User", true);
    }

    @Test
    public void thenFindByIdUserWithSuccess() {
        final User user = service.findById(1);
        Assert.assertNotNull(user);
        Assert.assertTrue("Success to find User", true);
    }

    @Test
    public void thenFindByIdUserWithError() {
        Assert.assertThrows(DataNotFoundException.class, () -> {
            service.findById(999);
        });
    }

    @Test
    public void thenFindAllUserWithSuccess() {
        final List<User> user = service.findAll();
        Assert.assertNotNull(user);
        Assert.assertTrue("Success to find all Users", true);
    }

    @Test
    public void thenUpdateUserWithSuccess() {
        final User user = service.updateById(1, new User("José das Couves", 30));
        Assert.assertNotNull(user);
        Assert.assertTrue("Success to change User", true);
    }

    @Test
    public void thenUpdateUserWithError() {
        Assert.assertThrows(DataNotFoundException.class, () -> {
            service.updateById(99, new User("José das Couves", 30));
        });
    }
}