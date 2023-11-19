package ArturKuznetsov.lab6.task11.exceptions;

public class InvalidDishRatingException extends RuntimeException{
    private final String nameRating;
    private final int rating;
    private final int minRating;
    private final int maxRating;

    public InvalidDishRatingException(String nameRating, int rating, int minRating, int maxRating) {
        super(String.format("Невероное значение оценки %s: %d. Значение должно быть от %d до %d",
                nameRating, rating, minRating, maxRating));
        this.nameRating = nameRating;
        this.rating = rating;
        this.minRating = minRating;
        this.maxRating = maxRating;
    }

    public String getNameRating() {
        return nameRating;
    }

    public int getRating() {
        return rating;
    }

    public int getMinRating() {
        return minRating;
    }

    public int getMaxRating() {
        return maxRating;
    }
}
