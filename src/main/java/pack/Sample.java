package pack;

import java.sql.*;

public class Sample {

    public static void main(String[] args) throws SQLException {
        PostgresDriverManager driverManager = PostgresDriverManager.getInstance();
        Connection connection = driverManager.getConnection();
        connection.setAutoCommit(false);
        Statement statement = null;
        ResultSet resultSet = null;


        PreparedStatement preparedStatement = null;
        ResultSet preparedResultSet = null;


//        ResultSet resultSet = connection.createStatement().executeQuery("select * from postgres");
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id"));
//            System.out.println(resultSet.getString("name"));
//            System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getInt(3));
            }

            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id > ? AND id < ?");
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, 4);

            preparedResultSet = preparedStatement.executeQuery();//execueUpdate рбновить

            PreparedStatement preparedStatement1 = connection.prepareStatement("DELETE FROM pet WHERE id = 2"); // /удалить
            preparedStatement1.executeUpdate();

            while (preparedResultSet.next()) {
                System.out.print(preparedResultSet.getInt("id"));
                System.out.print(preparedResultSet.getString("name"));
//            System.out.println(resultSet.getInt("age"));
                System.out.println(preparedResultSet.getInt("age"));
            }
//           preparedStatement = connection.prepareStatement("INSERT INTO users VALUES(102, 'TestUpdate', 101)");
//            preparedStatement.executeUpdate();// добовлять

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.setAutoCommit(true);
                connection.close();
            }
        }

    }

}
