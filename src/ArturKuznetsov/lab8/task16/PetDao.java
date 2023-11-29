package ArturKuznetsov.lab8.task16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetDao implements IPetDao {
    private final Connection connection;
    public PetDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Pet createPet(String name, Integer age, List<Client> clients) {
        String insertPetSql = "INSERT INTO pet (medical_card, name, age) VALUES (?, ?, ?)";
        String insertClientWithPetSql = "INSERT INTO client_with_pet (client_id, pet_id) VALUES (?, ?)";
        try (PreparedStatement insertPetStatement = connection.prepareStatement(insertPetSql);
             PreparedStatement insertClientWithPetStatement = connection.prepareStatement(insertClientWithPetSql)) {

            int medicalCardNumber = generateMedicalCardNumber();
            insertPetStatement.setInt(1, medicalCardNumber);
            insertPetStatement.setString(2, name);
            insertPetStatement.setInt(3, age);

            insertPetStatement.execute();

            for (Client client : clients) {
                insertClientWithPetStatement.setInt(1, client.getId());
                insertClientWithPetStatement.setInt(2, medicalCardNumber);
                insertClientWithPetStatement.execute();
            }

            return new Pet(medicalCardNumber, name, age);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pet findPet(Integer medicalCardNumber) {
        String sql = "SELECT * FROM pet WHERE medical_card = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, medicalCardNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Pet(resultSet.getInt("medical_card"), resultSet.getString("name"), resultSet.getInt("age"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pet updatePet(Pet pet) {
        String sql = "UPDATE pet SET name = ?, age = ? WHERE medical_card = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setInt(2, pet.getAge());
            preparedStatement.setInt(3, pet.getMedicalCard());

            preparedStatement.execute();

            return pet;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePet(Integer medicalCardNumber) {
        String deleteClientWithPetSql = "DELETE FROM client_with_pet WHERE pet_id = ?";
        String deletePetSql = "DELETE FROM pet WHERE medical_card = ?";
        try (PreparedStatement deleteClientWithPetStatement = connection.prepareStatement(deleteClientWithPetSql);
             PreparedStatement deletePetStatement = connection.prepareStatement(deletePetSql)) {

            deleteClientWithPetStatement.setInt(1, medicalCardNumber);
            deleteClientWithPetStatement.execute();

            deletePetStatement.setInt(1, medicalCardNumber);
            deletePetStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int generateMedicalCardNumber() {
        String maxIdSql = "SELECT MAX(medical_card) AS max_medical_card FROM pet";
        try (PreparedStatement preparedStatement = connection.prepareStatement(maxIdSql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int maxMedicalCard = resultSet.getInt("max_medical_card");
                return maxMedicalCard + 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}
