package activerecords;

import java.math.BigDecimal;

public class Goods implements Fillable, Cloneable {
    private final long id;
    private final String productName;
    private final ProductTypes productType;
    private final BigDecimal price;
    private Boolean isAvailable;
    private final long goodsProducerId;
    private final String goodsDescription;
    private final float rating;
    private int amount;

    public Goods(long id, String productName,
                 ProductTypes productType, BigDecimal price,
                 Boolean isAvailable, long goodsProducerId,
                 String goodsDescription, float rating, int amount) {
        this.id = id;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.isAvailable = isAvailable;
        this.goodsProducerId = goodsProducerId;
        this.goodsDescription = goodsDescription;
        this.rating = rating;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public ProductTypes getProductType() {
        return productType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public long getGoodsProducerId() {
        return goodsProducerId;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public float getRating() {
        return rating;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public long getIndex() {
        return id;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!isAvailable) {
            sb.append("Товар ")
                    .append(productName)
                    .append(" временно недоступен для заказа");
        } else {
            sb.append(id).append(" ")
                    .append(productName)
                    .append(", в наличии - ")
                    .append(amount)
                    .append(", цена - ")
                    .append(price)
                    .append("\n")
                    .append("\t")
                    .append(goodsDescription);
        }
        return sb.toString();
    }

    @Override
    public Goods clone() throws CloneNotSupportedException {
        Goods newGoods = (Goods) super.clone();
        return newGoods;
    }

    public String toStringBasket() {
        StringBuilder sb = new StringBuilder();
        sb.append(productName)
                .append(", количество - ")
                .append(amount)
                .append(", на сумму - ")
                .append(price.multiply(BigDecimal.valueOf(amount)));
        return sb.toString();
    }
}
