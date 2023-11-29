package ArturKuznetsov.lab8.task15;

import java.sql.*;
import java.util.List;

import static ArturKuznetsov.lab8.task15.VeterinaryClinicDb.DatabaseContentViewer.*;
import static ArturKuznetsov.lab8.task15.VeterinaryClinicDb.DatabaseTableCreator.*;
import static ArturKuznetsov.lab8.task15.VeterinaryClinicDb.DatabaseTableFiller.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        args = new String[]{"src/ArturKuznetsov/lab8/task15/resources/data.csv"};

        createClientTable();
        createPetTable();
        createClientWithPetTable();

        List<List<String>> data = CvsFileReader.readCvsFile(args[0]);

        fillClientsTable(data);
        fillPetsTable(data);
        fillClientWithPetTable(data);

        System.out.println("Таблица клиентов:");
        showClientsTableContent();

        System.out.println("\nТаблица питомцев:");
        showPetsTableContent();

        System.out.println("\nТаблица клиентов и питомцев:");
        showClientWithPetTableContent();
    }
}
