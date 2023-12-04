package ArturKuznetsov.lab7.task13.auction;

import ArturKuznetsov.lab7.task13.exceptions.*;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;

public class AuctionLot {
    private final String name;
    private final long startedPrice;
    private long currentPrice;
    private String currentBidder;
    private final Instant endTime;
    private int amountOfBids;

    public AuctionLot(String name, long startedPrice) {
        this.name = name;
        this.startedPrice = startedPrice;
        this.currentPrice = startedPrice;
        this.endTime = Instant.now().plus(Duration.ofMinutes(1));
    }

    public void placeBid(long bid, String bidderName) throws AuctionTimeExpiredException, MaxBidReachedException, InvalidBidAmountException {
        if (isAuctionFinished()) {
            throw new AuctionTimeExpiredException(bidderName, getFormattedNumber(bid));
        }
        if (bidderName.equals(currentBidder)) {
            throw new MaxBidReachedException(bidderName, getFormattedNumber(bid));
        }
        if (bid <= currentPrice) {
            throw new InvalidBidAmountException(bidderName, getFormattedNumber(bid));
        }

        synchronized (this) {
            if (!isAuctionFinished() && bid > currentPrice && !bidderName.equals(currentBidder)) {
                currentPrice = bid;
                currentBidder = bidderName;
                amountOfBids++;
                System.out.println(amountOfBids + " " + currentBidder);
            }
        }
    }

    public boolean isAuctionFinished() {
        Instant currentTime = Instant.now();
        return currentTime.isAfter(endTime);
    }

    public long getCurrentPrice() {
        return currentPrice;
    }

    public String getFormattedCurrentPrice() {
        return getFormattedNumber(currentPrice);
    }

    public String getWinnerName() {
        if (!isAuctionFinished()) {
            throw new WinnerIsUndecidedException("Аукцион ещё не закончился, поэтому ещё нет победителя");
        }
        return String.format("Поздравляем! После %d ставок %s выигрывает аукцион и забирает\n%s за %s.",
                amountOfBids, currentBidder, name, getFormattedCurrentPrice());
    }

    public String getName() {
        return name;
    }

    public String getStartedPrice() {
        return getFormattedNumber(startedPrice);
    }
    
    private String getFormattedNumber(long number) {
        Locale russian = new Locale("ru", "RU");
        NumberFormat russianFormat = NumberFormat.getCurrencyInstance(russian);
        return russianFormat.format(number);
    }
}
