package ArturKuznetsov.lab8.task16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientWithPetDao implements IClientWithPetDao {
    private final Connection connection;
    public ClientWithPetDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<String> findClientPhoneNumbersBy(Pet pet) {
        List<String> phoneNumbers = new ArrayList<>();
        String sql = "SELECT client.phone_number " +
                "FROM client " +
                "INNER JOIN client_with_pet ON client.id = client_with_pet.client_id " +
                "WHERE client_with_pet.pet_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, pet.getMedicalCard());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                phoneNumbers.add(resultSet.getString("phone_number"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phoneNumbers;
    }

    @Override
    public List<Pet> getAllPetsOf(Client client) {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT pet.medical_card, pet.name, pet.age " +
                "FROM pet " +
                "INNER JOIN client_with_pet ON pet.medical_card = client_with_pet.pet_id " +
                "WHERE client_with_pet.client_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, client.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                pets.add(new Pet(resultSet.getInt("medical_card"), resultSet.getString("name"), resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pets;
    }
}
