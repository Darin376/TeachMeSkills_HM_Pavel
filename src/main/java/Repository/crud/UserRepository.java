package Repository.crud;

import Repository.users.User;
import pack.PostgresDriverManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository {

    private static final Logger logger = Logger.getLogger(UserRepository.class.getName());
    private final PostgresDriverManager driverManager = PostgresDriverManager.getInstance();
    private final Connection connection;

    public UserRepository() throws SQLException {
        this.connection = driverManager.getConnection();
    }

    // Create
    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO usersworker ( first_name, last_name, age) VALUES (?, ?, ? );";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getFirst_name());
            statement.setString(2, user.getLast_name());
            statement.setInt(3, user.getAge());
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                logger.log(Level.INFO, "Пользователь успешно создан: ID = {0}, Login = {1}", new Object[]{user.getId(), user.getFirst_name()});
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Ошибка при создании пользователя", e);
            throw e; // Пробрасываем исключение дальше
        }
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM usersworker WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age")
                );
            }
        }
        return null;
    }

    // Read (все пользователи)
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM usersworker";


        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"),
                        resultSet.getInt("id")
                ));
//                users.add(new User(resultSet.getInt("id")));
            }
        }
        return users;
    }

    // Update
    public void updateUserLogin(int id, String newLogin) throws SQLException {
        String sql = "UPDATE usersworker SET first_name = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newLogin);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }

    // Delete
    public void deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM usersworker WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted == 0) {
                logger.warning("User with id " + id + " not found");
                throw new SQLException("User with id " + id + " not found");
            } else {
                logger.info("User with id " + id + " deleted successfully");
            }
        }
    }
    public void close() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                    logger.log(Level.INFO, "Соединение с базой данных закрыто.");
                }
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Ошибка при закрытии соединения", e);
            }
        }
    }

}
