package ArturKuznetsov.lab8.task15;

import ArturKuznetsov.lab8.task15.exceptions.InvalidDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CvsFileReader {
    public static List<List<String>> readCvsFile(String csvFilePath) {
        List<List<String>> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (!isValidData(data)) {
                    throw new InvalidDataException(line);
                }
                dataList.add(Arrays.asList(data));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }

    private static boolean isValidData(String[] data) {
        /*
        <порядковый_номер_клиента:integer>
        <фамилия_клиента:string>
        <имя_клиента:string>
        <номер_телефона_клиента:string>
        <номер_мед_карты_питомца:integer>
        <имя_питомца:string>
        <возраст_питомца:integer>
         */

        if (data.length != 7) {
            return false;
        }

        String intRegex = "\\d+";
        String phoneRegex = "\\+\\d{11}";

        return data[0].matches(intRegex) &&
                !data[1].isEmpty() &&
                !data[2].isEmpty() &&
                data[3].matches(phoneRegex) &&
                data[4].matches(intRegex) &&
                !data[5].isEmpty() &&
                data[6].matches(intRegex);
    }
}
