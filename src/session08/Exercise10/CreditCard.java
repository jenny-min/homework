package session08.Exercise10;

public class CreditCard extends PaymentMethod{
    public CreditCard() {}

    public CreditCard(double amount) {
        super(amount);
    }

    @Override
    public double processPayment() {
        return amount + calculateFee();
    }

    @Override
    public double calculateFee() {
        return amount * 0.02;
    }

    @Override
    public String processPayment(String currency) {
        return processPayment() + " " + currency;
    }


}
