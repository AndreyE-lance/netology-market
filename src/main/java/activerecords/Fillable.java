package activerecords;

public interface Fillable {
    void setAmount(int amount);
    int getAmount();
    long getIndex();
    String toStringBasket();
}
