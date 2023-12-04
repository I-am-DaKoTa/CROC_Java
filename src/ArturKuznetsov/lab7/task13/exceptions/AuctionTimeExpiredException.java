package ArturKuznetsov.lab7.task13.exceptions;

public class AuctionTimeExpiredException extends Exception {
    private final String bidderName;
    private final String bid;

    public AuctionTimeExpiredException(String bidderName, String bid) {
        super(String.format("Уважаемый(ая) %s, к сожалению, время ставок закончилось для вашей ставки %s.",
                bidderName, bid));
        this.bidderName = bidderName;
        this.bid = bid;
    }

    public String getBidderName() {
        return bidderName;
    }

    public String getBid() {
        return bid;
    }
}
