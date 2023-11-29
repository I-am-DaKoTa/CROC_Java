package ArturKuznetsov.lab8.task16;

import ArturKuznetsov.lab8.task15.CvsFileReader;
import ArturKuznetsov.lab8.task15.VeterinaryClinicDb.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ArturKuznetsov.lab8.task15.VeterinaryClinicDb.DatabaseContentViewer.*;
import static ArturKuznetsov.lab8.task15.VeterinaryClinicDb.DatabaseTableCreator.*;
import static ArturKuznetsov.lab8.task15.VeterinaryClinicDb.DatabaseTableFiller.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        args = new String[]{"src/ArturKuznetsov/lab8/task15/resources/data.csv"};
        Connection connection = DatabaseConnector.getConnection("jdbc:h2:~/vet_clinic_db", "admin", "");

        createClientTable(connection);
        createPetTable(connection);
        createClientWithPetTable(connection);

        List<List<String>> data = CvsFileReader.readCvsFile(args[0]);

        fillClientsTable(data, connection);
        fillPetsTable(data, connection);
        fillClientWithPetTable(data, connection);

        System.out.println("\n======== Начальные данные ========\n");

        System.out.println("Таблица клиентов:");
        showClientsTableContent(connection);

        System.out.println("\nТаблица питомцев:");
        showPetsTableContent(connection);

        System.out.println("\nТаблица клиентов и питомцев:");
        showClientWithPetTableContent(connection);

        System.out.println("\n========================\n");

        ClientDao clientDao = new ClientDao(connection);
        PetDao petDao = new PetDao(connection);
        ClientWithPetDao clientWithPetDao = new ClientWithPetDao(connection);

        System.out.println("\n======== createClient ========\n");
        Client client = clientDao.createClient(new Client(111, "Кузнецов", "Артур", "+12345678910"));
        showClientsTableContent(connection);

        System.out.println("\n======== updateClient ========\n");
        client.setSurname("НЕКузнецов");
        client.setName("НЕАртур");
        client.setPhoneNumber("+12345678901");
        clientDao.updateClient(client);
        showClientsTableContent(connection);

        System.out.println("\n======== findClient ========\n");
        System.out.println(clientDao.findClient(client.getId()));

        System.out.println("\n======== createPet ========\n");
        List<Client> owner = new ArrayList<>();
        owner.add(client);
        Pet pet = petDao.createPet("Динозавр", 7, owner);
        showPetsTableContent(connection);

        System.out.println("\n======== updatePet ========\n");
        pet.setName("Старый Динозавр");
        pet.setAge(8);
        petDao.updatePet(pet);
        showPetsTableContent(connection);

        System.out.println("\n======== findPet ========\n");
        System.out.println(petDao.findPet(pet.getMedicalCard()));

        System.out.println("\n======== findClientPhoneNumbersBy ========\n");
        var phoneNumbers = clientWithPetDao.findClientPhoneNumbersBy(pet);
        for (var phoneNumber: phoneNumbers) {
            System.out.println(phoneNumber);
        }

        System.out.println("\n======== getAllPetsOf ========\n");
        var pets = clientWithPetDao.getAllPetsOf(client);
        for (var currentPet: pets) {
            System.out.println(currentPet);
        }

        System.out.println("\n======== deleteClient ========\n");
        clientDao.deleteClient(client.getId());
        showClientsTableContent(connection);

        System.out.println("\n======== deletePet ========\n");
        petDao.deletePet(pet.getMedicalCard());
        showPetsTableContent(connection);

        DatabaseConnector.closeConnection(connection);
    }
}
