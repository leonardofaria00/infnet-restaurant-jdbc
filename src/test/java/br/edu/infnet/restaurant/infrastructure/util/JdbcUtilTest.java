package br.edu.infnet.restaurant.infrastructure.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtilTest {

    @Test
    public void getConnection() {
        try (final Connection connection = JdbcUtil.getConnection();) {
            Assert.assertTrue("Success to connect", true);
            System.out.println("Success to connect");
        } catch (final SQLException sqlException) {
            Assert.fail();
        }
    }
}