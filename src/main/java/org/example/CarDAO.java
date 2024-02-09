package org.example;

import java.sql.*;
import java.util.List;

public class CarDAO implements DAO {
    @Override
    public void insert(Car car) {
        Connection connection = null;

        connection = getConnection();
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(
                    "INSERT INTO cars(model, impl_year) VALUES (?, ?)");
            ps.setString(1, car.getModel());
            ps.setInt(2, car.getImplementationYear());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car findById(int id) {
        Connection connection = null;
        PreparedStatement ps = null;

        connection = getConnection();

        try {
            ps = connection.prepareStatement("SELECT cars.model, cars.impl_year FROM " +
                    "cars WHERE cars.id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String model = rs.getString(1);
                int year = rs.getInt(2);

                return new Car(id, model, year);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void update(int id, String model, int year) {
        Connection connection = null;
        PreparedStatement ps = null;

        connection = getConnection();

        try {
            ps = connection.prepareStatement("UPDATE cars SET model = ?, impl_year = ? WHERE id = ?");

            ps.setString(1, model);
            ps.setInt(2, year);
            ps.setInt(3, id);

            int updated = ps.executeUpdate();

            System.out.println("Values updated: " + updated);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && ps != null) {

                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement ps = null;

        connection = getConnection();

        try {

            ps = connection.prepareStatement("DELETE FROM cars WHERE id = ? ");

            ps.setInt(1, id);

            int deletedValues = ps.executeUpdate();

            System.out.println("Values deleted: " + deletedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && ps != null) {

                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void findAll() {
        Connection connection = null;
        PreparedStatement ps = null;

        connection = getConnection();

        try {
            ps = connection.prepareStatement("SELECT * FROM cars");


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                int year = rs.getInt(3);

                System.out.println(new Car(id, model, year));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && ps != null) {
                try {
                    connection.close();
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars_db", "root", "root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
