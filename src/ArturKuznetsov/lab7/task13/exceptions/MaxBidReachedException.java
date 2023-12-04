package ArturKuznetsov.lab7.task13.exceptions;

public class MaxBidReachedException extends Exception {
    private final String bidderName;
    private final String bid;

    public MaxBidReachedException(String bidderName, String bid) {
        super(String.format("Уважаемый(ая) %s, вы уже владеете максимальной ставкой на данный лот за %s.",
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
