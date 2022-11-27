package br.edu.infnet.restaurant.domain.data.model;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void testToString() {
        System.out.println(new User("Leonardo", 28));
    }
}