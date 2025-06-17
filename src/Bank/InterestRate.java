package Bank;

public class InterestRate {
    private final float rate;

    public InterestRate(float rate) {
        if (rate < 0 || rate > 1) {
            throw new IllegalArgumentException("Interest rate must be between 0 and 1.");
        }
        this.rate = rate;
    }

    public float getRate() {
        return rate;
    }

    public double applyTo(double amount) {
        return amount * rate;
    }
}
