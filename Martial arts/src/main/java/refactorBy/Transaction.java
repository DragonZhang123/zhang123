package refactorBy;

public class Transaction {
    private int price;
    private String currency;
    public Transaction(int price,String currency){
        this.price=price;
        this.currency=currency;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "price=" + price +
                ", currency='" + currency + '\'' +
                '}';
    }
}
