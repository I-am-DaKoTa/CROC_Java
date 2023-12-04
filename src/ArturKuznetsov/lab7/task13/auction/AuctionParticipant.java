package ArturKuznetsov.lab7.task13.auction;

import ArturKuznetsov.lab7.task13.exceptions.AuctionTimeExpiredException;
import ArturKuznetsov.lab7.task13.exceptions.InvalidBidAmountException;
import ArturKuznetsov.lab7.task13.exceptions.MaxBidReachedException;

import java.util.Random;
import java.util.logging.Logger;

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
            } catch (AuctionTimeExpiredException | InvalidBidAmountException | MaxBidReachedException e) {
                throw new RuntimeException(e);
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