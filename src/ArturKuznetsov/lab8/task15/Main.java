package ArturKuznetsov.lab8.task15;

import ArturKuznetsov.lab8.task15.VeterinaryClinicDb.DatabaseConnector;

import java.sql.*;
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

        System.out.println("Таблица клиентов:");
        showClientsTableContent(connection);

        System.out.println("\nТаблица питомцев:");
        showPetsTableContent(connection);

        System.out.println("\nТаблица клиентов и питомцев:");
        showClientWithPetTableContent(connection);

        DatabaseConnector.closeConnection(connection);
    }
}
