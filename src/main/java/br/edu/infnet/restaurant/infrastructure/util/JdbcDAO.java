package br.edu.infnet.restaurant.infrastructure.util;

import java.sql.Connection;

public abstract class JdbcDAO {

    protected Connection connection;

    public JdbcDAO() {
        connection = JdbcUtil.getConnection();
    }
}
