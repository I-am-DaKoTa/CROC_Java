package ArturKuznetsov.lab7.task13.exceptions;

public class InvalidDataForBidException extends RuntimeException {
    private final String bidderName;
    private final String bid;
    private final String problem;

    public InvalidDataForBidException(String bidderName, String bid, String problem) {
        super(String.format("Уважаемый(ая) %s, к сожалению, Ваша ставка %s не принята, так как %s",
                bidderName, bid, problem));
        this.bidderName = bidderName;
        this.bid = bid;
        this.problem = problem;
    }

    public String getBidderName() {
        return bidderName;
    }

    public String getBid() {
        return bid;
    }

    public String getProblem() {
        return problem;
    }
}
