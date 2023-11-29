package ArturKuznetsov.lab8.task15.VeterinaryClinicDb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTableCreator {
    private DatabaseTableCreator() {
    }

    public static void createClientTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {

            statement.execute(
                    "CREATE TABLE IF NOT EXISTS client" +
                            "(id INT PRIMARY KEY NOT NULL, " +
                            "surname VARCHAR(255) NOT NULL, " +
                            "name VARCHAR(255) NOT NULL, " +
                            "phone_number VARCHAR(12) NOT NULL UNIQUE)"
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPetTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {

            statement.execute(
                    "CREATE TABLE IF NOT EXISTS pet" +
                            "(medical_card INT PRIMARY KEY NOT NULL, " +
                            "name VARCHAR(255) NOT NULL, " +
                            "age INT NOT NULL)"
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createClientWithPetTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {

            statement.execute(
                    "CREATE TABLE IF NOT EXISTS client_with_pet(" +
                            "client_id INT NOT NULL, " +
                            "pet_id INT NOT NULL, " +
                            "PRIMARY KEY (client_id, pet_id), " +
                            "FOREIGN KEY (client_id) REFERENCES client(id), " +
                            "FOREIGN KEY (pet_id) REFERENCES pet(medical_card))"
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
