package strategy.payment;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paypal Payment ... !");
    }
}
