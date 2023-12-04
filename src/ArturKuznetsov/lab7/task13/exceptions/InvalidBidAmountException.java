package ArturKuznetsov.lab7.task13.exceptions;

public class InvalidBidAmountException extends Exception {
    private final String bidderName;
    private final String bid;

    public InvalidBidAmountException(String bidderName, String bid) {
        super(String.format("Уважаемый(ая) %s, ваша ставка %s меньше или равна текущей максимальной ставке.",
                bidderName, bid));;
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
