package strategy.payment;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Credit Card Pay ... !");
    }
}
