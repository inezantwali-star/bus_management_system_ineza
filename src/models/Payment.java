package models;

public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod; // CASH, CARD, MOBILE
    private String paymentStatus; // PENDING, COMPLETED, FAILED

    public Payment() {}

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId     = paymentId;
        this.amount        = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "PENDING";
    }

    public boolean processPayment() {
        if (amount > 0) {
            this.paymentStatus = "COMPLETED";
            System.out.println("Payment " + paymentId + " of $" +
                    String.format("%.2f", amount) + " via " + paymentMethod + " — COMPLETED");
            return true;
        }
        this.paymentStatus = "FAILED";
        System.out.println("Payment " + paymentId + " FAILED.");
        return false;
    }

    public String getPaymentId()     { return paymentId; }
    public double getAmount()        { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }

    public void setPaymentId(String id)         { this.paymentId = id; }
    public void setAmount(double amount)        { this.amount = amount; }
    public void setPaymentMethod(String method) { this.paymentMethod = method; }
    public void setPaymentStatus(String status) { this.paymentStatus = status; }

    @Override
    public String toString() {
        return "Payment{ID='" + paymentId + "', Amount=$" + String.format("%.2f", amount) +
                ", Method='" + paymentMethod + "', Status='" + paymentStatus + "'}";
    }
}