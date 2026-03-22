package session08.Exercise10;

public class DebitCard extends PaymentMethod{
    public DebitCard() {}

    public DebitCard(double amount) {
        super(amount);
    }

    @Override
    public double processPayment() {
        return amount + calculateFee();
    }

    @Override
    public double calculateFee() {
        return amount * 0.01;
    }

    @Override
    public String processPayment(String currency) {
        return processPayment() + " " + currency;
    }
}
