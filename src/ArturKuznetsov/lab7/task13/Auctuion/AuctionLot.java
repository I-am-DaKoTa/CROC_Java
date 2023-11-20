package ArturKuznetsov.lab7.task13.Auctuion;

import ArturKuznetsov.lab7.task13.exceptions.InvalidDataForBidException;
import ArturKuznetsov.lab7.task13.exceptions.WinnerIsUndecidedException;

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

    public synchronized void placeBid(long bid, String bidderName) {
        if (isAuctionFinished()) {
            throw new InvalidDataForBidException(bidderName, getFormattedNumber(bid), "время ставок закончилось.");
        }
        if (bidderName.equals(currentBidder)) {
            throw new InvalidDataForBidException(bidderName, getFormattedNumber(bid), "Вы уже владеете максимальной ставкой на данный лот.");
        }
        if (bid <= currentPrice) {
            throw new InvalidDataForBidException(bidderName, getFormattedNumber(bid), "она меньше или равна текущей максимальной ставки.");
        }

        currentPrice = bid;
        currentBidder = bidderName;
        amountOfBids++;
    }

    public synchronized boolean isAuctionFinished() {
        Instant currentTime = Instant.now();
        return currentTime.isAfter(endTime);
    }

    public synchronized String getCurrentPrice() {
        return getFormattedNumber(currentPrice);
    }

    public String getWinnerName() {
        if (!isAuctionFinished()) {
            throw new WinnerIsUndecidedException("Аукцион ещё не закончился, поэтому ещё нет победителя");
        }
        return String.format("Поздравляем! После %d ставок %s выигрывает аукцион и забирает\n%s за %s.",
                amountOfBids, currentBidder, name, getCurrentPrice());
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
