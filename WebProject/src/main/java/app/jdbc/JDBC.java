package app.jdbc;

import app.entites.Friend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    private static JDBC instance = new JDBC();
    private static String url = "jdbc:postgresql://localhost:5432/notebook";
    private static String username = "postgres";
    private static String password = "The385tOloW";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public static JDBC getInstance() {
        return instance;
    }

    public void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, username, password);
    }

    public void add(Friend friend) throws SQLException {
        preparedStatement = connection.prepareStatement("INSERT INTO friends(name,password) values (?,?)");
        String friendName = friend.getFriendName();
        String friendPassword = friend.getPassword();
        preparedStatement.setString(1, friendName);
        preparedStatement.setString(2, friendPassword);
        preparedStatement.executeUpdate();
    }

    public List<String> getAll() throws SQLException {
        List<String> friendsName = new ArrayList<>();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("SELECT name from friends");
        while (resultSet.next()) {
            friendsName.add(resultSet.getString("name"));
        }
        return friendsName;
    }

    public void deleteFriend(String name) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate("DELETE from public.friends WHERE friends.name ='" + name + "'");
    }

    public void update(Friend friend) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE friends set name =?,password = ? WHERE name = ?");
        String friendName = friend.getFriendName();
        String friendPassword = friend.getPassword();
        preparedStatement.setString(1, friendName);
        preparedStatement.setString(2, friendPassword);
        preparedStatement.setString(3, friendName);
        preparedStatement.executeUpdate();
    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (statement != null) {
            preparedStatement.close();
        }
        if (statement != null) {
            connection.close();
        }
    }
}
