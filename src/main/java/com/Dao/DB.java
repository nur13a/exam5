package com.Dao;

import com.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "123";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to PostgreSQL is successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean addUser(User u) {
        String SQL = "insert into users (name, birth_date,gender,time) values (?,?,?,now())";
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(SQL);) {
            statement.setString(1, u.getName());
            statement.setInt(2, u.getBirthDate());
            statement.setString(3, u.getGender());
            statement.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUserById(int id) {
        String Sql = "select * from users where id=? ";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(Sql);) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    User u = new User();
                    u.setName(rs.getString("name"));
                    u.setBirthDate(rs.getInt("birth_date"));
                    u.setGender(rs.getString("gender"));
                    return u;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByName(String name) {
        String Sql = "select * from users where name=? ";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(Sql);) {
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    User u = new User();
                    u.setName(rs.getString("name"));
                    u.setBirthDate(rs.getInt("birth_date"));
                    u.setGender(rs.getString("gender"));
                    return u;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } public User getUserByGender(String gender) {
        String Sql = "select * from users where genser=? ";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(Sql);) {
            statement.setString(1, gender);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    User u = new User();
                    u.setName(rs.getString("name"));
                    u.setBirthDate(rs.getInt("birth_date"));
                    u.setGender(rs.getString("gender"));
                    return u;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean deleteUser(int id){
        String SQL="delete from users where id=?";
        try (Connection conn = connect();
             PreparedStatement statement = conn.prepareStatement(SQL);) {
            statement.setInt(1, id);
                statement.executeUpdate();
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        String SQL = "select * from users";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL);
        ) {
            User u = new User();
            u.setName(rs.getString("name"));
            u.setBirthDate(rs.getInt("birth_date"));
            u.setGender(rs.getString("gender"));
            list.add(u);
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
