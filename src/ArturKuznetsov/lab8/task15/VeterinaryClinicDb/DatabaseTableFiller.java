package ArturKuznetsov.lab8.task15.VeterinaryClinicDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseTableFiller {

    public static void fillClientsTable(List<List<String>> records) {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            for (List<String> client : records.stream().map(record -> record.subList(0, 4)).distinct().toList()) {
                int id = Integer.parseInt(client.get(0));
                String surname = client.get(1);
                String name = client.get(2);
                String phoneNumber = client.get(3);

                String checkClientExistence = "SELECT * FROM client WHERE id = " + id;
                ResultSet resultSet = statement.executeQuery(checkClientExistence);
                if (!resultSet.next()) {
                    String sql = "INSERT INTO client (id, surname, name, phone_number) VALUES (" +
                            id + ",'" + surname + "','" + name + "','" + phoneNumber + "')";
                    statement.executeUpdate(sql);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void fillPetsTable(List<List<String>> records) {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            for (List<String> pet : records.stream().map(record -> record.subList(4, 7)).distinct().toList()) {
                int medicalCard = Integer.parseInt(pet.get(0));
                String name = pet.get(1);
                int age = Integer.parseInt(pet.get(2));

                String checkPetExistence = "SELECT * FROM pet WHERE medical_card = " + medicalCard;
                ResultSet resultSet = statement.executeQuery(checkPetExistence);
                if (!resultSet.next()) {
                    String sql = "INSERT INTO pet (medical_card, name, age) VALUES (" +
                            medicalCard + ",'" + name + "'," + age + ")";
                    statement.executeUpdate(sql);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void fillClientWithPetTable(List<List<String>> records) {
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement()) {

            for (List<String> composition : records.stream().map(record -> List.of(record.get(0), record.get(4))).distinct().toList()) {
                int clientId = Integer.parseInt(composition.get(0));
                int petId = Integer.parseInt(composition.get(1));

                String checkCompositionExistence = "SELECT * FROM client_with_pet WHERE client_id = " + clientId + " AND pet_id = " + petId;
                ResultSet resultSet = statement.executeQuery(checkCompositionExistence);
                if (!resultSet.next()) {
                    String sql = "INSERT INTO client_with_pet (client_id, pet_id) VALUES (" + clientId + "," + petId + ")";
                    statement.executeUpdate(sql);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
