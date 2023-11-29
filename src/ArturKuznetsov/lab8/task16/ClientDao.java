package ArturKuznetsov.lab8.task16;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements IClientDao {
    private final Connection connection;
    public ClientDao(Connection connection) {
        this.connection = connection;
    }
    @Override
    public Client createClient(Client client) {
        String sql = "INSERT INTO client (id, surname, name, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, client.getId());
            preparedStatement.setString(2, client.getSurname());
            preparedStatement.setString(3, client.getName());
            preparedStatement.setString(4, client.getPhoneNumber());

            preparedStatement.execute();

            return client;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client findClient(Integer id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet clientResult = preparedStatement.executeQuery();

            if (clientResult.next()) {
                return new Client(clientResult.getInt("id"), clientResult.getString("surname"),
                        clientResult.getString("name"), clientResult.getString("phone_number"));
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client updateClient(Client client) {
        String sql = "UPDATE client SET surname = ?, name = ?, phone_number = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, client.getSurname());
            preparedStatement.setString(2, client.getName());
            preparedStatement.setString(3, client.getPhoneNumber());
            preparedStatement.setInt(4, client.getId());

            preparedStatement.execute();

            return client;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteClient(Integer id) {
        String deleteClientWithPetSql = "DELETE FROM client_with_pet WHERE client_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteClientWithPetSql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
