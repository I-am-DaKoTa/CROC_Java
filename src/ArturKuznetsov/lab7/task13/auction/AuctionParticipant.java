package ArturKuznetsov.lab7.task13.auction;

import ArturKuznetsov.lab7.task13.exceptions.InvalidDataForBidException;

import java.util.Random;

public class AuctionParticipant implements Runnable {
    private final AuctionLot lot;
    private final String name;

    public AuctionParticipant(AuctionLot lot, String name) {
        this.lot = lot;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!lot.isAuctionFinished()) {
            long minValue = 100;
            long maxValue = 10000;
            long currentBid = lot.getCurrentPrice();
            long bidIncrement = minValue + (long) (random.nextDouble() * (maxValue - minValue));
            long bidAmount = currentBid + bidIncrement;

            try {
                lot.placeBid(bidAmount, name);
            } catch (InvalidDataForBidException e) {
                System.out.println(e.getMessage());
            }

            try {
                Thread.sleep(random.nextInt(5000) + 1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public String getName() {
        return name;
    }
}