import java.math.BigDecimal;

public class Goods {
    private final long PRODUCT_ID;
    private final String PRODUCT_NAME;
    private final ProductTypes PRODUCT_TYPE;
    protected BigDecimal price;
    protected BigDecimal lastPrice;
    protected Boolean isAvailable;
    protected GoodsProducer goodsProducer;
    protected String goodsDescription;

    public Goods(long PRODUCT_ID, String PRODUCT_NAME, ProductTypes PRODUCT_TYPE) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_TYPE = PRODUCT_TYPE;
    }


}
