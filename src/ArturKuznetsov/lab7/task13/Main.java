package ArturKuznetsov.lab7.task13;

import ArturKuznetsov.lab7.task13.auction.AuctionFileReader;
import ArturKuznetsov.lab7.task13.auction.AuctionLot;
import ArturKuznetsov.lab7.task13.auction.AuctionParticipant;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String lotFilePath = "src/ArturKuznetsov/lab7/task13/textFiles/lot.txt";
        ArrayList<AuctionLot> lots = AuctionFileReader.readLotFile(lotFilePath);
        System.out.println("Лоты аукциона:");
        for (AuctionLot lot : lots) {
            System.out.println("Лот: " + lot.getName() + ", Цена: " + lot.getStartedPrice());
        }

        String participantsFilePath = "src/ArturKuznetsov/lab7/task13/textFiles/participants.txt";
        ArrayList<String> participantsName = AuctionFileReader.readParticipantFile(participantsFilePath);
        System.out.println("\nУчастники аукциона:");
        ArrayList<AuctionParticipant> participants = new ArrayList<>();
        for (String participantName : participantsName) {
            participants.add(new AuctionParticipant(lots.get(0), participantName));
            System.out.println(participantName);
        }

        System.out.println("\n=====================================================================================\n");

        ArrayList<Thread> threads = new ArrayList<>();
        for (AuctionParticipant participant : participants) {
            Thread thread = new Thread(participant);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        String winnerName = lots.get(0).getWinnerName();
        System.out.println(winnerName);
    }
}
