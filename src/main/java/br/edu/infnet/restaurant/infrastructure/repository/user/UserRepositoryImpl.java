package br.edu.infnet.restaurant.infrastructure.repository.user;

import br.edu.infnet.restaurant.domain.data.model.User;
import br.edu.infnet.restaurant.domain.exceptions.DataNotFoundException;
import br.edu.infnet.restaurant.domain.repository.user.UserRepository;
import br.edu.infnet.restaurant.infrastructure.util.JdbcDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl extends JdbcDAO implements UserRepository {

    @Override
    public void create(final User user) {
        try {
            final String sql = "insert into user(name, age) values (?, ?)";
            final PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.executeUpdate();
        } catch (final SQLException sqlException) {
            sqlException.getStackTrace();
            throw new RuntimeException(String.format("Error to insert user with message: %s", sqlException.getMessage()));
        }

    }

    @Override
    public Optional<User> findById(final Integer id) {
        try {
            final String sql = "select * from user where id = ?";
            final PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setInt(1, id);

            final ResultSet resultSet = preparedStatement.executeQuery();

            Optional<User> user = Optional.empty();
            while (resultSet.next()) {
                final String resultName = resultSet.getString("name");
                final Integer resultAge = resultSet.getInt("age");
                user = Optional.of(new User(resultName, resultAge));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        try {
            final String sql = "select * from user";
            final PreparedStatement preparedStatement = getPrepareStatement(sql);
            final ResultSet resultSet = preparedStatement.executeQuery();

            List<User> user = new ArrayList<>();
            while (resultSet.next()) {
                final String resultName = resultSet.getString("name");
                final Integer resultAge = resultSet.getInt("age");
                user.add(new User(resultName, resultAge));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User updateById(final Integer id, final User user) {
        try {
            final String sql = "update user set name = ?, age = ? where id = ?";
            final PreparedStatement prepareStatement = getPrepareStatement(sql);
            prepareStatement.setString(1, user.getName());
            prepareStatement.setInt(2, user.getAge());
            prepareStatement.setInt(3, id);

            final int resultCode = prepareStatement.executeUpdate();

            validateUpdateResult(id, resultCode);

            return findById(id).get();
        } catch (final SQLException sqlException) {
            throw new RuntimeException(sqlException.getMessage());
        }
    }

    private static void validateUpdateResult(final Integer id, final int resultCode) {
        if (resultCode == 0) throw new DataNotFoundException(String.format("Error to update User with id: %s", id));
    }

    private PreparedStatement getPrepareStatement(final String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
