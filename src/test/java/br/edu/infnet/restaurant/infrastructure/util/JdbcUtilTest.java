package br.edu.infnet.restaurant.infrastructure.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilTest {

    @Test
    public void getConnection() {
        try (final Connection connection = JdbcUtil.getConnection()) {
            Assertions.assertTrue(true, "Success to connect");
        } catch (final SQLException sqlException) {
            Assertions.fail();
        }
    }
}