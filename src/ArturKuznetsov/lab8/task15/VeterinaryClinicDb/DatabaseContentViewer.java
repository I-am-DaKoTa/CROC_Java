package ArturKuznetsov.lab8.task15.VeterinaryClinicDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseContentViewer {

    public static void showClientsTableContent() {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM client";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String surname = resultSet.getString("surname");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");

                System.out.println("Client ID: " + id + ", Surname: " + surname +
                        ", Name: " + name + ", Phone Number: " + phoneNumber);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showPetsTableContent() {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM pet";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int medicalCard = resultSet.getInt("medical_card");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("Medical Card: " + medicalCard + ", Name: " + name + ", Age: " + age);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showClientWithPetTableContent() {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM client_with_pet";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                int petId = resultSet.getInt("pet_id");

                System.out.println("Client ID: " + clientId + ", Pet ID: " + petId);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}