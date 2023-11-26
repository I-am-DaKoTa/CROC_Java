package ArturKuznetsov.lab7.task13.auction;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AuctionFileReader {
    public static ArrayList<AuctionLot> readLotFile(String filePath) {
        ArrayList<AuctionLot> auctionLots = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String name;
            String line;
            while ((name = reader.readLine()) != null && (line = reader.readLine()) != null) {
                try {
                    long price = Long.parseLong(line.trim());
                    AuctionLot lot = new AuctionLot(name.trim(), price);
                    auctionLots.add(lot);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return auctionLots;
    }

    public static ArrayList<String> readParticipantFile(String filePath) {
        ArrayList<String> participantsData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                participantsData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return participantsData;
    }
}
